package com.br.asl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.asl.VOs.CourseVO;
import com.br.asl.services.CourseService;
import com.br.asl.util.MyMediaType;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping(value = "/course",
			produces = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CourseVO>> findAll(){
		var course = service.findByAll();
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@GetMapping(value = "/course/{id}",
			produces = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseVO> findById(@PathVariable("id") Long id){
		var course = service.findById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@PostMapping(value = "/course",
			produces = MyMediaType.APPLICATION_JSON_VALUE,
			consumes = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseVO> create(@RequestBody CourseVO courseVo) {
		var course = service.create(courseVo);
		return new ResponseEntity<>(course, HttpStatus.CREATED);		
	}
	
	@PutMapping(value = "/course/{id}",
			produces = MyMediaType.APPLICATION_JSON_VALUE,
			consumes = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseVO> update(@RequestBody CourseVO courseVO){
		var course = service.update(courseVO);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@DeleteMapping(value ="/course/{id}" )
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
