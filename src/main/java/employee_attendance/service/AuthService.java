package employee_attendance.service;

import employee_attendance.dto.*;
import employee_attendance.entity.*;
import employee_attendance.repository.*;
import employee_attendance.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        Role role =
                roleRepository.findByName(
                                RoleName.ROLE_EMPLOYEE)
                        .orElseThrow();

        user.setRole(role);

        userRepository.save(user);

        String token =
                jwtService.generateToken(
                        user.getUsername());

        return new AuthResponse(token);
    }
}