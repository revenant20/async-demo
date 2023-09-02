package fm.sazonov.rxapp;

import fm.sazonov.dto.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static fm.sazonov.dto.Const.BOOKS;
import static fm.sazonov.dto.Utils.getUri;

@Component
@RequiredArgsConstructor
public class BookClient {

    private final WebClient client;

    public Mono<BookResponse> getBooks() {
        return client.get()
                .uri(getUri(BOOKS))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BookResponse.class);
    }
}
