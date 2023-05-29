package lk.ijse.spring.service;

import lk.ijse.spring.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    void addUser(UserDTO dto);

    void isExistsUser(String id);

    void findUserUserNameIsExists(String userName);

    int getUsersCount();

    String getLastUserId();

    public ArrayList<UserDTO> getAllUsers();


}
