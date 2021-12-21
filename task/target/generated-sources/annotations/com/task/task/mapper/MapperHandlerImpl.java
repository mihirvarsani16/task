package com.task.task.mapper;

import com.task.task.entity.Dept;
import com.task.task.entity.DeptAllDto;
import com.task.task.entity.DeptDtoBasic;
import com.task.task.entity.Student;
import com.task.task.entity.StudentDto;
import com.task.task.entity.Subject;
import com.task.task.entity.SubjectDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-10T13:56:47+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class MapperHandlerImpl implements MapperHandler {

    @Override
    public DeptDtoBasic modelToDto(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        DeptDtoBasic deptDtoBasic = new DeptDtoBasic();

        deptDtoBasic.setName( dept.getDeptname() );
        deptDtoBasic.setStudentDtos( studentListToStudentDtoList( dept.getStudents() ) );
        deptDtoBasic.setDid( dept.getDid() );

        return deptDtoBasic;
    }

    @Override
    public Dept dtoToModel(DeptDtoBasic deptDtoBasic) {
        if ( deptDtoBasic == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setDeptname( deptDtoBasic.getName() );
        dept.setStudents( studentDtoListToStudentList( deptDtoBasic.getStudentDtos() ) );
        dept.setDid( deptDtoBasic.getDid() );

        return dept;
    }

    @Override
    public StudentDto studentToDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setSubjectDtos( subjectListToSubjectDtoList( student.getSubjects() ) );
        studentDto.setName( student.getName() );
        studentDto.setSid( student.getSid() );

        return studentDto;
    }

    @Override
    public Student dtoToStudent(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setSubjects( subjectDtoListToSubjectList( studentDto.getSubjectDtos() ) );
        student.setName( studentDto.getName() );
        student.setSid( studentDto.getSid() );

        return student;
    }

    @Override
    public DeptAllDto deptToDeptAllDto(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        DeptAllDto deptAllDto = new DeptAllDto();

        deptAllDto.setStudentDtos( studentListToStudentDtoList( dept.getStudents() ) );
        deptAllDto.setDeptname( dept.getDeptname() );
        deptAllDto.setDid( dept.getDid() );

        return deptAllDto;
    }

    @Override
    public SubjectDto subjectToDto(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setSaid( subject.getSaid() );
        subjectDto.setSubjectname( subject.getSubjectname() );

        return subjectDto;
    }

    @Override
    public Subject dtoToSubject(SubjectDto subjectDto) {
        if ( subjectDto == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setSaid( subjectDto.getSaid() );
        subject.setSubjectname( subjectDto.getSubjectname() );

        return subject;
    }

    protected List<StudentDto> studentListToStudentDtoList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<StudentDto> list1 = new ArrayList<StudentDto>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToDto( student ) );
        }

        return list1;
    }

    protected List<Student> studentDtoListToStudentList(List<StudentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Student> list1 = new ArrayList<Student>( list.size() );
        for ( StudentDto studentDto : list ) {
            list1.add( dtoToStudent( studentDto ) );
        }

        return list1;
    }

    protected List<SubjectDto> subjectListToSubjectDtoList(List<Subject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectDto> list1 = new ArrayList<SubjectDto>( list.size() );
        for ( Subject subject : list ) {
            list1.add( subjectToDto( subject ) );
        }

        return list1;
    }

    protected List<Subject> subjectDtoListToSubjectList(List<SubjectDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Subject> list1 = new ArrayList<Subject>( list.size() );
        for ( SubjectDto subjectDto : list ) {
            list1.add( dtoToSubject( subjectDto ) );
        }

        return list1;
    }
}
