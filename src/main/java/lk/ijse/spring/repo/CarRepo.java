package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {

    @Query(value = "SELECT regId FROM car ORDER BY regId DESC LIMIT 1",nativeQuery = true)
    String getRegNo();

    @Query(value = "SELECT COUNT(regId) AS NumberOfCars FROM car", nativeQuery = true)
    int getRowCount();
}
