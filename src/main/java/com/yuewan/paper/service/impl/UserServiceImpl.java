package com.yuewan.paper.service.impl;

import com.yuewan.paper.data.ResultData;
import com.yuewan.paper.domain.User;
import com.yuewan.paper.domain.UserExample;
import com.yuewan.paper.mapper.UserMapper;
import com.yuewan.paper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public ResultData addUser(User user) {
        ResultData resultData = new ResultData();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(user.getName());
        if (mapper.selectByExample(userExample) != null) {
            mapper.insert(user);
            resultData.setMessage("添加用户成功");
            resultData.setStatus(200);
        } else {
            resultData.setStatus(200);
            resultData.setMessage("用户名重复");
        }
        return resultData;
    }

    @Override
    public void deleteUserByName(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        mapper.deleteByExample(userExample);
    }

    @Override
    public User findUserByName(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        List<User> users = mapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> findUserByGroupId(Integer gid) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andGIdEqualTo(gid);
        List<User> users = mapper.selectByExample(userExample);
        return users;
    }

    @Override
    public List<User> findUserByGidAndUids(Integer gid, List<Integer> ids) {

        List<User> users = new ArrayList<>();
        UserExample userExample = new UserExample();
        if (ids != null && ids.size() > 0) {
            userExample.createCriteria().andGIdEqualTo(gid)
                    .andIdIn(ids);
            users = mapper.selectByExample(userExample);
        }

        return users;
    }

    @Override
    public List<User> getAllUser() {
        return mapper.selectByExample(new UserExample());
    }
}
