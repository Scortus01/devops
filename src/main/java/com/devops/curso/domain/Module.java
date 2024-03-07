package com.devops.curso.domain;

import jakarta.persistence.*;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idModule;
    private String name;
    private String category;
    private double price;

    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    public Module() { }

    public Module(String name, String category, double price, Course course) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.course = course;
    }

    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
