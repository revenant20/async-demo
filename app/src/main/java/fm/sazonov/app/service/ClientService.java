package fm.sazonov.app.service;


import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Const.BOOKS;
import static fm.sazonov.dto.Utils.getRequest;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final HttpClient httpClient;

    private final ResponseMapper mapper;

    @SneakyThrows
    public Catalog getCatalog() {
        var bookRequest = getRequest(BOOKS);
        var bookResponse = httpClient.send(
                bookRequest,
                HttpResponse.BodyHandlers.ofByteArray()
        );
        var books = mapper.mapBooks(bookResponse.body());

        var authorRequest = getRequest(AUTHORS);
        var authorResponse = httpClient.send(
                authorRequest,
                HttpResponse.BodyHandlers.ofByteArray()
        );
        var authors = mapper.mapAuthors(
                authorResponse.body()
        );
        return Catalog.builder()
                .authors(authors)
                .books(books)
                .build();
    }

}
