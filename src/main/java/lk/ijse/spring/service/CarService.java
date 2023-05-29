package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

public interface CarService {

    void saveCar(CarDTO carDTO);

    String getRegNo();

    int getRowCount();
}
