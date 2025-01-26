import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void RemovingExistentElement() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Светильник", 7_000);
        Product product2 = new Product(2, "Настольная игра", 1_500);
        Product product3 = new Product(3, "Массажер", 4_200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemovingNonExistentElement() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Светильник", 7_000);
        Product product2 = new Product(2, "Настольная игра", 1_500);
        Product product3 = new Product(3, "Массажер", 4_200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(456));
    }
}
