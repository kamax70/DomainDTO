package ru.geekbrains.domaindto.service;

import org.jooq.example.db.h2.tables.records.BookRecord;
import org.springframework.transaction.annotation.Transactional;

public interface BookService {

    @Transactional
    void create(int id, int authorId, String title);

    BookRecord get(int id);
}
