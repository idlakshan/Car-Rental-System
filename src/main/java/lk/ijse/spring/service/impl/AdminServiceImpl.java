package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        List<Admin> all = adminRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<AdminDTO>>(){}.getType());
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        if (!adminRepo.existsById(adminDTO.getAdminId())){
            throw new RuntimeException(adminDTO.getAdminId()+" Admin Not Available to Update..!");
        }
         adminRepo.save(mapper.map(adminDTO,Admin.class));


    }
}
