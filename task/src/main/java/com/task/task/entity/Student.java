package com.task.task.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;
    private String name;
    @ManyToOne
    @JsonIgnore
    private Dept dept;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private List<Subject> subjects = new ArrayList<>();

}
