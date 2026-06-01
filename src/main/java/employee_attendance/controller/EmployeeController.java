package employee_attendance.controller;

import employee_attendance.dto.ApiResponse;
import employee_attendance.entity.Employee;
import employee_attendance.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(
            @RequestBody Employee employee) {

        Employee saved = employeeService.save(employee);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Employee created successfully",
                        saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllEmployees() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Employees retrieved successfully",
                        employeeService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Employee found",
                        employeeService.getById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(
            @PathVariable Long id) {

        employeeService.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Employee deleted successfully",
                        null));
    }
}