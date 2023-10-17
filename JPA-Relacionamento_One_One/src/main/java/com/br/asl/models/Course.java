package com.br.asl.models;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_course")
	private Long idCourse;
	
	@Column(name = "name", length = 50, unique = true, nullable = false)
	private String name;
	
	@Column(name = "hours")
	private Integer hours;

	
	public Course() {
	}


	public Course(Long idCourse, String name, Integer hours) {
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


	@Override
	public int hashCode() {
		return Objects.hash(hours, idCourse, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(hours, other.hours) && Objects.equals(idCourse, other.idCourse)
				&& Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", name=" + name + ", hours=" + hours + "]";
	}
	
	
	
	
	

}
