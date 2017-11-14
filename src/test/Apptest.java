import org.jooq.example.db.h2.tables.records.BookRecord;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.geekbrains.domaindto.Application;
import ru.geekbrains.domaindto.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class Apptest {

    @Autowired
    BookService bookService;

    @Test
    public void test1() {
        bookService.create(14, 1, "test title2");
        BookRecord record = bookService.get(14);
        Assert.assertEquals("Название не соответствует", "test title", record.getTitle());
    }
}
