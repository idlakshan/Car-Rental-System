package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping("/user")
@CrossOrigin

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/userId")
    public ResponseUtil getLastUserId() {
        String lastUserId;
        if (userService.getUsersCount() > 0) {
            lastUserId = userService.getLastUserId();
        } else {
            lastUserId = "U-000";
        }
        return new ResponseUtil("200", "success", lastUserId);
    }
    static String idImageUploadPath;
    static String licenseImageUploadPath;

    @PostMapping(path = "image/{userName}/{userId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseUtil uploadImages(@RequestPart("userRegIdCopy")MultipartFile userRegIdCopy,@RequestPart("userRegLicenseCopy") MultipartFile userRegLicenseCopy,
                                      @PathVariable String userName,
                                      @PathVariable String userId) {

        System.out.println("hello postMethod " + userName + " " + userId + " " + userRegIdCopy);


        try {
            userService.isExistsUser(userId);

            userService.findUserUserNameIsExists(userName);

            String projectPath = String.valueOf(new File("D:\\Edu\\Software Engineering\\IJSE\\Projects\\AAD CourseWork(Car Rental System)\\Easy-Car-Rental\\FrontEnd\\assets\\img\\imgUpload"));
            File uploadDir = new File(projectPath + "\\userImages");
            System.out.println(projectPath);
            uploadDir.mkdir();

            idImageUploadPath = uploadDir.getAbsolutePath() + "\\" + userRegIdCopy.getOriginalFilename();
            licenseImageUploadPath = uploadDir.getAbsolutePath() + "\\" + userRegLicenseCopy.getOriginalFilename();

            userRegIdCopy.transferTo(new File(idImageUploadPath));
            userRegLicenseCopy.transferTo(new File(licenseImageUploadPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseUtil("200", "Images Uploaded successfully..!", null);

    }

    @PostMapping
    public ResponseUtil saveUser(@RequestBody UserDTO dto) {
        System.out.println("Save User method called "+dto.getUserId());
        dto.setIdPath(idImageUploadPath);
        dto.setLicensePath(licenseImageUploadPath);
        System.out.println("User is : " + dto.toString());
        userService.addUser(dto);
        return new ResponseUtil("200", dto.toString() + " : Added", null);
    }

    @GetMapping()
    public ResponseUtil getAllUsers(){
        ArrayList<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseUtil("200","success",allUsers);
    }

    @GetMapping(path = "/getUser/{idNo}")
    public ResponseUtil getUserByIdNo(@PathVariable String idNo){
        System.out.println(idNo);

        UserDTO userById = userService.getUserById(idNo);

        return new ResponseUtil("200","success",userById);
    }

}
