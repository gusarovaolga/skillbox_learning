import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Voter {
    private final String name;
    private final Date birthDay;
    private int countVote;

    @Override
    public boolean equals(Object obj) {
        Voter voter = (Voter) obj;
        return name.equals(voter.name) && birthDay.equals(voter.birthDay);
    }

    @Override
    public int hashCode() {
        long code = name.hashCode() + birthDay.hashCode();
        while (code > Integer.MAX_VALUE) {
            code = code / 10;
        }
        return (int) code;
    }

    public String toString() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy.MM.dd");
        return name + " (" + dayFormat.format(birthDay) + ")";
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
