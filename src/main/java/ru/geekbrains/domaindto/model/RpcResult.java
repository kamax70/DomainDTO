package ru.geekbrains.domaindto.model;

import ru.geekbrains.oldapp.model.BookPrice;

/**
 * Created by admin on 20.11.2017.
 */
public class RpcResult {
    private String jsonrpc;
    private String id;
    private BookPrice result;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookPrice getResult() {
        return result;
    }

    public void setResult(BookPrice result) {
        this.result = result;
    }
}
