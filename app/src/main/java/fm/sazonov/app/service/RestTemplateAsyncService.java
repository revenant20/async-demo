package fm.sazonov.app.service;

import fm.sazonov.dto.Author;
import fm.sazonov.dto.AuthorsResponse;
import fm.sazonov.dto.Book;
import fm.sazonov.dto.BookResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Const.BOOKS;
import static fm.sazonov.dto.Utils.getUri;

@Service
@RequiredArgsConstructor
public class RestTemplateAsyncService {

    private final RestTemplate restTemplate;

    @Async
    @SneakyThrows
    public CompletableFuture<List<Book>> getBooks() {
        var response = restTemplate.exchange(getUri(BOOKS), HttpMethod.GET, HttpEntity.EMPTY, BookResponse.class).getBody();
        return CompletableFuture.completedFuture(response.books());
    }

    @Async
    @SneakyThrows
    public CompletableFuture<List<Author>> getAuthors() {
        var response = restTemplate.exchange(getUri(AUTHORS), HttpMethod.GET, HttpEntity.EMPTY, AuthorsResponse.class).getBody();
        return CompletableFuture.completedFuture(response.authors());
    }
}
