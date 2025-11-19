package com.shivansh.Tutorial.controller;

import com.shivansh.Tutorial.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(4L, "Shivansh", "shivanshpal31@gmail.com");
    }
}
