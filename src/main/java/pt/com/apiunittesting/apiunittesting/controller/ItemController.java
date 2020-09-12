package pt.com.apiunittesting.apiunittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.com.apiunittesting.apiunittesting.model.Item;
import pt.com.apiunittesting.apiunittesting.service.ItemBusinessService;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1l, "Ball", 10.0, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retreiveHardcodedItem();
    }

    @GetMapping("/items")
    public List<Item> retrieveAllItems() {
        return itemBusinessService.retrieveAllItems();
    }

}
