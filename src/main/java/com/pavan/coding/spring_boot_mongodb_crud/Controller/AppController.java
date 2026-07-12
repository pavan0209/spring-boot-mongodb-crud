package com.pavan.coding.spring_boot_mongodb_crud.Controller;

import com.pavan.coding.spring_boot_mongodb_crud.model.Student;
import com.pavan.coding.spring_boot_mongodb_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class AppController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student saved = this.studentRepository.save(student);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/get-students")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }
}
