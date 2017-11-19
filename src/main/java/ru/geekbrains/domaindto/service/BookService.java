package ru.geekbrains.domaindto.service;

import org.jooq.example.db.h2.tables.pojos.Book;
import org.springframework.transaction.annotation.Transactional;

public interface BookService {

    @Transactional
    void create(int id, int authorId, String title);

    Book get(int id);
}
