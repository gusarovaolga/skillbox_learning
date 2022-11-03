import java.util.List;
import java.util.Map;

public class PrinterResults {

    private Map<Integer, WorkTime> voteStationWorkTimes;
    private List<Voter> voters;

    public PrinterResults(Map<Integer, WorkTime> voteStationWorkTimes, List<Voter> voters) {
        this.voteStationWorkTimes = voteStationWorkTimes;
        this.voters = voters;
    }

    public void printResult() {

        System.out.println("Voting station work times: ");
        System.out.println(getWorkTimes());
        System.out.println("Duplicated voters: ");
        System.out.println(getDuplicatedVoters());
    }

    private StringBuilder getWorkTimes() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < voteStationWorkTimes.keySet().size(); i++) {
            WorkTime workTime = voteStationWorkTimes.get(i);
            result.append("\t").append(i).append(" - ").append(workTime).append("\n");
        }
        return result;
    }

    private StringBuilder getDuplicatedVoters() {
        StringBuilder result = new StringBuilder();

        for (Voter voter : voters) {
            int count = voter.getCountVote();
            if (count > 1) {
                result.append("\t").append(voter).append(" - ").append(count).append("\n");
            }
        }
        return result;
    }
}

