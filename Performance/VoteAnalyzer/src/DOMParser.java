import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DOMParser {

    private final SimpleDateFormat birthDayFormat;
    private final SimpleDateFormat visitDateFormat;
    private final String fileName;
    private final Map<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private final Map<Voter, Integer> voterCounts = new HashMap<>();
    private Document doc;

    public DOMParser(SimpleDateFormat birthDayFormat, SimpleDateFormat visitDateFormat, String fileName) {
        this.birthDayFormat = birthDayFormat;
        this.visitDateFormat = visitDateFormat;
        this.fileName = fileName;
    }

    public void parseFile() throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(new File(fileName));

        findEqualVoters();
        fixWorkTimes();
    }

    private void findEqualVoters() throws Exception {
        NodeList voters = doc.getElementsByTagName("voter");
        int votersCount = voters.getLength();
        for (int i = 0; i < votersCount; i++) {
            Node node = voters.item(i);
            NamedNodeMap attributes = node.getAttributes();

            String name = attributes.getNamedItem("name").getNodeValue();
            Date birthDay = birthDayFormat.parse(attributes.getNamedItem("birthDay").getNodeValue());

            Voter voter = new Voter(name, birthDay);
            Integer count = voterCounts.get(voter);
            voterCounts.put(voter, count == null ? 1 : count + 1);
        }
    }

    private void fixWorkTimes() throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();
        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();

            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            WorkTime workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }

    public Map<Integer, WorkTime> getVoteStationWorkTimes() {
        return voteStationWorkTimes;
    }

    public Map<Voter, Integer> getVoterCounts() {
        return voterCounts;
    }
}
