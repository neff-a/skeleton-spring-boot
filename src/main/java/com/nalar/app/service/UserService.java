package com.nalar.app.service;

import com.nalar.app.model.User;
import com.nalar.app.repository.UserRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void store(final User user) {
        if (user.getIdUser() == null) {
            user.setUuid(UUID.randomUUID().toString());
            user.setStatus("ACTIVE");
            userRepository.save(user);
        }
    }

    public User findOneByEmailAndStatus(String email, String status) {
        return userRepository.findOneByEmailAndStatus(email, status);
    }

    public User findOneByUuid(final String uuidUser) {
        return userRepository.findOneByUuid(uuidUser);
    }
}
