package com.spring.api_project.controller;

import com.spring.api_project.model.Student;
import com.spring.api_project.service.StudentService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Iterable<Student> getAlls() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudednt(@PathVariable int id) {
        return service.getStudent(id);
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        service.createStudent(student);

        return "The person has be created correctly";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        service.updateStudent(student);

        return "The person has be updated correctly";
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
}
