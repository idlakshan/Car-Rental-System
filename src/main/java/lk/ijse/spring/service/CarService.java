package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {

    void saveCar(CarDTO carDTO);

    String getRegNo();

    int getRowCount();

    ArrayList<CarDTO> getAllCars();

    void updateCarWithoutImg(CarDTO carDTO);

    CarDTO getCarById(String regId);


    void deleteCar(String regId);

}
