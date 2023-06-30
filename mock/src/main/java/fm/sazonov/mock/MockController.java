package fm.sazonov.mock;

import fm.sazonov.dto.AuthorsResponse;
import fm.sazonov.dto.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static fm.sazonov.dto.Const.AUTHORS;
import static fm.sazonov.dto.Const.BOOKS;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
public class MockController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping(BOOKS)
    public BookResponse getBooks() throws InterruptedException {
        Thread.sleep(2000);
        return BookResponse.builder()
                .books(bookService.getBooks())
                .build();
    }

    @GetMapping(AUTHORS)
    public AuthorsResponse getAuthors() throws InterruptedException {
        Thread.sleep(2000);
        return AuthorsResponse.builder()
                .authors(authorService.getAuthors())
                .build();
    }

}
