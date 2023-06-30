package fm.sazonov.app.service;


import fm.sazonov.dto.FrontResponse;
import fm.sazonov.dto.Author;
import fm.sazonov.dto.Book;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

import static fm.sazonov.dto.Const.*;
import static fm.sazonov.dto.Utils.*;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final HttpClient httpClient;

    private final ResponseMapper mapper;

    @SneakyThrows
    public FrontResponse getFrontData() {
        var bookRequest = getRequest(BOOKS);
        var bookResponse = httpClient.send(bookRequest, HttpResponse.BodyHandlers.ofByteArray());
        List<Book> books = mapper.mapBooks(bookResponse.body());

        var authorRequest = getRequest(AUTHORS);
        var authorResponse = httpClient.send(authorRequest, HttpResponse.BodyHandlers.ofByteArray());
        List<Author> authors = mapper.mapAuthors(authorResponse.body());
        return FrontResponse.builder()
                .authors(authors)
                .books(books)
                .build();
    }

    public FrontResponse getFrontDataAsync() {
        var bookRequest = getRequest(BOOKS);
        var bookFuture = httpClient.sendAsync(bookRequest, HttpResponse.BodyHandlers.ofByteArray())
                .thenApply(mapper.mapBooks());

        var authorRequest = getRequest(AUTHORS);
        var authorFuture = httpClient.sendAsync(authorRequest, HttpResponse.BodyHandlers.ofByteArray())
                .thenApply(mapper.mapAuthors());
        return FrontResponse.builder()
                .authors(authorFuture.join())
                .books(bookFuture.join())
                .build();
    }

}
