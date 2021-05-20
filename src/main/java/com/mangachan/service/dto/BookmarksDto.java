package com.mangachan.service.dto;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookmarksDto {
    private BookDto book;
    private UserDto user;

}
