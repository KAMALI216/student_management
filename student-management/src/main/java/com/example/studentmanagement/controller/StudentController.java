package com.example.studentmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    // Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Get a single student by ID
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Optional<Student> student = repo.findById(id);
        return student.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Add a new student
    @PostMapping("/student/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = repo.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    // Update student details by ID
    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student details) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(details.getName());
            student.setUsername(details.getUsername());
            student.setEmail(details.getEmail());
            student.setPhone(details.getPhone());
            student.setGender(details.getGender());
            student.setDob(details.getDob());
            student.setBranch(details.getBranch());
            student.setPercentage(details.getPercentage());

            repo.save(student);
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete student by ID
    @DeleteMapping("/student/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeStudent(@PathVariable int id) {
        Optional<Student> student = repo.findById(id);
        student.ifPresent(repo::delete);
    }
}
