package org.example.project1.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "Name should not be empty.")
    @Size(min=2,max = 30, message="Name supposed to be between 2 and 30 symbols.")
    private String name;
    @NotEmpty(message = "Author should not be empty.")
    @Size(min=2,max = 30, message="Name supposed to be between 2 and 30 symbols.")
    private String author;
    @Min(value = 0,message = "year supposed to be positive value.")
    private int year;

    public Book() {
    }

    public Book(int id,String name,String author,int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
