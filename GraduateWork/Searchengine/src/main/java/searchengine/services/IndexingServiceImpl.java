package searchengine.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import searchengine.config.Site;
import searchengine.config.SitesList;
import searchengine.model.PageEntity;
import searchengine.model.SiteEntity;
import searchengine.model.enums.Status;
import searchengine.repositories.SiteRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexingServiceImpl implements IndexingService {

    private final SitesList sitesList;

    private final SiteRepository siteRepository;

    @Override
    public void startIndexing() {
        dropSiteIndexing();

        List<SiteEntity> siteEntities = new ArrayList<>(sitesList.getSites().size());
        for (Site site : sitesList.getSites()) {
            SiteEntity siteEntity = createSiteEntity(site);

            List<PageEntity> pages = getPagesForSite(siteEntity);
            siteEntity.setPages(pages);

            siteEntities.add(siteEntity);
        }
        siteRepository.saveAll(siteEntities);
    }

    private void dropSiteIndexing() {
        siteRepository.deleteAll();
    }

    private SiteEntity createSiteEntity(Site site) {
        SiteEntity siteEntity = new SiteEntity();
        siteEntity.setName(site.getName());
        siteEntity.setUrl(siteEntity.getUrl());
        siteEntity.setStatus(Status.INDEXING);
        siteEntity.setStatusTime(LocalDateTime.now());
        return siteEntity;
    }

    private List<PageEntity> getPagesForSite(SiteEntity siteEntity) {
        return Collections.singletonList(createPageEntity(siteEntity));
    }

    private PageEntity createPageEntity(SiteEntity siteEntity) {
        PageEntity pageEntity = new PageEntity();
        pageEntity.setSiteEntity(siteEntity);
        //TODO найти как заполнять path
        String path = "path";
        pageEntity.setPath(path);
        return pageEntity;
    }


}
