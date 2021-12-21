package com.task.task.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptDto {

    private int did;
    private String deptname;
    private int countsudent;
    private List<String> studentname;
}
