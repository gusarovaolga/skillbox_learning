import java.util.Map;

public class PrinterResults {

    private Map<Integer, WorkTime> voteStationWorkTimes;

    public PrinterResults(Map<Integer, WorkTime> voteStationWorkTimes) {
        this.voteStationWorkTimes = voteStationWorkTimes;
    }

    public void printResult() {
        System.out.println("Voting station work times: ");
        System.out.println(getWorkTimes());
    }

    private StringBuilder getWorkTimes() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < voteStationWorkTimes.keySet().size(); i++) {
            WorkTime workTime = voteStationWorkTimes.get(i);
            result.append("\t").append(i).append(" - ").append(workTime).append("\n");
        }
        return result;
    }
}

