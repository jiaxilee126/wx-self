package com.lee.self.core.dao;

import com.lee.self.core.beans.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressReposity extends JpaRepository<Progress, Integer> {

    @Override
    List<Progress> findAll();
}
