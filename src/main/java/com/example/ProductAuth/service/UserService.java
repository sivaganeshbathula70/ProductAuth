package com.example.ProductAuth.service;


import com.example.ProductAuth.model.UserData;
import com.example.ProductAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;



    public List<UserData> display(){
        return userRepository.findAll();
    }



    public UserData createUser(UserData userData)
    {
        return userRepository.save(userData);
    }
    public UserData findByUsername(String username)

    {

            return userRepository.findByusername(username);


        }


    public boolean findByUsername(String username,String password) {

            UserData userProduct = userRepository.findByusername(username);
            return userProduct != null && userProduct.getPassword().equals(password);

        }
    }

