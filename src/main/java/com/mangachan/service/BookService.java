package com.mangachan.service;

import com.mangachan.service.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> getAllBook();

    Optional<BookDto> findById(Integer id);

    Optional<BookDto> save(BookDto bean);

    Optional<BookDto> delete(BookDto bean);
}
