package com.br.asl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.asl.models.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long>{

}
