package com.task.task.repository;

import com.task.task.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findBySid(int id);

}
