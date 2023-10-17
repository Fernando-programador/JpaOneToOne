package com.br.asl.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_student")
public class Students implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student")
	private Long idStudent;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "registration")
	private Boolean registration;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_course")
	private Course IdCourseFk;

	public Students() {
	}

	public Students(Long idStudent, String name, Boolean registration, Course idCourseFk) {
		this.idStudent = idStudent;
		this.name = name;
		this.registration = registration;
		IdCourseFk = idCourseFk;
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

	@Override
	public int hashCode() {
		return Objects.hash(IdCourseFk, idStudent, name, registration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return Objects.equals(IdCourseFk, other.IdCourseFk) && Objects.equals(idStudent, other.idStudent)
				&& Objects.equals(name, other.name) && Objects.equals(registration, other.registration);
	}

	@Override
	public String toString() {
		return "Students [idStudent=" + idStudent + ", name=" + name + ", registration=" + registration
				+ ", IdCourseFk=" + IdCourseFk + "]";
	}
	
	

}
