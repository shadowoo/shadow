package com.guava.cache.jpa.dao;

import com.guava.cache.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by heshuanglin on 2018/4/25.
 */
public interface UserRepository extends JpaRepository<User,Integer>{


    User findByName(String name);

    User findById(int id);
}
