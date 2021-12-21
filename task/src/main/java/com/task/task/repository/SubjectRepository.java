package com.task.task.repository;

import com.task.task.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    public Subject findBySaid(Integer id);
}
