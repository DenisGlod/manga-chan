package com.mangachan.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String latinName;

    @Column(nullable = false)
    private String otherName;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String tags;

    @Column(nullable = false, length = 3)
    private String ageRestrictions;

    @Column(precision = 4)
    private Integer publishingYear;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, length = 3000)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return id.equals(manga.id) && name.equals(manga.name) && Objects.equals(latinName, manga.latinName) && Objects.equals(otherName, manga.otherName) && author.equals(manga.author) && type.equals(manga.type) && tags.equals(manga.tags) && Objects.equals(ageRestrictions, manga.ageRestrictions) && Objects.equals(publishingYear, manga.publishingYear) && status.equals(manga.status) && Objects.equals(description, manga.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latinName, otherName, author, type, tags, ageRestrictions, publishingYear, status, description);
    }
}
