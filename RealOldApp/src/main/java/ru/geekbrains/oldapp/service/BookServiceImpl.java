package ru.geekbrains.oldapp.service;

import ru.geekbrains.oldapp.model.BookPrice;

import java.math.BigDecimal;

/**
 * Created by admin on 15.11.2017.
 */
public class BookServiceImpl implements BookService {

    @Override
    public BookPrice getPrice(Long id) {
        BookPrice bookPrice = new BookPrice();
        bookPrice.setPrice(2000d); // пусть будет 2000
        return bookPrice;
    }
}
