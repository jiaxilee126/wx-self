package com.lee.self.core.dao;

import com.lee.self.core.beans.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechReposity extends JpaRepository<Tech, Integer> {
    @Override
    Optional<Tech> findById(Integer id);
}
