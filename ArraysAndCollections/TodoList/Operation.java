import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Operation {
    ADD("ADD"),
    EDIT("EDIT"),
    LIST("LIST"),
    DELETE("DELETE");

    private String title;

}
