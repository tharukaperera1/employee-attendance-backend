package employee_attendance.repository;

import employee_attendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByEmployeeIdAndAttendanceDate(
            Long employeeId,
            LocalDate attendanceDate
    );

    long countByAttendanceDate(LocalDate attendanceDate);

    @Query("""
            SELECT COUNT(a)
            FROM Attendance a
            WHERE MONTH(a.attendanceDate) = :month
            AND YEAR(a.attendanceDate) = :year
            """)
    Long countMonthlyAttendance(
            @Param("month") int month,
            @Param("year") int year
    );
}