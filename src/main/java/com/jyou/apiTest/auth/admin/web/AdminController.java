package com.jyou.apiTest.auth.admin.web;

import com.jyou.apiTest.auth.admin.domain.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("")
    public List<Admin> hello(long a) {
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin(a, "loginId1", "password1", "nickName1"));
        admins.add(new Admin(a+1, "loginId2", "password2", "nickName2"));
        admins.add(new Admin(a+2, "loginId3", "password3", "nickName3"));
        return admins;
    }
}
