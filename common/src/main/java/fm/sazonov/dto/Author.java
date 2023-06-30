package fm.sazonov.dto;

import lombok.Builder;

@Builder
public record Author(String id, String name) {
}
