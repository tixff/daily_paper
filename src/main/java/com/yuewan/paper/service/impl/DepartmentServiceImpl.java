package com.yuewan.paper.service.impl;

import com.yuewan.paper.domain.Department;
import com.yuewan.paper.domain.DepartmentExample;
import com.yuewan.paper.mapper.DepartmentMapper;
import com.yuewan.paper.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper mapper;

    @Override
    public List<String> getAllDepartentName() {
        ArrayList<String> dptnames = new ArrayList<>();
        List<Department> departments = mapper.selectByExample(new DepartmentExample());
        departments.forEach(d -> dptnames.add(d.getName()));
        return dptnames;
    }
}
