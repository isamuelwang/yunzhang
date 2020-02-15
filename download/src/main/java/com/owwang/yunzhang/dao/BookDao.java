package com.owwang.yunzhang.dao;

import com.owwang.yunzhang.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Mapper
public interface BookDao extends JpaRepository<Book,Integer> {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}