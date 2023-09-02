package fm.sazonov.app.service.catalog;

import fm.sazonov.app.service.HttpClientAsyncService;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogAsyncHcService implements CatalogService {

    private final HttpClientAsyncService httpClientAsyncService;

    @Override
    public Catalog getCatalog() {
        var firstFuture = httpClientAsyncService.getBooks();
        var secondFuture = httpClientAsyncService.getAuthors();
        return Catalog.builder()
                .authors(secondFuture.join())
                .books(firstFuture.join())
                .build();
    }

}
