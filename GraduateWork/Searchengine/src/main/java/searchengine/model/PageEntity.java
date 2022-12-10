package searchengine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "page", indexes = {@Index(name = "path_index", columnList = "path")})
@Entity
public class PageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    private SiteEntity siteEntity;

    /**
     * адрес страницы от корня сайта
     */
    @Column(name = "path", columnDefinition = "TEXT", nullable = false, length = 30)
    private String path;

    @Column(name = "code")
    private int code;

    @Column(name = "content", columnDefinition = "MEDIUMTEXT")
    private String content;
}
