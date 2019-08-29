package com.yuewan.paper.service;

import com.yuewan.paper.data.ResultData;
import com.yuewan.paper.domain.User;

import java.util.List;

public interface UserService {

    ResultData addUser(User user);

    void deleteUserByName(String name);

    User findUserByName(String name);

    List<User> findUserByGroupId(Integer gid);

    List<User> findUserByGidAndUids(Integer gid, List<Integer> ids);

    List<User> getAllUser();
}
