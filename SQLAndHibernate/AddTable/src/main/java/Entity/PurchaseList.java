package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private KeyPurchaseList key;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private Integer price;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

}
