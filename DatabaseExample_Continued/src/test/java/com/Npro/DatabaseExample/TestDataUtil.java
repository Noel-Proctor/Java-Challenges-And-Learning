package com.Npro.DatabaseExample;

import com.Npro.DatabaseExample.domain.Author;
import com.Npro.DatabaseExample.domain.Book;

public  class TestDataUtil {

    private TestDataUtil(){}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("John Marsden")
                .age(22)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("aa-bb-cc")
                .title("The Strange Life Of Gud")
                .authorId(1L)
                .build();
    }
}
