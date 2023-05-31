package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;



    @Override
    public void saveCar(CarDTO carDTO) {
        carRepo.save(mapper.map(carDTO, Car.class));
    }

    @Override
    public String getRegNo() {
        return carRepo.getRegNo();
    }

    @Override
    public int getRowCount() {
        return carRepo.getRowCount();

    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public void updateCarWithoutImg(CarDTO carDTO) {
        Car car = mapper.map(carDTO, Car.class);

        if (!carRepo.existsById(car.getRegId())){
            throw new RuntimeException("Car " + car.getRegId() + " Not Available to Update..!");
        }
        carRepo.updateCarWithoutImg(car.getBrand(),car.getCarType(),car.getPassengers(),car.getTransmission(),
                car.getWaiver(),car.getDayRate(),car.getKmDay(),car.getMonthRate(),car.getKmMonth(),car.getRegId());
    }

    @Override
    public CarDTO getCarById(String regId) {
        if (!carRepo.existsById(regId)) {
            throw new RuntimeException("No " + regId + " Car..!!");
        }

        return mapper.map(carRepo.findCarByRegId(regId), CarDTO.class);
    }

    @Override
    public void deleteCar(String regId) {
        if (!carRepo.existsById(regId)) {
            throw new RuntimeException("Car " + regId + " Not Available to Delete..!");
        }
        carRepo.deleteById(regId);
    }
}
