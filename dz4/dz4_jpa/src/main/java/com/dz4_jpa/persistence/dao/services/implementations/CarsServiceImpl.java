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
    public void listAllCarsToConsole() {
        System.out.println("ListAll:\n");
        carsRepository.findAll().forEach(elem-> System.out.println(elem.toString()));
    }

    @Override
    public List<Car> findCarsByBrandName(String brandName) {
        return carsRepository.findCarByBrandName(brandName);
    }

    @Override
    public List<Car> findCarsByBrandNameAndModelName(String brandName, String modelName) {
        return carsRepository.findCarByBrandNameAndModelName(brandName, modelName);
    }

    @Override
    public List<Car> findCarsByPriceRange(Double fromPrice, Double toPrice) {
        return carsRepository.getByPriceRange(fromPrice,toPrice);
    }
    @Override
    public void delByIdQuery(long id) {
        carsRepository.delByIdQuery(id);
    }
}
