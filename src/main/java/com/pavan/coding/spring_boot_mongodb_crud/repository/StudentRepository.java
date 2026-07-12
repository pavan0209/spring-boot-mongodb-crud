package com.pavan.coding.spring_boot_mongodb_crud.repository;

import com.pavan.coding.spring_boot_mongodb_crud.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
