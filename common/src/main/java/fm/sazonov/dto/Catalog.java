package fm.sazonov.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record Catalog(List<Book> books, List<Author> authors){
}
