package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.UserHomeService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin

public class UserHomeController {

    @Autowired
     UserHomeService service;

    @GetMapping("/name")
    public ResponseUtil getAllCarNames(){

        ArrayList<String> carNames = service.getCarNames();
        return new ResponseUtil("200","Success",carNames);
    }

    @GetMapping(params = "brand",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCarPhoto(String brand){

      //  ArrayList<CarDTO> carNames = service.getCarNames();
        String carPhoto = service.getCarPhoto(brand);
        return new ResponseUtil("200","Success",carPhoto);
    }

}
