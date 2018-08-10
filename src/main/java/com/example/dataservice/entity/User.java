package com.example.dataservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {

	@Id
	@JsonIgnore
	private Integer userId;
	
	private String userName;
	
	@OneToMany(mappedBy = "user")
	List<Course> courses;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@JsonGetter
	public int getTotal() {
		return courses != null ?courses.size() : 0;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", courses=" + courses + "]";
	}
}
