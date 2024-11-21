package com.Npro.DatabaseExample.dao;

import com.Npro.DatabaseExample.domain.Book;

import java.util.Optional;

public interface BookDao {

    void create(Book book);
    Optional<Book> findOne(String isbn);
}

