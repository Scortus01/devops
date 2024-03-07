package com.devops.curso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCourse;
    private String name;
    private Long numberStudents;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Module> modules;

    public Course(){ }

    public Course(String name, Long numberStudents) {
        this.name = name;
        this.numberStudents = numberStudents;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(Long numberStudents) {
        this.numberStudents = numberStudents;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
