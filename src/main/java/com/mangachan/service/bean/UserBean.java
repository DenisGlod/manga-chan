package com.mangachan.service.bean;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserBean {
    private Long id;
    private String email;
    private String password;
    private RoleBean role;
    private UserDataBean userData;

}
