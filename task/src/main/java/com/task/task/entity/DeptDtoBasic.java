package com.task.task.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptDtoBasic {

    private int did;
    private String name;

    private List<StudentDto> studentDtos;

}
