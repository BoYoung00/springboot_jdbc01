package com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.jpa;

import com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository // DB 연결
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public void insert(Course course) {
        entityManager.merge(course);
    }

    public void delect(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    public Course select(long id) {
        return entityManager.find(Course.class, id);
    }
}
