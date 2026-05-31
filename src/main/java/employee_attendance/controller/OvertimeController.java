package employee_attendance.controller;

import employee_attendance.entity.OvertimeRequest;
import employee_attendance.service.OvertimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/overtime")
@RequiredArgsConstructor
public class OvertimeController {

    private final OvertimeService overtimeService;

    @PostMapping("/request/{employeeId}")
    public OvertimeRequest requestOvertime(
            @PathVariable Long employeeId,
            @RequestBody OvertimeRequest request) {

        return overtimeService.requestOvertime(
                employeeId,
                request);
    }

    @PutMapping("/approve/{id}")
    public OvertimeRequest approve(
            @PathVariable Long id) {

        return overtimeService.approve(id);
    }

    @PutMapping("/reject/{id}")
    public OvertimeRequest reject(
            @PathVariable Long id) {

        return overtimeService.reject(id);
    }

    @GetMapping
    public List<OvertimeRequest> getAll() {

        return overtimeService.getAll();
    }

    @GetMapping("/employee/{employeeId}")
    public List<OvertimeRequest> getEmployeeOvertime(
            @PathVariable Long employeeId) {

        return overtimeService.getEmployeeOvertime(employeeId);
    }

    @GetMapping("/total/{employeeId}")
    public Double totalHours(
            @PathVariable Long employeeId) {

        return overtimeService
                .getTotalApprovedHours(employeeId);
    }
}