package com.br.asl.VOs;

import java.io.Serializable;

import org.hibernate.boot.jaxb.hbm.internal.RepresentationModeConverter;

public class CourseVO implements Serializable{
	

	private static final long serialVersionUID = 1L;

	
	private Long idCourse;
	
	private String name;
	
	private Integer hours;
	
	

	public CourseVO() {
	}

	public CourseVO(Long idCourse, String name, Integer hours) {
		this.idCourse = idCourse;
		this.name = name;
		this.hours = hours;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	

}
