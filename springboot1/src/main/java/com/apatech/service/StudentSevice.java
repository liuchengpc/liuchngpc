package com.apatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apatech.domain.Student;
import com.apatech.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class StudentSevice {
	@Autowired
	private StudentMapper dao;

    public int deleteByPrimaryKey(Integer id) {
    	return dao.deleteByPrimaryKey(id);
    }

    public int insert(Student record) {
    	return dao.insert(record);
    }


    public int insertSelective(Student record) {
    	return dao.insertSelective(record);
    }


    public Student selectByPrimaryKey(Integer id) {
    	return dao.selectByPrimaryKey(id);
    }
    
    public List<Student> selectAll() {
    	return dao.selectAll();
    }
    
    public PageInfo<Student> selectAllpage(Integer pageNum,Integer pageSize){
    	PageHelper.startPage(pageNum, pageSize);
    	List<Student> list=dao.selectAll();
    	PageInfo<Student> page=new PageInfo<Student>(list);
    	return page;
    }


    public int updateByPrimaryKeySelective(Student record) {
    	return dao.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Student record) {
    	return dao.updateByPrimaryKey(record);
    }

}