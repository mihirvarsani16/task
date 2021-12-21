package com.task.task.services;

import com.task.task.entity.Dept;
import com.task.task.entity.DeptAllDto;
import com.task.task.entity.DeptDto;
import com.task.task.entity.DeptDtoBasic;
import com.task.task.entity.Student;
import com.task.task.entity.StudentDto;
import com.task.task.entity.StudentToDept;
import com.task.task.entity.Subject;
import com.task.task.entity.SubjectDto;
import com.task.task.mapper.MapperHandler;
import com.task.task.repository.DeptRepository;
import com.task.task.repository.StudentRepository;
import com.task.task.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptAndStudentService {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MapperHandler mapperHandler;

    public Dept addDept(DeptDtoBasic deptDtoBasic) {
        Dept dept = this.mapperHandler.dtoToModel(deptDtoBasic);
        return this.deptRepository.save(dept);
    }

    // addstudent
    public Student addStudent(StudentDto studentDto) {
        Student student = this.mapperHandler.dtoToStudent(studentDto);
        return this.studentRepository.save(student);
    }

    public DeptDto depToStudent(StudentToDept studentToDept) {
        Dept dept = this.deptRepository.findBydeptname(studentToDept.getName());

        for (Integer i : studentToDept.getSid()) {
            Student student = this.studentRepository.findBySid(i);
            student.setDept(dept);
            dept.getStudents().add(student);
        }
        this.deptRepository.save(dept);

        return this.mapperHandler.departmentStudent(dept);

    }

    public DeptDto getDept(int id) {
        Dept dept = this.deptRepository.findByDid(id);
        return this.mapperHandler.departmentStudent(dept);
    }

    // add subject
    public Subject addsubject(SubjectDto subjectDto) {

        Subject subject = this.mapperHandler.dtoToSubject(subjectDto);

        return this.subjectRepository.save(subject);
    }

    // enroll subject
    public StudentDto enrollSubject(int sid, int said) throws Exception {

        Student student = this.studentRepository.findBySid(sid);
        Subject subject = this.subjectRepository.findBySaid(said);

        if (student == null) {
            throw new Exception("not found");
        } else {
            subject.enrollSubject(student);
            this.subjectRepository.save(subject);
            StudentDto studentDto = this.mapperHandler.studentToDto(student);
            return studentDto;
        }

    }

    // get student
    public StudentDto getStudent(int id) {
        Student student = this.studentRepository.findBySid(id);

        return this.mapperHandler.studentToDto(student);
    }

    // get ALL detailof Department

    public DeptAllDto getDeptAllDetail(int id) {
        Dept dept = this.deptRepository.findByDid(id);
        DeptAllDto deptAllDto = this.mapperHandler.deptToDeptAllDto(dept);
        deptAllDto.setCountsudent(dept.getStudents().size());

        return deptAllDto;
    }
}
