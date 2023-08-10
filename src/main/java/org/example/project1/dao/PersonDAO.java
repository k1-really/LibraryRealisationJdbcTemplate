package org.example.project1.dao;

import org.example.project1.models.Book;
import org.example.project1.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }
    public Optional<Person> show(String name){
        return jdbcTemplate.query("SELECT * FROM Person WHERE name=?",new Object[]{name}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }
    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id =?",new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }
    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person(name,age) VALUES(?,?)",person.getName(),person.getAge());
    }

    public void update(int id,Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET name=?,age=? WHERE id=?",updatedPerson.getName(),updatedPerson.getAge(),
               id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?",id);
    }

    public List<Book> getBooksByPersonId(int id){
        return jdbcTemplate.query("SELECT Book.* FROM Book WHERE Book.person_id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

}
