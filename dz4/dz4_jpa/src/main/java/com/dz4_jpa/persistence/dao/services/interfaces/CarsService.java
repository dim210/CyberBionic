package com.dz4_jpa.persistence.dao.services.interfaces;

import com.dz4_jpa.persistence.models.Car;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarsService {
    List<Car> findAll();

    Car addCar(Car car);

    void removeCarById(long id);

    void listAllCars();

    List<Car> findCarByBrand_name(String brand_name);

    List<Car> findCarByBrand_nameAndModel_name(String brand_name, String model_name);

    List<Car> findCarsByPriceRange(@Param("pFromCost") Double fromCost, @Param("pToCost") Double toCost);
}
