package fm.sazonov.mock;

import fm.sazonov.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final List<Book> books = List.of(
            Book.builder().id("1").authorId("1").name("1").build(),
            Book.builder().id("2").authorId("2").name("2").build(),
            Book.builder().id("3").authorId("3").name("3").build(),
            Book.builder().id("4").authorId("4").name("4").build(),
            Book.builder().id("5").authorId("5").name("5").build()
    );

    public List<Book> getBooks() {
        return books;
    }
}
