package fm.sazonov.app.service.catalog;

import fm.sazonov.app.service.RestTemplateClient;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogSyncRtService implements CatalogService {

    private final RestTemplateClient restTemplateService;

    @Override
    public Catalog getCatalog() {
        var books = restTemplateService.getBooks();
        var authors = restTemplateService.getAuthors();
        return Catalog.builder()
                .authors(authors)
                .books(books)
                .build();
    }

}
