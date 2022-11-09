import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class XMLHandler extends DefaultHandler {

    private final SimpleDateFormat birthDayFormat;
    private final SimpleDateFormat visitDateFormat;

    private Voter voter;
    private Map<Integer, WorkTime> voteStationWorkTimes;

    private int countVoters = 0;
    private int batchSize;

    public XMLHandler(SimpleDateFormat birthDayFormat, SimpleDateFormat visitDateFormat) {
        this.birthDayFormat = birthDayFormat;
        this.visitDateFormat = visitDateFormat;
        this.voteStationWorkTimes = new HashMap<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        int maxBatchSize = 5_000_000;
        if (qName.equals("voter") && batchSize < maxBatchSize) {
            Date birthday = null;
            try {
                birthday = birthDayFormat.parse(attributes.getValue("birthDay"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            voter = new Voter(attributes.getValue("name"), birthday);
        } else if (qName.equals("visit") && voter != null) {
            try {
                DBConnection.preparedStatement.setString(1, voter.getName());
                DBConnection.preparedStatement.setString(2, birthDayFormat.format(voter.getBirthDay()));
                DBConnection.preparedStatement.addBatch();
                countVoters++;

                int stationNumber = Integer.parseInt(attributes.getValue("station"));
                Date time = visitDateFormat.parse(attributes.getValue("time"));
                WorkTime workTime = voteStationWorkTimes.get(stationNumber);
                if (workTime == null) {
                    workTime = new WorkTime();
                    voteStationWorkTimes.put(stationNumber, workTime);
                }
                workTime.addVisitTime(time.getTime());

                if (countVoters > 10000) {
                    DBConnection.preparedStatement.executeBatch();
                    DBConnection.connection.commit();
                    countVoters = 0;
                }
            } catch (SQLException | ParseException ex) {
                ex.printStackTrace();
            }
            batchSize++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter")) {
            voter = null;
        }
    }
}
