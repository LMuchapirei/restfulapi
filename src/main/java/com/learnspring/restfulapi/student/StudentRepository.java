package com.learnspring.restfulapi.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    // will transform into sql like
    // Select * from student where email=?
    //Or using jbsql
    // @Query("SELECT s from Student WHERE s.email=?1)
    Optional<Student> findStudentByEmail(String email);
}
