package employee_attendance.repository;

import employee_attendance.entity.OvertimeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OvertimeRepository
        extends JpaRepository<OvertimeRequest, Long> {

    List<OvertimeRequest> findByEmployeeId(Long employeeId);

    @Query("""
            SELECT COALESCE(SUM(o.hours),0)
            FROM OvertimeRequest o
            WHERE o.employee.id = :employeeId
            AND o.status = 'APPROVED'
            """)
    Double getApprovedOvertimeHours(
            @Param("employeeId") Long employeeId);
}