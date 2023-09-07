package com.example.ProductAuth.config;

import com.example.ProductAuth.config.UserInfoDetails;
import com.example.ProductAuth.model.UserData;
import com.example.ProductAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class UserDetailasService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userInfo = userRepository.findByusername(username);
        if(userInfo==null){
            throw new UsernameNotFoundException("user name not found...");
        }
        return new UserInfoDetails(userInfo.getUsername(),userInfo.getPassword());

    }
}
