package lk.ijse.spring.service;

import lk.ijse.spring.dto.UserDTO;

public interface UserService {
    void addUser(UserDTO dto);

    void isExistsUser(String id);

    void findUserUserNameIsExists(String userName);

    int getUsersCount();

    String getLastUserId();


}
