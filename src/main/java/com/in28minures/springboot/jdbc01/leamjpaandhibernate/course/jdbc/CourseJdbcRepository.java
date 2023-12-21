package com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.jdbc;

import com.in28minures.springboot.jdbc01.leamjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // DB 연결
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
                insert into course (id, name, author) 
                values(?, ?, ?)
            """;

    private static String DELETE_QUERY =
            """
                delete from course
                where id = ?
            """;

    private static String SELECT_QUERY =
            """
                select * from course
                where id = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
        //ResultSet -> Bean => Row Mapper =>
        //값을 하나만 가져오고 싶을 때, ()안의 타입으로 자동 매핑해서 가져옴
    }
}
