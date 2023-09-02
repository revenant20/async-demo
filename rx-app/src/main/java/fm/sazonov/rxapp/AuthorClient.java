package fm.sazonov.rxapp;

import fm.sazonov.dto.AuthorsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Utils.getUri;

@Component
@RequiredArgsConstructor
public class AuthorClient {

    private final WebClient client;

    public Mono<AuthorsResponse> getAuthors() {
        return client.get()
                .uri(getUri(AUTHORS))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AuthorsResponse.class);
    }
}
