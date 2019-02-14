package com.lee.self.core.dao;

import com.lee.self.core.beans.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeReposity extends JpaRepository<Type, Integer> {
    @Override
    Optional<Type> findById(Integer id);

    @Query(value = "select * from type ORDER BY Id DESC LIMIT 0,:num", nativeQuery = true)
    List<Type> findRecent(@Param("num") Integer num);
}
