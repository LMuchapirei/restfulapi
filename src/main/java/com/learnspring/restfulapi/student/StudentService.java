package com.learnspring.restfulapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
   private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
       if(studentOptional.isPresent()){
           throw new IllegalStateException("email taken by some student");
       }
       studentRepository.save(student);
       System.out.println(student);
    }

    public void deleteStudent(Long id) {
        boolean studentExists=studentRepository.existsById(id);
        if(!studentExists){
            throw new IllegalStateException("student with id "+id+" does not  exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student updateStudent(Student student, Long studentId) {
        boolean studentExists= studentRepository.existsById(studentId);
        if(!studentExists){
            throw new IllegalStateException("Student with the id"+studentId+" does not exist");
        }
        Optional<Student> currentStudent=studentRepository.findById(studentId);
        if(currentStudent.isEmpty()){
            throw new IllegalStateException("Unexpected stuff");
        }
        var current=currentStudent.get();
        current.setEmail(student.getEmail());
        current.setDob(student.getDob());
        current.setName(student.getName());
//        studentRepository.save(current);
        return current;
    }
}
