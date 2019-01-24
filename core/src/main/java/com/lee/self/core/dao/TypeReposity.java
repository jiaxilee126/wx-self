package com.lee.self.core.dao;

import com.lee.self.core.beans.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeReposity extends JpaRepository<Type, Integer> {
    @Override
    Optional<Type> findById(Integer id);
}
