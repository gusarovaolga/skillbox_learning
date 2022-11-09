import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;

public class Loader {
    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static final SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";

        System.out.println("Start SAX Parser...");
        long start = System.currentTimeMillis();
        long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        DBConnection.connection = DBConnection.getConnection();
        DBConnection.connection.setAutoCommit(false);
        DBConnection.preparedStatement = DBConnection.getConnection()
                .prepareStatement("INSERT INTO voters.voter_count(name, birthDate) " + "VALUES (?, ?)");

        SAXParserFactory factoryToMySQL = SAXParserFactory.newInstance();
        SAXParser parserToMySQL = factoryToMySQL.newSAXParser();
        XMLHandler handler = new XMLHandler(birthDayFormat, visitDateFormat);
        parserToMySQL.parse(new File(fileName), handler);

        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;
        System.out.println("Parsing duration: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("Usage memory for SAX parser is - " + usage);

        new PrinterResults(handler.getVoteStationWorkTimes()).printResult()
        System.out.println("Duplicated voters: ");
        DBConnection.printVoterCounts();
    }
}