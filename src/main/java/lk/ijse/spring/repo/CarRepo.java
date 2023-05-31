package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {

    @Query(value = "SELECT regId FROM car ORDER BY regId DESC LIMIT 1",nativeQuery = true)
    String getRegNo();

    @Query(value = "SELECT COUNT(regId) AS NumberOfCars FROM car", nativeQuery = true)
    int getRowCount();

    @Modifying
    @Query(value = "UPDATE car SET brand=?1, carType=?2, passengers=?3, transmission=?4,  waiver=?5, dayRate=?6, kmDay=?7, monthRate=?8, kmMonth=?9, WHERE regId=?10", nativeQuery = true)
    void updateCarWithoutImg(String brand, String carType, String passengers, String transmission, String waiver, String dayRate, String kmDay, String monthRate, String kmMonth, String regId);

    Car findCarByRegId(String regID);

}
