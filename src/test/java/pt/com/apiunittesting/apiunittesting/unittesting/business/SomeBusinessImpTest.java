package pt.com.apiunittesting.apiunittesting.unittesting.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.com.apiunittesting.apiunittesting.unittesting.business.SomeBusinessImp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SomeBusinessImpTest {

    @Autowired
    private SomeBusinessImp businessImp;

    @Test
    void businessImpShouldBeInjected() {
        Assertions.assertNotNull(businessImp);
    }

    @Test
    void testShouldSumArrayOfInt() {
        int[] data = new int[] { 1,2,3 };

        Assertions.assertEquals(6, businessImp.sum(data));
    }

    @Test
    void testShouldSumArrayWithOneInt() {
        int[] data = new int[] { 1 };

        Assertions.assertEquals(1, businessImp.sum(data));
    }

    @Test
    void testShouldSumEmptyArray() {
        int[] data = new int[] { };

        Assertions.assertEquals(0, businessImp.sum(data));
    }

}