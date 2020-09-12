package pt.com.apiunittesting.apiunittesting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.apiunittesting.apiunittesting.model.Item;
import pt.com.apiunittesting.apiunittesting.repository.ItemRepository;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retreiveHardcodedItem() {
        return new Item(1l, "Ball", 10.0, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();

        for (Item item : items) {
            item.setValue(item.getQuantity() * item.getPrice());
        }

        return items;
    }
}