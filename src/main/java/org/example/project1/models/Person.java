package org.example.project1.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty.")
    @Size(min=2,max = 30, message="Name supposed to be between 2 and 30 symbols.")
    private String name;
    @Min(value = 0,message = "Age supposed to be positive value.")
    private int age;
    public Person(){}

    public Person(int id, String name, int age, String email,String address) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
