package pt.com.apiunittesting.apiunittesting.unittesting.business;

import org.springframework.stereotype.Service;
import pt.com.apiunittesting.apiunittesting.unittesting.data.SomeDataService;

import java.util.Arrays;

@Service
public class SomeBusinessImp {

    private SomeDataService someDataService;

    public int sum(int values[]) {
        return Arrays.stream(values).sum();
    }

    public int sum() {
        int [] values = someDataService.retrieveAllData();
        return Arrays.stream(values).sum();
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

}
