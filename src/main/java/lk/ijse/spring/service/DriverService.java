package lk.ijse.spring.service;


import lk.ijse.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    void saveDriver(DriverDTO driverDTO);

    ArrayList<DriverDTO> getAllDrivers();

    String getLastDriverId();

    int getDriversCount();

    void deleteDriver(String id);

}
