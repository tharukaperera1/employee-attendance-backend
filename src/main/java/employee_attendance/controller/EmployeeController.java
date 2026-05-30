package employee_attendance.controller;

import employee_attendance.entity.Employee;
import employee_attendance.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee create(
            @RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        employeeService.delete(id);
    }
}