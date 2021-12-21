package com.task.task.controller;

import com.task.task.entity.DeptAllDto;
import com.task.task.entity.DeptDtoBasic;
import com.task.task.entity.StudentDto;
import com.task.task.entity.StudentToDept;
import com.task.task.entity.SubjectDto;
import com.task.task.services.DeptAndStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private DeptAndStudentService deptAndStudentService;

    @PostMapping("/adddept")
    public ResponseEntity<?> addDept(@RequestBody DeptDtoBasic deptDtoBasic) {

        if (deptDtoBasic == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {

            this.deptAndStudentService.addDept(deptDtoBasic);
            return ResponseEntity.ok("successfully added");
        }

    }

    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {

        if (studentDto == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {

            this.deptAndStudentService.addStudent(studentDto);
            return ResponseEntity.ok("successfully added");

        }

    }

    @PostMapping("/dep-student")
    @ResponseBody
    public ResponseEntity<?> depToStudent(@RequestBody StudentToDept studentToDept) {

        if (studentToDept.getName() == null && studentToDept.getSid().size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } else {

            return ResponseEntity.status(HttpStatus.OK).body(this.deptAndStudentService.depToStudent(studentToDept));
        }

    }

    @GetMapping("/dept/{id}")
    public ResponseEntity<?> getDept(@PathVariable int id) {

        if (id == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(this.deptAndStudentService.getDept(id));
        }

    }

    // add subject

    @PostMapping("/addsub")
    public ResponseEntity<?> addSubject(@RequestBody SubjectDto subjectDto) {

        if (subjectDto == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {
            this.deptAndStudentService.addsubject(subjectDto);
            return ResponseEntity.status(HttpStatus.OK).body("successfully added");
        }

    }

    // enroll subject
    @PostMapping("/{sid}/subject/{said}")
    public ResponseEntity<StudentDto> enrollSubject(@PathVariable int sid, @PathVariable int said) throws Exception {

        StudentDto studentDto = this.deptAndStudentService.enrollSubject(sid, said);
        if (studentDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(studentDto);
        }
    }

    // get student
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable int id) {

        StudentDto studentDto = this.deptAndStudentService.getStudent(id);
        if (studentDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(studentDto);
        }
    }

    // get Dept detail

    @GetMapping("/deptdetail/{id}")
    public ResponseEntity<DeptAllDto> getDeptAllDetail(@PathVariable int id) {
        DeptAllDto deptAllDto = this.deptAndStudentService.getDeptAllDetail(id);
        if (deptAllDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(deptAllDto);
        }
    }
}
