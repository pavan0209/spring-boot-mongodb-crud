package com.pavan.coding.spring_boot_mongodb_crud.Controller;

import com.pavan.coding.spring_boot_mongodb_crud.model.Student;
import com.pavan.coding.spring_boot_mongodb_crud.dto.ApiResponse;
import com.pavan.coding.spring_boot_mongodb_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class AppController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add-student")
    public ResponseEntity<ApiResponse> addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        ApiResponse response = new ApiResponse(true, "Student added successfully.", savedStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get-students")
    public ResponseEntity<ApiResponse> getStudents() {
        List<Student> students = studentRepository.findAll();
        ApiResponse response = new ApiResponse(true, "Students fetched successfully.", students);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@PathVariable String id, @RequestBody Student student) {
        if (!studentRepository.existsById(id)) {
            ApiResponse response = new ApiResponse(false, "Student with id " + id + " does not exist.", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        student.setId(id);
        Student updatedStudent = studentRepository.save(student);
        ApiResponse response = new ApiResponse(true, "Student updated successfully.", updatedStudent);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable String id) {
        if (!studentRepository.existsById(id)) {
            ApiResponse response = new ApiResponse(false, "Student with id " + id + " does not exist.", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        studentRepository.deleteById(id);
        ApiResponse response = new ApiResponse(true, "Student deleted successfully.", null);
        return ResponseEntity.ok(response);
    }
}