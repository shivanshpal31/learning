package com.shivansh.Tutorial.service;

import com.shivansh.Tutorial.dto.AddStudentsRequestDto;
import com.shivansh.Tutorial.dto.StudentDto;
import com.shivansh.Tutorial.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface StudentService {

    List<StudentDto> getAllStudent();

    StudentDto getStudentById(long id);

    StudentDto createNewStudent(AddStudentsRequestDto addStudentsRequestDto);

    void deleteAStudent(Long id);
}
