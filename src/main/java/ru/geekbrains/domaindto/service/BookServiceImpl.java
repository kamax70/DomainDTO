package ru.geekbrains.domaindto.service;

import org.jooq.DSLContext;
import org.jooq.example.db.h2.tables.pojos.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.jooq.example.db.h2.Tables.BOOK;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    DSLContext dsl;

    @Override
    @Transactional
    public void create(int id, int authorId, String title) {
        dsl.insertInto(BOOK).set(BOOK.ID, id).set(BOOK.AUTHOR_ID, authorId).set(BOOK.TITLE, title).execute();
    }

    @Override
    public Book get(int id) {
        return dsl.selectFrom(BOOK).where(BOOK.ID.eq(id)).fetchOne().into(Book.class);
    }

    @Override
    public List<Book> getAll() {
        return dsl.selectFrom(BOOK).fetchInto(Book.class);
    }
}
