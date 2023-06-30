package fm.sazonov.app.service;

import fm.sazonov.dto.FrontResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final HttpClientAsyncService httpClientAsyncService;
    private final RestTemplateAsyncService restTemplateAsyncService;

    public FrontResponse getCatalogHC() {
        var firstFuture = httpClientAsyncService.getBooks();
        var secondFuture = httpClientAsyncService.getAuthors();
        return FrontResponse.builder()
                .authors(secondFuture.join())
                .books(firstFuture.join())
                .build();
    }

    public FrontResponse getCatalogRT() {
        var firstFuture = restTemplateAsyncService.getBooks();
        var secondFuture = restTemplateAsyncService.getAuthors();
        return FrontResponse.builder()
                .authors(secondFuture.join())
                .books(firstFuture.join())
                .build();
    }
}
