package fm.sazonov.app.service;

import fm.sazonov.dto.Author;
import fm.sazonov.dto.AuthorsResponse;
import fm.sazonov.dto.Book;
import fm.sazonov.dto.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Const.BOOKS;
import static fm.sazonov.dto.Utils.getUri;

@Service
@RequiredArgsConstructor
public class RestTemplateClient {

    private final RestTemplate restTemplate;

    public List<Book> getBooks() {
        var response = restTemplate.exchange(
                getUri(BOOKS),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                BookResponse.class).getBody();
        return response.books();
    }

    public List<Author> getAuthors() {
        var response = restTemplate.exchange(
                getUri(AUTHORS),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                AuthorsResponse.class).getBody();
        return response.authors();
    }
}
