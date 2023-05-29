package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {

    void saveCar(CarDTO carDTO);

    String getRegNo();

    int getRowCount();

    ArrayList<CarDTO> getAllCars();

}
