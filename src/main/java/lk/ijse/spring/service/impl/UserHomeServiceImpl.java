package lk.ijse.spring.service.impl;

import lk.ijse.spring.repo.UserHomeRepo;
import lk.ijse.spring.service.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class UserHomeServiceImpl implements UserHomeService {

    @Autowired
    UserHomeRepo userHomeRepo;

    @Override
    public ArrayList<String> getCarNames() {
        ArrayList<String> allCarNames = userHomeRepo.getAllCarNames();
        return allCarNames;
    }

    @Override
    public String getCarPhoto(String brand) {
        String carPhoto = userHomeRepo.getCarPhoto(brand);
        return carPhoto;
    }
}
