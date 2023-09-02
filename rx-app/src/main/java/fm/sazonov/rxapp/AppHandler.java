package fm.sazonov.rxapp;

import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AppHandler {

    private final BookClient bookClient;
    private final AuthorClient authorClient;

    @GetMapping
    public Mono<Catalog> catalog() {
        return Flux.zip(
                        authorClient.getAuthors(),
                        bookClient.getBooks()
                ).flatMap(tuple ->
                        Mono.just(Catalog.builder()
                                .authors(tuple.getT1().authors())
                                .books(tuple.getT2().books())
                                .build())
                )
                .single();
    }
}
