package employee_attendance.service;

import employee_attendance.entity.Employee;
import employee_attendance.entity.OvertimeRequest;
import employee_attendance.repository.EmployeeRepository;
import employee_attendance.repository.OvertimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OvertimeService {

    private final OvertimeRepository overtimeRepository;
    private final EmployeeRepository employeeRepository;

    public OvertimeRequest requestOvertime(
            Long employeeId,
            OvertimeRequest request) {

        Employee employee =
                employeeRepository.findById(employeeId)
                        .orElseThrow();

        request.setEmployee(employee);
        request.setStatus("PENDING");

        return overtimeRepository.save(request);
    }

    public OvertimeRequest approve(Long id) {

        OvertimeRequest overtime =
                overtimeRepository.findById(id)
                        .orElseThrow();

        overtime.setStatus("APPROVED");

        return overtimeRepository.save(overtime);
    }

    public OvertimeRequest reject(Long id) {

        OvertimeRequest overtime =
                overtimeRepository.findById(id)
                        .orElseThrow();

        overtime.setStatus("REJECTED");

        return overtimeRepository.save(overtime);
    }

    public List<OvertimeRequest> getAll() {

        return overtimeRepository.findAll();
    }

    public List<OvertimeRequest> getEmployeeOvertime(
            Long employeeId) {

        return overtimeRepository.findByEmployeeId(employeeId);
    }

    public Double getTotalApprovedHours(
            Long employeeId) {

        return overtimeRepository
                .getApprovedOvertimeHours(employeeId);
    }
}