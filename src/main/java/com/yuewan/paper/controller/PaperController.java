package com.yuewan.paper.controller;

import com.yuewan.paper.data.ResultData;
import com.yuewan.paper.domain.Paper;
import com.yuewan.paper.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("/paper")
@Api(value = "日报管理", tags = "日报管理")
public class PaperController {

    @Autowired
    private PaperService service;

    @PostMapping("add")
    @ApiOperation(value = "添加日报", notes = "添加日报")
    ResultData addPaper(Paper paper) {
        ResultData resultData = new ResultData();
        paper.setDate(new Date());
        try {
            service.addPaper(paper);
            resultData.setStatus(200);
            resultData.setMessage("添加日报成功");
        } catch (Exception e) {
            resultData.setStatus(500);
            resultData.setMessage("添加日报失败");
        }

        return resultData;
    }

    @GetMapping("uncommitted")
    @ApiOperation(value = "获取未提交日报的人员", notes = "获取未提交日报的人员")
    ResultData getUcomitNamesByGid(Integer gid) {
        ResultData resultData = new ResultData();
        try {
            List<String> names = service.findUncommittedUserNamesByGid(gid);
            resultData.setStatus(200);
            resultData.setMessage("查询成功");
            resultData.setData(names);

        } catch (Exception e) {
            resultData.setStatus(500);
            resultData.setMessage("查询失败");
        }

        return resultData;
    }
}
