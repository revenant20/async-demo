package fm.sazonov.mock;

import fm.sazonov.dto.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final List<Author> authors = List.of(
            Author.builder().id("1").name("1").build(),
            Author.builder().id("2").name("2").build(),
            Author.builder().id("3").name("3").build(),
            Author.builder().id("4").name("4").build(),
            Author.builder().id("5").name("5").build()
    );

    public List<Author> getAuthors() {
        return authors;
    }
}
