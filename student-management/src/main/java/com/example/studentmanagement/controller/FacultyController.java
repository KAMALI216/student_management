package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Faculty;
import com.example.studentmanagement.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
public class FacultyController {

    @Autowired
    private FacultyRepository repo;

    /* ---------- READ ---------- */
    @GetMapping("/faculties")
    public List<Faculty> getAllFaculties() {
        return repo.findAll();
    }

    @GetMapping("/faculties/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Integer id) {
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    /* ---------- CREATE ---------- */
    @PostMapping("/faculty/add")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty saved = repo.save(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /* ---------- UPDATE ---------- */
    @PutMapping("/faculty/update/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Integer id,
                                                 @RequestBody Faculty details) {

        Optional<Faculty> optional = repo.findById(id);
        if (optional.isEmpty())
            return ResponseEntity.notFound().build();

        Faculty faculty = optional.get();
        faculty.setName(details.getName());
        faculty.setEmail(details.getEmail());
        faculty.setPhone(details.getPhone());
        faculty.setDepartment(details.getDepartment());
        faculty.setDesignation(details.getDesignation());
        faculty.setJoiningDate(details.getJoiningDate());
        faculty.setGender(details.getGender());
        faculty.setDob(details.getDob());
        faculty.setQualification(details.getQualification());
        faculty.setExperienceYears(details.getExperienceYears());
        faculty.setAddress(details.getAddress());

        return ResponseEntity.ok(repo.save(faculty));
    }

    /* ---------- DELETE ---------- */
    @DeleteMapping("/faculty/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFaculty(@PathVariable Integer id) {
        repo.findById(id).ifPresent(repo::delete);
    }
}
