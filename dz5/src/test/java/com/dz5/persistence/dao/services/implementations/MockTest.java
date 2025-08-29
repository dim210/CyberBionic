package com.dz5.persistence.dao.services.implementations;

import com.dz5.persistence.dao.repositories.CarsRepository;
import com.dz5.persistence.models.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class MockTest {
    @Mock
    CarsRepository carsRepository;

    @InjectMocks
    CarsServiceImpl carsService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    static List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("volkswagen","golf 7",34000.45));
        carList.add(new Car("BMW","X3",46123.45));
    }

    @Test
    public void mockTest1(){
        when(carsRepository.findAll()).thenReturn(carList);
        Assert.assertEquals(carList,carsService.findAll());
    }
}
