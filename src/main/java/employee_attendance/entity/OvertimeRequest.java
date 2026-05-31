package employee_attendance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "overtime_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OvertimeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate requestDate;

    private Double hours;

    private String reason;

    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}