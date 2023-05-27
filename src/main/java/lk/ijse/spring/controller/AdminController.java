package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public ResponseUtil getAllAdmin(){
        ArrayList<AdminDTO> allAdmin = adminService.getAllAdmin();
        return new ResponseUtil("200","Success",allAdmin);
    }

    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO adminDTO){
        adminService.updateAdmin(adminDTO);
        return new ResponseUtil("200","Admin Successfully Updated..!",null);
    }

    @GetMapping(path = "/getAdmin/{adminEmail}/{adminPassword}")
    public ResponseUtil getAdminByEmailAndPassword(@PathVariable String adminEmail,@PathVariable String adminPassword){
        //System.out.println("Hii " +adminEmail+" " +adminPassword);
        AdminDTO admin = adminService.getAdminByEmailAndPassword(adminEmail, adminPassword);
        return new ResponseUtil("200","Login successfully",admin);
    }

}
