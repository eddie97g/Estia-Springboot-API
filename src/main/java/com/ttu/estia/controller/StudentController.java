package com.ttu.estia.controller;

import com.ttu.estia.entity.Student;
import com.ttu.estia.entity.StudyPreferences;
import com.ttu.estia.pojo.AuthenticationRequest;
import com.ttu.estia.pojo.AuthenticationResponse;
import com.ttu.estia.pojo.StudentSignupDto;
import com.ttu.estia.pojo.StudyPreferencesDto;
import com.ttu.estia.repository.StudentRepository;
import com.ttu.estia.repository.StudyPreferencesRepository;
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

import java.util.Optional;

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

    @Autowired
    private StudyPreferencesRepository studyPreferencesRepository;

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

    @PutMapping("/youtube")
    public String updateYoutubeLink(@RequestBody Student student) {
        Optional<Student> studentDB = this.studentRepository.findById(student.getId());
        studentDB.get().setYoutubeEmbedId(student.getYoutubeEmbedId());
        this.studentRepository.save(studentDB.get());
        return "updated youtube link";
    }

    @PutMapping("/preferences")
    public String updateStudyPreferences(@RequestBody StudyPreferencesDto studyPreferences) {
        Optional<Student> student = this.studentRepository.findById(studyPreferences.getStudentID());
        StudyPreferences studyPreferencesDB = this.studyPreferencesRepository.findByStudent(student.get());
        if (studyPreferencesDB == null) {
            StudyPreferences newStudyPreferences = new StudyPreferences();
            newStudyPreferences.setStudyDuration(studyPreferences.getStudyDuration());
            newStudyPreferences.setStudyBreakDuration(studyPreferences.getStudyBreakDuration());

            newStudyPreferences.setStudent(student.get());
            this.studyPreferencesRepository.save(newStudyPreferences);
        }

        else {
            studyPreferencesDB.setStudyBreakDuration(studyPreferences.getStudyBreakDuration());
            studyPreferencesDB.setStudyDuration(studyPreferences.getStudyDuration());
            this.studyPreferencesRepository.save(studyPreferencesDB);
        }

        return "added/updated settings";
    }
}
