package com.dz4_jpa.persistence.dao.repositories;

import com.dz4_jpa.persistence.models.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarsRepository extends CrudRepository<Car,Long> {

    List<Car> findCarByBrand_name(String brand_name);

    List<Car> findCarByBrand_nameAndModel_name(String brand_name, String model_name);

    //Літера а е - это аналогія знаку * в sql запиті
    @Query("SELECT e FROM itvdn_tr.carsmarket where cost between :pFromCost and :pToCost")
    List<Car> getByPriceRange(@Param("pFromCost") Double fromCost, @Param("pToCost") Double toCost);
}
