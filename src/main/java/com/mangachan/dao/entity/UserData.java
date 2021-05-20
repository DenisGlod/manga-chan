package com.mangachan.dao.entity;

import com.mangachan.dao.auth.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
@Builder
@Data
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(length = 50)
    private String middleName;

    @Temporal(TemporalType.DATE)
    private Date age;

    @OneToOne(mappedBy = "userData", cascade = CascadeType.ALL)
    private User user;
}
