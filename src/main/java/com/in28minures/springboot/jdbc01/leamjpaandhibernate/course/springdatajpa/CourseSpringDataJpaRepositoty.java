package com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.springdatajpa;

import com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepositoty extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);


}
