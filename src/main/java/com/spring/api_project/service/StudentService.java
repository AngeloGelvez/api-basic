package com.spring.api_project.service;

import com.spring.api_project.model.Student;
import com.spring.api_project.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    //INYECCION  POR CONSTRUCTOR
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {this.repository = repository;}

    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudent(int id) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            return student.get();
        }else {
            return null;
        }
    }

    public String createStudent(Student student) {
        repository.save(student);

        return "The Student has be created correctly";
    }

    public String updateStudent(Student student) {
        repository.save(student);

        return "The student has be updated correctly";
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}
