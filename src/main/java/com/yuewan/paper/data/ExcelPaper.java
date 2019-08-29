package com.yuewan.paper.data;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class ExcelPaper extends BaseRowModel {

    @ExcelProperty(value = {"人员", "人员"}, index = 0)
    private String name;

    @ExcelProperty(value = {"工作内容", "工作内容"}, index = 1)
    private String workContent;

    @ExcelProperty(value = {"问题描述", "问题描述"}, index = 2)
    private String problemDescribe;

    @ExcelProperty(value = {"原因分析", "技术/流程问题"}, index = 3)
    private String reasonAnalysisSkill;

    @ExcelProperty(value = {"原因分析", "工作思维/方法"}, index = 4)
    private String reasonAnalysisThinking;

    @ExcelProperty(value = {"后续解决策略", "后续解决策略"}, index = 5)
    private String followupStrategy;

    @ExcelProperty(value = {"明日工作计划", "明日工作计划"}, index = 6)
    private String tomorrowWorkPlan;

}
