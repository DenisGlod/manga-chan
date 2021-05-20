package com.mangachan.service.dto;

import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDataDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date age;

}
