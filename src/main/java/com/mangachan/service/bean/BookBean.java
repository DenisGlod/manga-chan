package com.mangachan.service.bean;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookBean {
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
