package pt.com.apiunittesting.apiunittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.com.apiunittesting.apiunittesting.model.Item;
import pt.com.apiunittesting.apiunittesting.repository.ItemRepository;
import pt.com.apiunittesting.apiunittesting.service.ItemBusinessService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Test
    void businessImpShouldBeInjected() {
        assertNotNull(itemRepository);
        assertNotNull(itemBusinessService);
    }

    @Test
    void shouldReturnItemsWithValues() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(1l, "Item 1", 10.00, 20),
                new Item(2l, "Item 2", 5.00, 10),
                new Item(3l, "Item 3", 15.00, 2)
        ));

        List<Item> itemsFromService = itemBusinessService.retrieveAllItems();

        assertEquals(200.0, itemsFromService.get(0).getValue());
        assertEquals(50.0, itemsFromService.get(1).getValue());
        assertEquals(30.0, itemsFromService.get(2).getValue());
    }

}
