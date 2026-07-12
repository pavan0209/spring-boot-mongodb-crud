package com.pavan.coding.spring_boot_mongodb_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private boolean status;
    private String message;
    private Object data;
}
