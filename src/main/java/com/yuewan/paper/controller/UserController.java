package com.yuewan.paper.controller;

import com.yuewan.paper.data.ResultData;
import com.yuewan.paper.domain.User;
import com.yuewan.paper.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/user")
@Api(value = "用户管理", tags = "用户管理")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping("add")
    public ResultData addUser(User user) {
        ResultData result = new ResultData();

        String password = user.getPassword();
        String encodePassword = UUID.nameUUIDFromBytes(password.getBytes()).toString().replaceAll("-", "");
        user.setPassword(encodePassword);

        try {
            result = service.addUser(user);
        } catch (Exception e) {
            result.setMessage("添加用户失败");
            result.setStatus(500);
        }

        return result;
    }

}
