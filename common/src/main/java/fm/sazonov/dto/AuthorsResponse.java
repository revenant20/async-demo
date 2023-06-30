package fm.sazonov.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AuthorsResponse(List<Author> authors) {
}
