package ru.geekbrains.domaindto.service;

import org.jooq.DSLContext;
import org.jooq.example.db.h2.tables.Book;
import org.jooq.example.db.h2.tables.records.BookRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.jooq.example.db.h2.Tables.BOOK;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    DSLContext dsl;

    @Autowired
    BookService bookService;

    @Override
    @Transactional
    public void create(int id, int authorId, String title) {
        dsl.insertInto(BOOK).set(BOOK.ID, id).set(BOOK.AUTHOR_ID, authorId).set(BOOK.TITLE, title).execute();
    }

    @Override
    public BookRecord get(int id) {
        return dsl.selectFrom(BOOK).where(BOOK.ID.eq(id)).fetchOne();
    }
}
