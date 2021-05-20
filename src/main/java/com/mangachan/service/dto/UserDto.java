package com.mangachan.service.dto;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private RoleDto role;
    private UserDataDto userData;

}
