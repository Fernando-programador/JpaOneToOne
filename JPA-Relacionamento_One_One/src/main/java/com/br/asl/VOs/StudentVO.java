package com.br.asl.VOs;

import java.io.Serializable;

import com.br.asl.models.Course;


public class StudentVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long idStudent;
	
	private String name;
	
	private Boolean registration;
	
	private Course IdCourseFk;

	public StudentVO(Long idStudent, String name, Boolean registration, Course idCourseFk) {
		this.idStudent = idStudent;
		this.name = name;
		this.registration = registration;
		IdCourseFk = idCourseFk;
	}

	public StudentVO() {
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRegistration() {
		return registration;
	}

	public void setRegistration(Boolean registration) {
		this.registration = registration;
	}

	public Course getIdCourseFk() {
		return IdCourseFk;
	}

	public void setIdCourseFk(Course idCourseFk) {
		IdCourseFk = idCourseFk;
	}

	
}
