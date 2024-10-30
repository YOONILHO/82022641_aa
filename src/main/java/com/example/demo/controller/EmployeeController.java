package com.example.demo.controller;

import com.example.demo.dto.TodoItemDto;
import com.example.demo.service.TodoItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.Valid;

@Slf4j
@RequestMapping("/api/v1/user")
@RestController
public class EmployeeController {

    // Test Branch
    // Sample employee data
    private static final Map<String, String> employeeData = new HashMap<>();

    static {
        employeeData.put("1", "E001");
        employeeData.put("2", "E002");
        employeeData.put("3", "E003");
    }

    // GET API to fetch employee number by employee ID
    @GetMapping("/{employeeId}")
    public Map<String, Object> getEmployeeNumber(@PathVariable String employeeId) {
        Map<String, Object> response = new HashMap<>();
        
        // Check if the employee exists
        String employeeNumber = employeeData.get(employeeId);
        if (employeeNumber != null) {
            response.put("employee_number", employeeNumber);
        } else {
            response.put("error", "Employee not found");
        }
        return response;
    }

    // GET API to return 82022641 if no employee ID is specified
    @GetMapping("/")
    public Map<String, Object> getDefaultEmployeeNumber() {
        Map<String, Object> response = new HashMap<>();
        response.put("default_number", "82022641");
        return response;
    }
}

