package com.shivansh.Tutorial.controller;

import com.shivansh.Tutorial.dto.AddStudentsRequestDto;
import com.shivansh.Tutorial.dto.StudentDto;
import com.shivansh.Tutorial.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET /student  -> returns list with 200 OK
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    // GET /student/{id} -> returns single student with 200 OK (or change to return notFound if service can return null/optional)
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto dto = studentService.getStudentById(id);
        return ResponseEntity.ok(dto);
        // If your service can return null / Optional, prefer:
        // return Optional.ofNullable(dto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /student -> returns created with 201
    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentsRequestDto requestDto) {
        StudentDto saved = studentService.createNewStudent(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
