package com.lee.self.core.dao;

import com.lee.self.core.beans.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogReposity extends JpaRepository<Blog, Integer> {

    @Override
    List<Blog> findAll();

    @Query(value = "select * from blog ORDER BY Id DESC LIMIT 0,:num", nativeQuery = true)
    List<Blog> findRecent(@Param("num") Integer num);

    @Query(value = "select count(*) from blog where date_format(Createtime,'%Y-%m')=date_format(now(),'%Y-%m') ", nativeQuery = true)
    Integer getMonth();

    @Query(value = "select * from blog where title=:title", nativeQuery = true)
    Blog findByTitle(@Param("title") String title);
}
