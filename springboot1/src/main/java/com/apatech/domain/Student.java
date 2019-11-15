package com.apatech.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Student {
    private Integer id;//编号
    private String stuname;//姓名
    private String project;//科目
    private Double score;//分数
    @DateTimeFormat(pattern = "yyyy-MM-dd")//
    @JsonFormat(pattern = "yyyy-MM-dd")//
    private Date time;//时间

    
    
    public Student(Integer id, String stuname, String project, Double score, Date time) {
		super();
		this.id = id;
		this.stuname = stuname;
		this.project = project;
		this.score = score;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuname=" + stuname + ", project=" + project + ", score=" + score + ", time="
				+ time + "]";
	}
	
	

	public Student() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}