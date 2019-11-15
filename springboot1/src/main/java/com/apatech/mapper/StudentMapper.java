package com.apatech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.apatech.domain.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    
    @Select("select * from student")
    List<Student> selectAll();

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}