package employee_attendance.controller;

import employee_attendance.entity.Attendance;
import employee_attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/checkin/{employeeId}")
    public Attendance checkIn(
            @PathVariable Long employeeId) {

        return attendanceService.checkIn(employeeId);
    }

    @PostMapping("/checkout/{attendanceId}")
    public Attendance checkOut(
            @PathVariable Long attendanceId) {

        return attendanceService.checkOut(attendanceId);
    }

    @GetMapping
    public List<Attendance> getAll() {

        return attendanceService.getAll();
    }
}