package pt.com.apiunittesting.apiunittesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pt.com.apiunittesting.apiunittesting.model.Item;
import pt.com.apiunittesting.apiunittesting.service.ItemBusinessService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService service;

    @Test
    public void shouldMockBeInitialize() {
        assertNotNull(mockMvc);
        assertNotNull(service);
    }

    @Test
    public void shouldReturnBallObject() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        String itemAsJSON = mapper
                .writeValueAsString(new Item(1l, "Ball", 10.0, 100));

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(itemAsJSON))
                .andReturn();
    }

    @Test
    public void shouldReturnBallObjectFromService() throws Exception {
        when(service.retreiveHardcodedItem())
                .thenReturn(new Item(1l, "Ball", 10.0, 100));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        String itemAsJSON = mapper
                .writeValueAsString(new Item(1l, "Ball", 10.0, 100));

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(itemAsJSON))
                .andReturn();
    }

    @Test
    public void shouldReturnAllItemsFromService() throws Exception {
        when(service.retrieveAllItems())
                .thenReturn(
                        Arrays.asList(
                                new Item(1l, "Item1", 10.0, 100),
                                new Item(2l, "Item2", 20.0, 20)));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/items")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        String itemAsJSON = mapper
                .writeValueAsString(Arrays.asList(
                        new Item(1l, "Item1", 10.0, 100),
                        new Item(2l, "Item2", 20.0, 20)));

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(itemAsJSON))
                .andReturn();
    }

}