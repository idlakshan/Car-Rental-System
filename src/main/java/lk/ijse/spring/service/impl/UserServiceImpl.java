package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public UserDTO getUserById(String idNo) {
        User user = userRepo.findUserByIdNo(idNo);

        if (user==null){
            throw new RuntimeException("User is not Available..!");
        }
        return mapper.map(userRepo.findUserByIdNo(idNo), UserDTO.class);
    }

    @Override
    public void addUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUserId())) {
            throw new RuntimeException("Customer " + dto.getUserId() + " Already Exists..!!");
        }
        if (userRepo.existsUserByUserName(dto.getUserName())) {
            throw new RuntimeException("Username Already Exists..!! Please Try Another One");
        }
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public void isExistsUser(String id) {
        if (userRepo.existsById(id)) {
            throw new RuntimeException("User " + id + " Already Exists..!");
        }
    }

    @Override
    public void findUserUserNameIsExists(String userName) {
        if (userRepo.existsUserByUserName(userName)) {
            throw new RuntimeException("Username Already Exists..! Please Try Another One");
        }
    }

    @Override
    public int getUsersCount() {
        return userRepo.getRowCount();
    }

    @Override
    public String getLastUserId() {
        return userRepo.getLastId();
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> all = userRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }

}
