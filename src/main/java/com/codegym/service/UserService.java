package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;



    public void save(User user) {
        if (emailExists(user.getEmail())) {
            throw new RuntimeException("Email already exists, please enter another email");
        }
        userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }



    @Override
    public Page<User> findByName(String name, Pageable pageable) {
        return userRepository.findByLastNameContains(name, pageable);
    }
}
