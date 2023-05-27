package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
     public ResponseUtil saveDriver(@RequestBody DriverDTO driverDTO){
        driverService.saveDriver(driverDTO);
         return new ResponseUtil("200","Driver Saved Successfully..!",null);
     }

    @GetMapping
    public ResponseUtil getAllAdmin(){
        ArrayList<DriverDTO> allDrivers = driverService.getAllDrivers();
        return new ResponseUtil("200","Success",allDrivers);
    }

    @GetMapping(path = "/driverId")
    public ResponseUtil getLastDriverIdFromDbTable() {
        String lastDriverId;

        if (driverService.getDriversCount() > 0) {

            lastDriverId = driverService.getLastDriverId();
        } else {
            lastDriverId = "D-000";
        }
        return new ResponseUtil("200", "success", lastDriverId);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteDriver(@RequestParam("id") String id){
        driverService.deleteDriver(id);
        return new ResponseUtil("200","Deleted",null);
    }
}
