package com.br.asl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.br.asl.VOs.StudentVO;
import com.br.asl.services.StudentService;
import com.br.asl.util.MyMediaType;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(value = "/student", 
			produces = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentVO>> findAll(){
		var student = service.findAll();
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping(value = "/student/{id}", 
			produces = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentVO> findById(@PathVariable("id")Long id){
		var student =  service.findById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PostMapping(value = "/student", 
			produces = MyMediaType.APPLICATION_JSON_VALUE, 
			consumes = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentVO> create(@RequestBody StudentVO studentVO){
		var student = service.create(studentVO);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/student/{id}", 
			produces = MyMediaType.APPLICATION_JSON_VALUE,
			consumes = MyMediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentVO> update(@RequestBody StudentVO studentVO){
		var student = service.update(studentVO);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}