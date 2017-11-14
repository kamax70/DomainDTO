package ru.geekbrains.oldapp.service;

import ru.geekbrains.oldapp.model.OldModel;

/**
 * Created by admin on 15.11.2017.
 */
public class OldServiceImpl implements OldService {
    @Override
    public OldModel oldMethod() {
        return new OldModel();
    }
}
