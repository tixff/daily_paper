package com.yuewan.paper.service;

import com.yuewan.paper.domain.Paper;

import java.util.List;

public interface PaperService {

    void addPaper(Paper paper);

    List<String> findUncommittedUserNamesByGid(Integer gid);
}
