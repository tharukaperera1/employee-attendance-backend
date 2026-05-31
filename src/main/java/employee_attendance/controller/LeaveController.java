package employee_attendance.controller;

import employee_attendance.entity.LeaveRequest;
import employee_attendance.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping("/apply/{employeeId}/{leaveTypeId}")
    public LeaveRequest apply(
            @PathVariable Long employeeId,
            @PathVariable Long leaveTypeId,
            @RequestBody LeaveRequest request) {

        return leaveService.applyLeave(
                employeeId,
                leaveTypeId,
                request);
    }

    @PutMapping("/approve/{id}")
    public LeaveRequest approve(
            @PathVariable Long id) {

        return leaveService.approve(id);
    }

    @PutMapping("/reject/{id}")
    public LeaveRequest reject(
            @PathVariable Long id) {

        return leaveService.reject(id);
    }

    @GetMapping
    public List<LeaveRequest> getAll() {

        return leaveService.getAll();
    }
}