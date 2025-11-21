package com.shivansh.Tutorial.controller;

import com.shivansh.Tutorial.dto.StudentDto;
import com.shivansh.Tutorial.entity.Student;
import com.shivansh.Tutorial.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student{id}")
    public StudentDto getStudentById(){
        return new StudentDto(4L, "Shivansh", "shivanshpal31@gmail.com");
    }
}
