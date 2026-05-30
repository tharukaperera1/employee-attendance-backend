package employee_attendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeCode;

    private String firstName;

    private String lastName;

    private String department;

    private String designation;

    private String phone;

    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}