package com.huuduc.springsecurity.model.data;

import com.huuduc.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomeUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
//            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
//                    .username(user.get().getUsername())
//                    .password(user.get().getPassword())
//                    .roles(user.get().getRoles())
//
//                    .build();
//            return userDetails;
            return new CustomUserDetails(user.get());

        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
