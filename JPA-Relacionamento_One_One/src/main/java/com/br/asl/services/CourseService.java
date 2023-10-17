package com.br.asl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.asl.VOs.CourseVO;
import com.br.asl.mapper.DozerMapper;
import com.br.asl.models.Course;
import com.br.asl.repositorys.CourseRepository;
import com.br.aslexception.ResourceNotFoundException;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	
	public List<CourseVO> findByAll() {
		var entity = repository.findAll();
		var vo = DozerMapper.listMap(entity, CourseVO.class);
		vo.stream().forEach(p -> findById(p.getIdCourse()));
		return vo;
	}

	public CourseVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id " + id + " não encontrado"));
		var vo = DozerMapper.map(entity, CourseVO.class);
		return vo;
	}
	
	public CourseVO create(CourseVO course) {
		course.setIdCourse(null);
		var newCourse = DozerMapper.map(course, Course.class);
		var entity = repository.save(newCourse);
		var vo = DozerMapper.map(entity, CourseVO.class);
		return vo;
	}
	
	public CourseVO update(CourseVO course) {
		var entity = repository.findById(course.getIdCourse()).orElseThrow(()-> new ResourceNotFoundException("id "+ course.getIdCourse() +" não encontrado"));
		entity.setName(course.getName());
		entity.setHours(course.getHours());
		
		var updateCourse = repository.save(entity);
		var vo = DozerMapper.map(updateCourse, CourseVO.class);
		return vo;
	}
	
	public void deleteById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id " + id + " não encontrado."));
		
		repository.delete(entity);
	}
}
