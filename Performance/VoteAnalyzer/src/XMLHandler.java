import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

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
    private Map<Voter, Integer> voterCounts;

    public XMLHandler(SimpleDateFormat birthDayFormat, SimpleDateFormat visitDateFormat) {
        this.birthDayFormat = birthDayFormat;
        this.visitDateFormat = visitDateFormat;
        voteStationWorkTimes = new HashMap<>();
        voterCounts = new HashMap<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        try {
            if (qName.equals("voter") && voter == null) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit") && voter != null) {

                int count = voterCounts.getOrDefault(voter, 0);
                voterCounts.put(voter, count + 1);

                int station = Integer.parseInt(attributes.getValue("station"));
                Date time = visitDateFormat.parse(attributes.getValue("time"));
                WorkTime workTime = voteStationWorkTimes.get(station);
                if (workTime == null) {
                    workTime = new WorkTime();
                    voteStationWorkTimes.put(station, workTime);
                }
                workTime.addVisitTime(time.getTime());

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter")) {
            voter = null;
        }
    }

    public Map<Voter, Integer> getVoterCounts() {
        return voterCounts;
    }

    public Map<Integer, WorkTime> getVoteStationWorkTimes() {
        return voteStationWorkTimes;
    }
}
