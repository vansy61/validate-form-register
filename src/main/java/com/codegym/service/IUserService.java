package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService  {

    void save(User user);

    void delete(User user);

    User findById(Long id);


    Page<User> findByName(String name, Pageable pageable);




}
