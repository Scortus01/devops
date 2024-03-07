package com.devops.curso.dao;

import com.devops.curso.domain.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDAO extends CrudRepository<Course, Long> { }
