package com.ttu.estia.controller;

import com.ttu.estia.entity.BlacklistedSite;
import com.ttu.estia.entity.Student;
import com.ttu.estia.pojo.BlacklistedSiteDto;
import com.ttu.estia.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/blacklist")
@RestController
public class BlacklistController {

    @Autowired
    private BlacklistRepository blacklistRepo;

    @PostMapping("/add")
    public String addSiteToBlacklist(@RequestBody BlacklistedSiteDto blacklistedSiteDto) {
        BlacklistedSite blacklistedSite = new BlacklistedSite();
        blacklistedSite.setWebsite(blacklistedSiteDto.getWebsite());
        Student student = new Student();
        student.setId(blacklistedSiteDto.getStudentId());
        blacklistedSite.setStudent(student);
        blacklistRepo.save(blacklistedSite);

        return "added site to blacklist";
    }
}
