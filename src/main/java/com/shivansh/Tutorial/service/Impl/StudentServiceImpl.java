package com.shivansh.Tutorial.service.Impl;

import com.shivansh.Tutorial.dto.AddStudentsRequestDto;
import com.shivansh.Tutorial.dto.StudentDto;
import com.shivansh.Tutorial.entity.Student;
import com.shivansh.Tutorial.repository.StudentRepository;
import com.shivansh.Tutorial.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students=studentRepository.findAll();
        List<StudentDto> studentDtoList=students.stream().map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();
        return List.of();
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student=studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student Not Found"));
        StudentDto studentDto=modelMapper.map(student,StudentDto.class);
        return studentDto;
    }

    @Override
    public StudentDto createNewStudent(AddStudentsRequestDto addStudentsRequestDto){
        Student newStudent=modelMapper.map(addStudentsRequestDto,Student.class);
        Student student=studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteAStudent(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student ID does not exist"+id);
        }
        studentRepository.deleteById(id);
    }
}
