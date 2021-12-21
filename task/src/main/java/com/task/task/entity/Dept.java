package com.task.task.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int did;
    private String deptname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dept")
    private List<Student> students;

}
