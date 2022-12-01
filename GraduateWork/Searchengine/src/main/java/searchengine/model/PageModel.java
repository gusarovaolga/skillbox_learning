package searchengine.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "page", indexes = {@Index(name = "path_index", columnList = "path")})
public class PageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    private SiteModel siteModel;

    @Column(name = "path", columnDefinition = "TEXT", nullable = false, length = 30)
    private String path;

    private int code;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;
}
