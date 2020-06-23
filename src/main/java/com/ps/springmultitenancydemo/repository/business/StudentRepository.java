package com.ps.springmultitenancydemo.repository.business;

import com.ps.springmultitenancydemo.entity.business.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
