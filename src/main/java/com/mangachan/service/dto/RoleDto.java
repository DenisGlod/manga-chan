package com.mangachan.service.dto;

import com.mangachan.dao.auth.RoleEnum;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RoleDto {
    private Long id;
    private RoleEnum role;

}
