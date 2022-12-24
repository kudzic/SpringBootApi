package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
    StudentService service;

    @Autowired
    public StudentController(StudentService studentService){
        this.service=studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return service.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        service.addNewStudent(student);
    }


    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentID") Long id){
        service.deleteStudent(id);

    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        service.updateStudent(studentId,name,email);
    }



}
