package fm.sazonov.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record FrontResponse (List<Book> books, List<Author> authors){
}
