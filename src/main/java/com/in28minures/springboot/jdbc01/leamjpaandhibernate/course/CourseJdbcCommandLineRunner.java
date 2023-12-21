package com.in28minures.springboot.jdbc01.leamjpaandhibernate.course;

import com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// 애플리케이션이 실행하면 자동으로 실행(초기화)시키는 인터페이스
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepositoty repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Now", "in28"));
        repository.save(new Course(2, "Learn AWS b", "in27"));
        repository.save(new Course(3, "Learn AWS a", "in28"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("in28"));
        System.out.println(repository.findByName("Learn AWS b"));


    }
}
