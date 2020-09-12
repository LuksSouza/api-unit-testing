package pt.com.apiunittesting.apiunittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock = mock(List.class);

    @Test
    void shouldReturnSize() {
        when(mock.size()).thenReturn(5);
        assertEquals(mock.size(), 5);
    }

    @Test
    void shouldReturnTwoValues() {
        when(mock.size())
                .thenReturn(5)
                .thenReturn(10);

        assertEquals(mock.size(), 5);
        assertEquals(mock.size(), 10);
    }

    @Test
    void shouldReturnIndexValue() {
        when(mock.get(0)).thenReturn("JUnit Testing");

        assertEquals(mock.get(0), "JUnit Testing");
        assertEquals(mock.get(1), null);
    }

    @Test
    void shouldReturnAValueWithAnyIndex() {
        when(mock.get(anyInt())).thenReturn("JUnit Testing");

        assertEquals(mock.get(0), "JUnit Testing");
        assertEquals(mock.get(1), "JUnit Testing");
        assertEquals(mock.get(5), "JUnit Testing");
        assertEquals(mock.get(145), "JUnit Testing");
    }

    @Test
    void shouldVerifyMethodExecution() {
        mock.get(0);
        mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    void shouldCaptureMethodArgument() {
        mock.add("SomeString");

        ArgumentCaptor capture = ArgumentCaptor.forClass(String.class);
        verify(mock).add(capture.capture());

        assertEquals("SomeString", capture.getValue());
    }

    @Test
    void shouldCaptureAllMethodArguments() {
        mock.add("SomeString1");
        mock.add("SomeString2");

        ArgumentCaptor capture = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(capture.capture());

        List allValues = capture.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

}
