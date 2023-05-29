package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/car")
@CrossOrigin


public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/regNo")
    public ResponseUtil getRegNo(){
        String regNo;

        if (carService.getRowCount() > 0) {

            regNo = carService.getRegNo();
        } else {
            regNo = "C-000";
        }

        return new ResponseUtil("200","Success",regNo);
    }

    static String carImageUploadPath;

    @PostMapping(path = "image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImage(@RequestPart("vehicleImg") MultipartFile vehicleImg) {

        try {

            String projectPath = String.valueOf(new File("D:\\Edu\\Software Engineering\\IJSE\\Projects\\AAD CourseWork(Car Rental System)\\Easy-Car-Rental\\FrontEnd\\assets\\img\\imgUpload"));
            File uploadDir = new File(projectPath + "\\carImages");
            uploadDir.mkdir();

            carImageUploadPath = uploadDir.getAbsolutePath() + "\\" + vehicleImg.getOriginalFilename();
            vehicleImg.transferTo(new File(carImageUploadPath));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseUtil("200", "Images Uploaded successfully..!", null);

    }


    @PostMapping()
    public ResponseUtil saveCar(@RequestBody CarDTO carDTO){
        System.out.println(carDTO.toString());
        carDTO.setCarPhoto(carImageUploadPath);
        carService.saveCar(carDTO);
        return new ResponseUtil("200","Saved successfully",null);
    }

    @GetMapping
    public ResponseUtil getAllCars(){
        ArrayList<CarDTO> allCars = carService.getAllCars();
        return new ResponseUtil("200","Success",allCars);
    }
}
