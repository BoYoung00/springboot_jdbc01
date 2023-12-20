package com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.jdbc;

import com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// 애플리케이션이 실행하면 자동으로 실행(초기화)시키는 인터페이스
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Now", "in28"));
        repository.insert(new Course(2, "Learn AWS Now", "in28"));

        repository.delect(1);

        System.out.println(repository.select(2));
    }
}
