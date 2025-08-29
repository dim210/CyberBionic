package com.dz5.persistence.dao.services.implementations;

import com.dz5.persistence.dao.repositories.CarsRepository;
import com.dz5.persistence.dao.services.interfaces.CarsService;
import com.dz5.persistence.models.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/appContextJpaTest.xml"})

public class GetDataTest {

    static List<Car> carList = new ArrayList<>();

    static {
        Car tmpCar = new Car("volkswagen","golf7",34000.45);
        tmpCar.setId(1);
        carList.add(tmpCar);
        tmpCar = new Car("BMW","X3",46123.45);
        tmpCar.setId(2);
        carList.add(tmpCar);
    }
    @Autowired
    private CarsRepository carsRepository;


    private CarsServiceImpl carsService ;

    @Before
    public void setUp() throws Exception {
        carsService = new CarsServiceImpl();
        carsService.setCarsRepository(carsRepository);
    }

    @Test
    public void CompareRowsCount(){
        Assert.assertEquals(carList.size(),carsService.findAll().size());
    }


    @Test
    public void findAll() {
        Assert.assertNotNull(carsService.findAll());
    }

    @Test
    public void findByBrandName() {
        Assert.assertNotNull(carsService.findCarsByBrandName("volkswagen"));
        System.out.println(carsService.findCarsByBrandName("BMW"));
    }

    @Test
    public void findByBrandName2() {
        Assert.assertNotNull(carsService.findCarsByBrandName("BMW"));
        System.out.println(carsService.findCarsByBrandName("BMW"));
    }
}