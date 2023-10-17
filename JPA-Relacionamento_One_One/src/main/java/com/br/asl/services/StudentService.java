package com.br.asl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.asl.VOs.StudentVO;
import com.br.asl.mapper.DozerMapper;
import com.br.asl.models.Students;
import com.br.asl.repositorys.StudentRepository;
import com.br.aslexception.ResourceNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<StudentVO> findAll() {
		var entity = repository.findAll();
		var vo = DozerMapper.listMap(entity, StudentVO.class);
		vo.stream().forEach(p -> findById(p.getIdStudent()));
		return vo;
	}
	
	public StudentVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id " + id + " não encontrado."));
		var vo = DozerMapper.map(entity, StudentVO.class);
		return vo;
	}
	
	public StudentVO create(StudentVO student) {
		student.setIdStudent(null);
		var newStudent = DozerMapper.map(student, Students.class);
		var entity = repository.save(newStudent);
		var vo = DozerMapper.map(entity, StudentVO.class);
		return vo;
	}
	
	public StudentVO update(StudentVO student) {
		var entity = repository.findById(student.getIdStudent()).orElseThrow(()-> new ResourceNotFoundException("id " + student.getIdStudent() + " não encontrado."));
		entity.setName(student.getName());
		entity.setRegistration(student.getRegistration());
		entity.setIdCourseFk(student.getIdCourseFk());
		
		var newStudent = repository.save(entity);
		var vo = DozerMapper.map(newStudent, StudentVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id " + id + " não encontrado."));
		
		repository.delete(entity);
	}
}
