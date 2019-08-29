package com.yuewan.paper.data;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class ExcelUser extends BaseRowModel {

    @ExcelProperty(value = "id", index = 1)
    private Integer id;

    @ExcelProperty(value = "用户名", index = 1)
    private String name;
}
