package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDriverId())){
            throw new RuntimeException(driverDTO.getDriverId()+" Driver Already Saved..!");
        }
        Driver entity = mapper.map(driverDTO, Driver.class);
        driverRepo.save(entity);

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public String getLastDriverId() {
        return driverRepo.getLastId();
    }

    @Override
    public int getDriversCount() {
        return driverRepo.getRowCount();
    }

    @Override
    public void deleteDriver(String id) {
        if (!driverRepo.existsById(id)){
            throw new RuntimeException(id+" Driver not Available to Delete..!");
        }
        driverRepo.deleteById(id);
    }
}
