package com.ttu.estia.controller;

import com.ttu.estia.entity.Student;
import com.ttu.estia.pojo.AuthenticationRequest;
import com.ttu.estia.pojo.AuthenticationResponse;
import com.ttu.estia.pojo.StudentSignupDto;
import com.ttu.estia.repository.StudentRepository;
import com.ttu.estia.service.CustomUserDetailsService;
import com.ttu.estia.service.StudentService;
import com.ttu.estia.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentService studentService;

    @PostMapping("/signup")
    public String signup(@RequestBody StudentSignupDto studentSignupDto) {

        Student newStudent = new Student(studentSignupDto.getUsername(), passwordEncoder.encode(studentSignupDto.getPassword()));
        studentRepository.save(newStudent);
        return "signup successful";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authRequest) throws Exception {

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (authRequest.getUsername(),
                            authRequest.getPassword()));

        } catch(BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }

        final UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        Student student = studentService.getStudent(userDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt, jwtUtil.extractExpiration(jwt).getTime(), student));
    }
}
