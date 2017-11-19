package ru.geekbrains.oldapp.service;

import ru.geekbrains.oldapp.model.BookPrice;

/**
 * Created by admin on 15.11.2017.
 */
public interface BookService {

    BookPrice getPrice(Long id);
}
