package com.dz5.persistence.dao.repositories;

import com.dz5.persistence.models.Car;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarsRepository extends CrudRepository<Car,Long> {

    List<Car> findCarByBrandName(String brandName);

    List<Car> findCarByBrandNameAndModelName(String brandName, String modelName);

    @Query("SELECT c FROM Car c where c.price between :pFromPrice and :pToPrice")
    List<Car> getByPriceRange(@Param("pFromPrice") Double fromCost, @Param("pToPrice") Double toCost);

    @Modifying
    @Query(value = "DELETE FROM carsmarket c where c.id = ?1", nativeQuery = true)
    void delByIdQuery(long id);
}
