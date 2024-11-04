package com.jyou.apiTest.auth.admin.web;

import com.jyou.apiTest.auth.admin.domain.User;
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
    public List<User> hello(long a) {
        List<User> users = new ArrayList<>();
        users.add(new User(a, "loginId1", "password1", "nickName1"));
        users.add(new User(a+1, "loginId2", "password2", "nickName2"));
        users.add(new User(a+2, "loginId3", "password3", "nickName3"));
        return users;
    }
}
