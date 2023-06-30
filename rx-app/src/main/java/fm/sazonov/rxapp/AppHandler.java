package fm.sazonov.rxapp;

import fm.sazonov.dto.Author;
import fm.sazonov.dto.AuthorsResponse;
import fm.sazonov.dto.FrontResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
@RequestMapping("/")
public class AppHandler {

    private final ClientComponent client;

    public AppHandler(ClientComponent client) {
        this.client = client;
    }

    @GetMapping
    public Mono<FrontResponse> hello() {
        return Flux.zip(client.getAuthors(), client.getBooks())
                .flatMap(tuple -> Mono.just(FrontResponse.builder()
                        .authors(tuple.getT1().authors())
                        .books(tuple.getT2().books())
                        .build())
                )
                .single();

    }
}
