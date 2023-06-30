package fm.sazonov.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BookResponse(List<Book> books) {
}
