package fm.sazonov.app.service;


import fm.sazonov.dto.Author;
import fm.sazonov.dto.Book;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Const.BOOKS;
import static fm.sazonov.dto.Utils.getRequest;

@Service
@RequiredArgsConstructor
public class HttpClientAsyncService {

    private final HttpClient httpClient;

    private final ResponseMapper mapper;

    @Async
    @SneakyThrows
    public CompletableFuture<List<Book>> getBooks() {
        var request = getRequest(BOOKS);
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray()).body();
        return CompletableFuture.completedFuture(mapper.mapBooks(response));
    }

    @Async
    @SneakyThrows
    public CompletableFuture<List<Author>> getAuthors() {
        var request = getRequest(AUTHORS);
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray()).body();
        return CompletableFuture.completedFuture(mapper.mapAuthors(response));
    }

}
