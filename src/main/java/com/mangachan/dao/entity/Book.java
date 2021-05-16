package com.mangachan.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String binding;

    @Column(nullable = false, length = 3)
    private String ageRestrictions;

    @Column(nullable = false)
    private String isbn;

    @Column(precision = 4)
    private Integer publishingYear;

    @Column(nullable = false, length = 3000)
    private String description;

    @ManyToMany(mappedBy = "books")
    private final Set<User> users = new HashSet<>();

}
