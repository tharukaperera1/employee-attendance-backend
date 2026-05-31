package employee_attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardStats {

    private long totalEmployees;
    private long presentToday;
    private long pendingLeaves;
    private long pendingOvertime;
}