package com.br.asl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.asl.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
