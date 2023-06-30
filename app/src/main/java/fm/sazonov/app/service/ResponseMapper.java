package fm.sazonov.app.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fm.sazonov.dto.Author;
import fm.sazonov.dto.AuthorsResponse;
import fm.sazonov.dto.Book;
import fm.sazonov.dto.BookResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.function.Function;

@Component
public class ResponseMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public Function<HttpResponse<byte[]>, List<Book>> mapBooks() {
        return it -> {
            try {
                return mapper.readValue(it.body(), new TypeReference<BookResponse>() {}).books();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public Function<HttpResponse<byte[]>, List<Author>> mapAuthors() {
        return it -> {
            try {
                return mapper.readValue(it.body(), new TypeReference<AuthorsResponse>() {}).authors();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public  List<Author> mapAuthors(byte[] body) {
        try {
            return mapper.readValue(body, new TypeReference<AuthorsResponse>() {}).authors();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  List<Book> mapBooks(byte[] body) {
        try {
            return mapper.readValue(body, new TypeReference<BookResponse>() {}).books();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
