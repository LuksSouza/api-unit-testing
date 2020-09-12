package pt.com.apiunittesting.apiunittesting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pt.com.apiunittesting.apiunittesting.model.Item;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void shouldBeNotNull() {
        assertNotNull(repository);
    }

    @Test
    public void shouldReturnAllItems() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

    @Test
    public void shouldReturnItemById() {
        Optional<Item> item = repository.findById(1l);

        assertNotNull(item.get());

        Item mockItem = new Item(1l, "Item 1", 10.00, 20);
        assertEquals(mockItem.getId(), item.get().getId());
        assertEquals(mockItem.getName(), item.get().getName());
        assertEquals(mockItem.getPrice(), item.get().getPrice());
        assertEquals(mockItem.getQuantity(), item.get().getQuantity());
    }

}