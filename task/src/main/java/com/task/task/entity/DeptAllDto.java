package com.task.task.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeptAllDto {
    private int did;
    private String deptname;
    private int countsudent;
    private List<StudentDto> studentDtos;
}
