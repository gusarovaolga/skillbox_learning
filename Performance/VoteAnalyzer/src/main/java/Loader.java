import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;

public class Loader {
    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static final SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-18M.xml";

        long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        DOMParser domParser = new DOMParser(birthDayFormat, visitDateFormat, fileName);
        domParser.parseFile();
        PrinterResults printer = new PrinterResults(domParser.getVoteStationWorkTimes(), domParser.getVoterList());
        printer.printResult();
        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;

        System.out.println("Usage memory for DOM parser is - " + usage);

        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler(birthDayFormat, visitDateFormat);
        parser.parse(new File(fileName), handler);
        printer = new PrinterResults(handler.getVoteStationWorkTimes(), handler.getVoters());
        printer.printResult();
        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;

        System.out.println("Usage memory for SAX parser is - " + usage);
    }
}