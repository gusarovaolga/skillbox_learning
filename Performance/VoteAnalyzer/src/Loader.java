import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;


public class Loader {
    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static final SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-18M.xml";

        long usageMemoryForDOM = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        DOMParser domParser = new DOMParser(birthDayFormat, visitDateFormat, fileName);
        domParser.parseFile();
//        PrinterResults printer = new PrinterResults(domParser.getVoterCounts(), domParser.getVoteStationWorkTimes());
//        printer.printResult();
        usageMemoryForDOM = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usageMemoryForDOM;

        System.out.println("Usage memory for DOM parser is - " + usageMemoryForDOM);


        long usageMemoryForSAX = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler(birthDayFormat, visitDateFormat);
        parser.parse(new File(fileName), handler);
//        printer = new PrinterResults(handler.getVoterCounts(), handler.getVoteStationWorkTimes());
//        printer.printResult();
        usageMemoryForSAX = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usageMemoryForSAX;

        System.out.println("Usage memory for SAX parser is - " + usageMemoryForSAX);

    }


}