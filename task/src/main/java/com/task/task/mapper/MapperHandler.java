package com.task.task.mapper;

import java.util.stream.Collectors;

import com.task.task.entity.Dept;
import com.task.task.entity.DeptAllDto;
import com.task.task.entity.DeptDto;
import com.task.task.entity.DeptDtoBasic;
import com.task.task.entity.Student;
import com.task.task.entity.StudentDto;
import com.task.task.entity.Subject;
import com.task.task.entity.SubjectDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperHandler {

  MapperHandler INSTANCE = Mappers.getMapper(MapperHandler.class);

  @Mappings({
      @Mapping(target = "name", source = "dept.deptname"),
      @Mapping(target = "studentDtos", source = "dept.students")
  })
  DeptDtoBasic modelToDto(Dept dept);

  @InheritInverseConfiguration
  Dept dtoToModel(DeptDtoBasic deptDtoBasic);

  @Mapping(target = "subjectDtos", source = "student.subjects")
  StudentDto studentToDto(Student student);

  @InheritInverseConfiguration
  Student dtoToStudent(StudentDto studentDto);

  // @Mapping(target = "studentname", source = "dept.students.name")
  default DeptDto departmentStudent(Dept dept) {

    DeptDto deptDto = new DeptDto();
    deptDto.setDid(dept.getDid());
    deptDto.setDeptname(dept.getDeptname());
    deptDto.setCountsudent(dept.getStudents().size());
    deptDto.setStudentname(dept.getStudents().stream().map(Student::getName).collect(Collectors.toList()));

    return deptDto;
  }

  @Mapping(target = "studentDtos", source = "dept.students")
  DeptAllDto deptToDeptAllDto(Dept dept);

  SubjectDto subjectToDto(Subject subject);

  @InheritInverseConfiguration
  Subject dtoToSubject(SubjectDto subjectDto);

}
