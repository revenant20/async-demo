package fm.sazonov.app.service.catalog;

import fm.sazonov.app.service.RestTemplateAsyncService;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogAsyncRtService implements CatalogService {

    private final RestTemplateAsyncService restTemplateService;

    @Override
    public Catalog getCatalog() {
        var booksFuture = restTemplateService.getBooks();
        var authorsFuture = restTemplateService.getAuthors();
        return Catalog.builder()
                .authors(authorsFuture.join())
                .books(booksFuture.join())
                .build();
    }

}
