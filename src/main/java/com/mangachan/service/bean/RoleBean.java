package com.mangachan.service.bean;

import com.mangachan.dao.entity.RoleEnum;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RoleBean {
    private Long id;
    private RoleEnum role;

}
