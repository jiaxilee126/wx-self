package com.lee.self.core.dao;

import com.lee.self.core.beans.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogReposity extends JpaRepository<Blog, Integer> {

    @Override
    List<Blog> findAll();

    @Override
    Optional<Blog> findById(Integer id);
}
