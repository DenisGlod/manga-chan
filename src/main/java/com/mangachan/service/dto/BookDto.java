package com.mangachan.service.dto;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookDto {
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String binding;
    private String ageRestrictions;
    private String isbn;
    private String description;
    private Integer publishingYear;

}
