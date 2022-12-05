package searchengine.services;

import searchengine.model.PageEntity;
import searchengine.model.SiteEntity;

public interface IndexingService {

    void indexing();

    SiteEntity saveSiteEntity();

    PageEntity savePageEntity();

    void deleteSiteEntity();
    void deletePageEntity();
}
