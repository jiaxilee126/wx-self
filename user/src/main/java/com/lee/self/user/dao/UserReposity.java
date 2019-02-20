package com.lee.self.user.dao;

import com.lee.self.user.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposity extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User findByName(@Param("username") String username);
}
