package com.ttu.estia.controller;

import com.ttu.estia.entity.BlacklistedSite;
import com.ttu.estia.entity.Student;
import com.ttu.estia.pojo.BlacklistedSiteDto;
import com.ttu.estia.repository.BlacklistRepository;
import com.ttu.estia.repository.StudentRepository;
import com.ttu.estia.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blacklist")
@RestController
public class BlacklistController {

    @Autowired
    private BlacklistRepository blacklistRepo;

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<List<BlacklistedSite>> addSiteToBlacklist(@RequestBody BlacklistedSiteDto blacklistedSiteDto) {

        Student student = studentService.getStudent(blacklistedSiteDto.getStudentId());
        student.addBlacklistedSite(new BlacklistedSite(blacklistedSiteDto.getWebsite(), student));
        Student savedStudent = studentService.saveStudent(student);

        return ResponseEntity.ok(savedStudent.getBlacklistedSites());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<BlacklistedSite>> deleteSiteFromBlacklist(@RequestBody BlacklistedSiteDto blacklistedSiteDto) {

        blacklistRepo.deleteById(blacklistedSiteDto.getSiteId());
        Student student = studentService.getStudent(blacklistedSiteDto.getStudentId());
        return ResponseEntity.ok(student.getBlacklistedSites());
    }
}
