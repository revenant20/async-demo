package fm.sazonov.dto;

import lombok.Builder;

@Builder
public record Book(String id, String name, String authorId){
}
