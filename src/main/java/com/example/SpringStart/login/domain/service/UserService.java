package com.example.SpringStart.login.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringStart.login.domain.model.User;
import com.example.SpringStart.login.domain.repository.UserDao;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    public boolean insert(User user){

        int rowNumber = dao.insertOne(user);

        boolean result = false;

        if(rowNumber > 0){
            result = true;
        }

        return result;
    }
}
