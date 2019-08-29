package com.yuewan.paper.service.impl;

import com.yuewan.paper.domain.Paper;
import com.yuewan.paper.domain.PaperExample;
import com.yuewan.paper.mapper.PaperMapper;
import com.yuewan.paper.service.PaperService;
import com.yuewan.paper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public void addPaper(Paper paper) {
        mapper.insert(paper);
    }

    @Override
    public List<String> findUncommittedUserNamesByGid(Integer gid) {
        PaperExample paperExample = new PaperExample();
        paperExample.createCriteria().andDateEqualTo(new Date())
                .andGIdEqualTo(gid);
        List<Paper> commitPapers = mapper.selectByExample(paperExample);

        List<Integer> commitIds = new ArrayList<>();
        commitPapers.forEach(p -> commitIds.add(p.getuId()));

        List<String> allGroupUsers = userService.findUserByGroupId(gid).stream().map(u -> u.getName()).collect(Collectors.toList());
        List<String> commitUsers = userService.findUserByGidAndUids(gid, commitIds).stream().map(u -> u.getName()).collect(Collectors.toList());
        List<String> ucmitNames = new ArrayList<>();

        allGroupUsers.forEach(u -> {
            if (!commitUsers.contains(u)) {
                ucmitNames.add(u);
            }
        });

        return ucmitNames;
    }


}
