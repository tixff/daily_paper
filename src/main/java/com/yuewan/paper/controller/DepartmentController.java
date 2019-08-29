package com.yuewan.paper.controller;

import com.yuewan.paper.data.ResultData;
import com.yuewan.paper.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/dpt")
@Api(value = "部门管理", tags = "部门管理")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @ResponseBody
    @RequestMapping("all")
    @ApiOperation(value = "获取所有部门信息", notes = "获取所有部门信息")
    ResultData getAllDepartment() {
        ResultData resultData = new ResultData();
        try {
            List<String> dptnames = service.getAllDepartentName();
            resultData.setStatus(200);
            resultData.setMessage("获取部门名称成功");
            resultData.setData(dptnames);
        } catch (Exception e) {
            resultData.setStatus(500);
            resultData.setMessage("获取部门名称异常");
        }

        return resultData;
    }
}
