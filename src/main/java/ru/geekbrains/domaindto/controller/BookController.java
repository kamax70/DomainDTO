package ru.geekbrains.domaindto.controller;

import org.jooq.example.db.h2.tables.pojos.Book;
import org.jooq.example.db.h2.tables.records.BookRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.domaindto.model.Test;
import ru.geekbrains.domaindto.service.BookService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public Book getById(@PathVariable("id") Integer id) {
        return bookService.get(id);
    }

}
