package pt.com.apiunittesting.apiunittesting.unittesting.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.com.apiunittesting.apiunittesting.unittesting.data.SomeDataService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImpMockTest {

    @InjectMocks
    private SomeBusinessImp businessImp;

    @Mock
    private SomeDataService stubImp;

    @BeforeEach
    void config() {
        businessImp.setSomeDataService(stubImp);
    }

    @Test
    void businessImpShouldBeInjected() {
        assertNotNull(businessImp);
        assertNotNull(stubImp);
    }

    @Test
    void testShouldSumArrayOfInt() {
        when(stubImp.retrieveAllData()).thenReturn(new int[] { 1,2,3 });
        assertEquals(6, businessImp.sum());
    }

    @Test
    void testShouldSumArrayWithOneInt() {
        when(stubImp.retrieveAllData()).thenReturn(new int[] { 1 });
        assertEquals(1, businessImp.sum());
    }

    @Test
    void testShouldSumEmptyArray() {
        when(stubImp.retrieveAllData()).thenReturn(new int[] { });
        assertEquals(0, businessImp.sum());
    }

}