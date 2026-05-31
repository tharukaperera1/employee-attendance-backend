package employee_attendance.controller;

import employee_attendance.entity.Attendance;
import employee_attendance.entity.Employee;
import employee_attendance.entity.LeaveRequest;
import employee_attendance.entity.OvertimeRequest;
import employee_attendance.repository.AttendanceRepository;
import employee_attendance.repository.EmployeeRepository;
import employee_attendance.repository.LeaveRequestRepository;
import employee_attendance.repository.OvertimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportsController {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final LeaveRequestRepository leaveRequestRepository;
    private final OvertimeRepository overtimeRepository;

    @GetMapping("/employees")
    public List<Employee> employeeReport() {

        return employeeRepository.findAll();
    }

    @GetMapping("/attendance")
    public List<Attendance> attendanceReport() {

        return attendanceRepository.findAll();
    }

    @GetMapping("/leaves")
    public List<LeaveRequest> leaveReport() {

        return leaveRequestRepository.findAll();
    }

    @GetMapping("/overtime")
    public List<OvertimeRequest> overtimeReport() {

        return overtimeRepository.findAll();
    }

    @GetMapping("/attendance-summary")
    public Long attendanceSummary(
            @RequestParam int month,
            @RequestParam int year) {

        return attendanceRepository
                .countMonthlyAttendance(
                        month,
                        year);
    }
}