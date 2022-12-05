package searchengine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "site")
public class SiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('INDEXING', 'INDEXED')")
    private Status status;

    @Column(name = "status_time")
    private LocalDateTime statusTime;

    @Column(name = "last_error", columnDefinition = "TEXT", nullable = false)
    private String lastError;

    @Column(name = "url", columnDefinition = "VARCHAR(255)")
    private String url;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;


    public enum Status {

        INDEXING,
        INDEXED,
        FAILED
    }

}




