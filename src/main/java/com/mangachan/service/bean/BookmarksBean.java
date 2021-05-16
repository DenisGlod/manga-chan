package com.mangachan.service.bean;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookmarksBean {
    private BookBean book;
    private UserBean user;

}
