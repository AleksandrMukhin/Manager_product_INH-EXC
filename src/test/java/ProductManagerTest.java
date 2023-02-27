import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.INH.*;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product prod = new Product(44, "Pizza ProMax", 800);
    Product bk = new Book(22, "Сказки", 700, "Пушкин");
    Product phone = new Smartphone(55, "14 ProMax", 100_000, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(prod);
        manager.add(bk);
        manager.add(phone);
    }

    @Test
    public void shouldSearchProduct() {

        Product[] expected = {bk};
        Product[] actual = manager.searchBy("Сказки");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNoProduct() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Война и мир");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMultipleProducts() {

        Product[] expected = {prod, phone};
        Product[] actual = manager.searchBy("ProMax");

        Assertions.assertArrayEquals(expected, actual);
    }
}

