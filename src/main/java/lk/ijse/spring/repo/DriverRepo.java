package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "SELECT driverId FROM driver ORDER BY driverId DESC LIMIT 1",nativeQuery = true)
    String getLastId();

    @Query(value = "SELECT COUNT(driverId) AS NumberOfDrivers FROM driver", nativeQuery = true)
    int getRowCount();
}
