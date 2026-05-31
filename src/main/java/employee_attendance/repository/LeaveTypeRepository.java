package employee_attendance.repository;

import employee_attendance.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository
        extends JpaRepository<LeaveType, Long> {
}