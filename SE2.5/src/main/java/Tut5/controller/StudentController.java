package Tut5.controller;

import Tut5.model.Student;
import Tut5.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/")
    public List<Student> viewStudentList() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/detail/{id}")
    public Student viewStudentById(@PathVariable(value = "id") Long id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping(value = "/add")
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @PutMapping(value = "/update/{id}")
    public void updateStudent(@PathVariable(value = "id") Long id, @RequestBody @Valid Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.saveAndFlush(student);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long id) {
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.getById(id);
            studentRepository.delete(student);
        }
    }
}