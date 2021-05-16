package com.mangachan.service.bean;

import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDataBean {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date age;

}
