package com.task.task.repository;

import com.task.task.entity.Dept;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

    public Dept findByDid(int id);

    public Dept findBydeptname(String name);
    // deptname
}
