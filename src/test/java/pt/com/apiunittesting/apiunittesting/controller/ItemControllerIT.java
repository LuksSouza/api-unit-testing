package pt.com.apiunittesting.apiunittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void shouldNotBeNull() {
        assertNotNull(template);
    }

    @Test
    public void shouldReturnAllItems() throws JSONException {
        final String items = template.getForObject("/items", String.class);

        JSONAssert.assertEquals("[{id:1}, {id:2}, {id:3}]", items, false);
    }

}