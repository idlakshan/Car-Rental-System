package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface UserHomeRepo extends JpaRepository<Car,String> {

    @Query(value = "SELECT brand FROM car", nativeQuery = true)
    ArrayList<String> getAllCarNames();

    @Query(value ="SELECT carPhoto FROM car Where brand=?1 ",nativeQuery = true)
    String getCarPhoto(String brand);


}
