package com.dz5.persistence.dao.services.interfaces;

import com.dz5.persistence.models.Car;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarsService {
    List<Car> findAll();

    Car addCar(Car car);

    void removeCarById(long id);

    void listAllCarsToConsole();

    List<Car> findCarsByBrandName(String brandName);

    List<Car> findCarsByBrandNameAndModelName(String brandName, String modelName);

    List<Car> findCarsByPriceRange(@Param("pFromPrice") Double fromPrice, @Param("pToPrice") Double toPrice);

    void delByIdQuery(long id);
}
