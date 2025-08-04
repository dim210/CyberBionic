package com.dz4_jpa.persistence.dao.services.implementations;

import com.dz4_jpa.persistence.dao.repositories.CarsRepository;
import com.dz4_jpa.persistence.dao.services.interfaces.CarsService;
import com.dz4_jpa.persistence.models.Car;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    private CarsRepository carsRepository;
    @Autowired //DI
    public void setCarsRepository(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carsRepository.findAll());
    }

    @Override
    public Car addCar(Car car) {
        return carsRepository.save(car);
    }

    @Override
    public void removeCarById(long id) {
        carsRepository.deleteById(id);
    }

    @Override
    public void listAllCars() {
        System.out.println("ListAll:\n");
        carsRepository.findAll().forEach(elem-> System.out.println(elem.toString()));
    }

    @Override
    public List<Car> findCarByBrand_name(String brand_name) {
        return carsRepository.findCarByBrand_name(brand_name);
    }

    @Override
    public List<Car> findCarByBrand_nameAndModel_name(String brand_name, String model_name) {
        return carsRepository.findCarByBrand_nameAndModel_name(brand_name,model_name);
    }

    @Override
    public List<Car> findCarsByPriceRange(Double fromCost, Double toCost) {
        return carsRepository.getByPriceRange(fromCost,toCost);
    }
}
