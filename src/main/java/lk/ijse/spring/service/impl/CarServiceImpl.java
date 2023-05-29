package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
