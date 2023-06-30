package fm.sazonov.rxapp;

import fm.sazonov.dto.AuthorsResponse;
import fm.sazonov.dto.Book;
import fm.sazonov.dto.BookResponse;
import fm.sazonov.dto.Utils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Const.BOOKS;
import static fm.sazonov.dto.Utils.*;

@Component
public class ClientComponent {

    private final WebClient client;

    public ClientComponent(WebClient client) {
        this.client = client;
    }

    public Mono<BookResponse> getBooks() {
        return client.get()
                .uri(getUri(BOOKS)).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BookResponse.class);
    }

    public Mono<AuthorsResponse> getAuthors() {
        return client.get()
                .uri(getUri(AUTHORS)).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AuthorsResponse.class);
    }
}
