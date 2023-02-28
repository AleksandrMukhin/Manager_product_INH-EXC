import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.INH.*;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product prod = new Product(33, "Pizza", 800);
    Product bk = new Book(22, "Сказки", 700, "Пушкин");
    Product phone = new Smartphone(55, "14 ProMax", 100_000, "Apple");

    @Test
    public void shouldSaveOneProduct() {

        repo.save(phone);

        Product[] expected = {phone};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAllProduct() {

        repo.save(prod);
        repo.save(bk);
        repo.save(phone);

        Product[] expected = {prod, bk, phone};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDoNotAddProduct() {

        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllRemoveById() {

        repo.save(prod);
        repo.save(bk);
        repo.save(phone);

        repo.removeById(33);
        repo.removeById(22);
        repo.removeById(55);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdProduct() {

        repo.save(prod);
        repo.save(bk);
        repo.save(phone);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
            repo.removeById(43);
            repo.removeById(76);
        });
    }


    @Test
    public void RemoveById() {

        repo.save(prod);
        repo.save(bk);
        repo.save(phone);

        repo.removeById(22);

        Product[] expected = {prod, phone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveByIdNonExistentProduct() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(50);
        });
    }
}
