package ru.geekbrains.oldapp;

import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.geekbrains.oldapp.service.BookService;
import ru.geekbrains.oldapp.service.BookServiceImpl;

/**
 * Created by admin on 15.11.2017.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public BookService myService() {
        return new BookServiceImpl();
    }

    @Bean(name = "/rpc/oldBookPriceService")
    public JsonServiceExporter jsonServiceExporter() {
        JsonServiceExporter exporter = new JsonServiceExporter();
        exporter.setService(myService());
        exporter.setServiceInterface(BookService.class);
        return exporter;
    }
}
