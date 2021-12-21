package com.task.task.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    private int sid;
    private String name;

    private List<SubjectDto> subjectDtos = new ArrayList<>();

}
