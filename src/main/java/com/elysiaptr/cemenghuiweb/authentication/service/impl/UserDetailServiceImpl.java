package com.elysiaptr.cemenghuiweb.authentication.service.impl;

import com.elysiaptr.cemenghuiweb.authentication.dto.LoginUser;
import com.elysiaptr.cemenghuiweb.authentication.dto.LoginUserDto;
import com.elysiaptr.cemenghuiweb.authentication.dto.UserDto;
//import com.elysiaptr.cemenghuiweb.web.po.User;
import com.elysiaptr.cemenghuiweb.web.po.User;
import com.elysiaptr.cemenghuiweb.web.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
//        LoginUserDto user1 = new LoginUserDto();
//        user1.setUsername("admin");
//        user1.setPassword(passwordEncoder.encode("admin"));
//        System.out.println(passwordEncoder.encode("admin"));
//        return new LoginUser(user1);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setUsername(user.getUsername());
        loginUserDto.setPassword(user.getPassword());
        return new LoginUser(loginUserDto);
    }
}
