package com.Npro.DatabaseExample.dao;

import com.Npro.DatabaseExample.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}
