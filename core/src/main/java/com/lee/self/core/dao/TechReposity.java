package com.lee.self.core.dao;

import com.lee.self.core.beans.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechReposity extends JpaRepository<Tech, Integer> {
    @Override
    Optional<Tech> findById(Integer id);

    @Query(value = "select * from tech ORDER BY Id DESC LIMIT 0,:num", nativeQuery = true)
    List<Tech> findRecent(@Param("num") Integer num);

    @Query(value = "select * from tech where Title = :title", nativeQuery = true)
    Tech findByTitle(@Param("title") String title);
}
