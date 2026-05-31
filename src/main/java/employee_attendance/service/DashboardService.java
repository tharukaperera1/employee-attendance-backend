package employee_attendance.service;

import employee_attendance.dto.DashboardStats;
import employee_attendance.repository.AttendanceRepository;
import employee_attendance.repository.EmployeeRepository;
import employee_attendance.repository.LeaveRequestRepository;
import employee_attendance.repository.OvertimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final LeaveRequestRepository leaveRequestRepository;
    private final OvertimeRepository overtimeRepository;

    public DashboardStats getDashboardStats() {

        long totalEmployees =
                employeeRepository.count();

        long presentToday =
                attendanceRepository.countByAttendanceDate(
                        LocalDate.now());

        long pendingLeaves =
                leaveRequestRepository.countByStatus(
                        "PENDING");

        long pendingOvertime =
                overtimeRepository.countByStatus(
                        "PENDING");

        return new DashboardStats(
                totalEmployees,
                presentToday,
                pendingLeaves,
                pendingOvertime
        );
    }
}