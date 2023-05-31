package lk.ijse.spring.service;


import java.util.ArrayList;

public interface UserHomeService {
    ArrayList<String> getCarNames();

    String getCarPhoto(String brand);

}
