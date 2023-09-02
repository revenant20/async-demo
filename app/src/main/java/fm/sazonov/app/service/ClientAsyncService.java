package fm.sazonov.app.service;


import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Const.BOOKS;
import static fm.sazonov.dto.Utils.getRequest;

@Service
@RequiredArgsConstructor
public class ClientAsyncService {

    private final HttpClient httpClient;

    private final ResponseMapper mapper;

public Catalog getCatalog() {
    var bookRequest = getRequest(BOOKS);
    var bookFuture = httpClient.sendAsync(
            bookRequest,
            HttpResponse.BodyHandlers.ofByteArray()
    ).thenApply(mapper.mapBooks());

    var authorRequest = getRequest(AUTHORS);
    var authorFuture = httpClient.sendAsync(
            authorRequest,
            HttpResponse.BodyHandlers.ofByteArray()
    ).thenApply(mapper.mapAuthors());
    return Catalog.builder()
            .authors(authorFuture.join())
            .books(bookFuture.join())
            .build();
}

}
