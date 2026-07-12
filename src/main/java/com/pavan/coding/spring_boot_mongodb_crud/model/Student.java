package com.pavan.coding.spring_boot_mongodb_crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    private String id;
    private String name;
    private String city;
    private String college;
}
