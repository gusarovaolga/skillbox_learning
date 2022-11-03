import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XMLHandler extends DefaultHandler {

    private final SimpleDateFormat birthDayFormat;
    private final SimpleDateFormat visitDateFormat;

    private Voter voter;
    private Map<Integer, WorkTime> voteStationWorkTimes;
    private List<Voter> voters;
    private boolean isVoterExist;

    public XMLHandler(SimpleDateFormat birthDayFormat, SimpleDateFormat visitDateFormat) {
        this.birthDayFormat = birthDayFormat;
        this.visitDateFormat = visitDateFormat;
        voteStationWorkTimes = new HashMap<>();
        voters = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        try {
            if (qName.equals("voter") && voter == null) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                String voterName = attributes.getValue("name");
                voter = findVoterOrCreateNew(voterName, birthDay);

            } else if (qName.equals("visit") && voter != null) {

                int count = voter.getCountVote();
                voter.setCountVote(count + 1);

                if (!isVoterExist) {
                    voters.add(voter);
                }

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

    private Voter findVoterOrCreateNew(String voterName, Date birthDay) {
        for(Voter v : voters) {
            if(v.getName().equals(voterName) ){
                voter = v;
                isVoterExist = true;
                return voter;
            }
        }
        voter = new Voter(voterName, birthDay);
        isVoterExist = false;
        return voter;
    }

    public List<Voter> getVoters() {
        return voters;
    }

    public Map<Integer, WorkTime> getVoteStationWorkTimes() {
        return voteStationWorkTimes;
    }
}
