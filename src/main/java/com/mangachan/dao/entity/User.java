package com.mangachan.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_userdata_id", columnNames = "userdata_id")}
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 30)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_role_id"))
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userdata_id", nullable = false, foreignKey = @ForeignKey(name = "fk_userdata_id"))
    private UserData userData;

    @ManyToMany
    @JoinTable(
            name = "bookmarks",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id")),
            inverseJoinColumns = @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "fk_book_id"))
    )
    private final Set<Book> books = new HashSet<>();
}
