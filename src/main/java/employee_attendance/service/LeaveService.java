package employee_attendance.service;

import employee_attendance.entity.*;
import employee_attendance.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveRequest applyLeave(
            Long employeeId,
            Long leaveTypeId,
            LeaveRequest request) {

        Employee employee =
                employeeRepository.findById(employeeId)
                        .orElseThrow();

        LeaveType leaveType =
                leaveTypeRepository.findById(leaveTypeId)
                        .orElseThrow();

        request.setEmployee(employee);
        request.setLeaveType(leaveType);
        request.setStatus("PENDING");

        return leaveRequestRepository.save(request);
    }

    public List<LeaveRequest> getAll() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest approve(Long id) {

        LeaveRequest leave =
                leaveRequestRepository.findById(id)
                        .orElseThrow();

        leave.setStatus("APPROVED");

        return leaveRequestRepository.save(leave);
    }

    public LeaveRequest reject(Long id) {

        LeaveRequest leave =
                leaveRequestRepository.findById(id)
                        .orElseThrow();

        leave.setStatus("REJECTED");

        return leaveRequestRepository.save(leave);
    }
}