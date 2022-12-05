package searchengine.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import searchengine.config.Site;
import searchengine.config.SitesList;
import searchengine.model.PageEntity;
import searchengine.model.SiteEntity;
import searchengine.repositories.PageRepository;
import searchengine.repositories.SiteRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class IndexingServiceImpl implements IndexingService{

    private SitesList sitesList;

    private PageRepository pageRepository;
    private SiteRepository siteRepository;

    @Override
    public void indexing() {

        for(Site site : sitesList.getSites()) {

        }

    }

    @Override
    public SiteEntity saveSiteEntity() {

        SiteEntity siteEntity = createSiteEntity();


        return siteRepository.save(siteEntity);
    }

    @Override
    public PageEntity savePageEntity() {
        return pageRepository.save(pageEntity);
    }

    @Override
    public void deleteSiteEntity() {
       siteRepository.deleteAll();
    }

    @Override
    public void deletePageEntity() {
        pageRepository.deleteAll();
    }

    private SiteEntity createSiteEntity(Site site) {
        SiteEntity siteEntity = new SiteEntity();

        siteEntity.setUrl(site.getUrl());
        siteEntity.setName(site.getName());
        siteEntity.setStatus(SiteEntity.Status.INDEXING);
        siteEntity.setStatusTime(LocalDateTime.now());




        return siteEntity;
    }


}
