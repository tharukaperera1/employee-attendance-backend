package employee_attendance.service;

import employee_attendance.entity.Attendance;
import employee_attendance.entity.Employee;
import employee_attendance.repository.AttendanceRepository;
import employee_attendance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public Attendance checkIn(Long employeeId) {

        Employee employee =
                employeeRepository.findById(employeeId)
                        .orElseThrow();

        Attendance attendance = new Attendance();

        attendance.setEmployee(employee);
        attendance.setAttendanceDate(LocalDate.now());

        LocalDateTime now = LocalDateTime.now();

        attendance.setCheckIn(now);

        LocalTime officialTime = LocalTime.of(8, 0);

        int lateMinutes = 0;

        if (now.toLocalTime().isAfter(officialTime)) {

            lateMinutes =
                    (int) Duration.between(
                                    officialTime,
                                    now.toLocalTime())
                            .toMinutes();

            attendance.setStatus("LATE");
        } else {

            attendance.setStatus("PRESENT");
        }

        attendance.setLateMinutes(lateMinutes);

        return attendanceRepository.save(attendance);
    }

    public Attendance checkOut(Long attendanceId) {

        Attendance attendance =
                attendanceRepository.findById(attendanceId)
                        .orElseThrow();

        attendance.setCheckOut(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAll() {

        return attendanceRepository.findAll();
    }
}