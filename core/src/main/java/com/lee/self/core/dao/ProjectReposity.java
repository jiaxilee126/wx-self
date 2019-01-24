package com.lee.self.core.dao;

import com.lee.self.core.beans.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectReposity extends JpaRepository<Project, Integer> {

    @Override
    List<Project> findAll();

    @Override
    Optional<Project> findById(Integer id);
}
