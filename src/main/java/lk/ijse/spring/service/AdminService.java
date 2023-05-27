package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;

import java.util.ArrayList;

public interface AdminService {

    public ArrayList<AdminDTO> getAllAdmin();

    public void updateAdmin(AdminDTO adminDTO);
}
