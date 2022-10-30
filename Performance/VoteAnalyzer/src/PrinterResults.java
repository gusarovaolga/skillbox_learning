import java.util.Map;

public class PrinterResults {

    private Map<Voter, Integer> voterCounts;
    private Map<Integer, WorkTime> voteStationWorkTimes;

    public PrinterResults(Map<Voter, Integer> voterCounts, Map<Integer, WorkTime> voteStationWorkTimes) {
        this.voterCounts = voterCounts;
        this.voteStationWorkTimes = voteStationWorkTimes;
    }

    public void printResult() {

        System.out.println("Voting station work times: ");
        System.out.println(getWorkTimes());
        System.out.println("Duplicated voters: ");
        System.out.println(getDuplicatedVoters());
    }

    private StringBuilder getWorkTimes() {
        StringBuilder result = new StringBuilder();
        for (Integer votingStation : voteStationWorkTimes.keySet()) {
            WorkTime workTime = voteStationWorkTimes.get(votingStation);
            result.append("\t").append(votingStation).append(" - ").append(workTime).append("\n");
        }
        return result;
    }

    private StringBuilder getDuplicatedVoters() {
        StringBuilder result = new StringBuilder();
        for (Voter voter : voterCounts.keySet()) {
            Integer count = voterCounts.get(voter);
            if (count > 1) {
                result.append("\t").append(voter).append(" - ").append(count).append("\n");
            }
        }
        return result;
    }
}
