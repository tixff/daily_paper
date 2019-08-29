package com.yuewan.paper.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yuewan.paper.data.ExcelPaper;
import com.yuewan.paper.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/excel")
@Api(value = "EXCEL导出", tags = "EXCEL导出")
public class ExcelController {

    @Autowired
    private UserService userService;


    //生成user表excel
    @GetMapping(value = "user")
    @ApiOperation(value = "导出用户", produces = "application/octet-stream")
    public void getUser(HttpServletResponse response) throws Exception {


        //调用service查询方法返回结果集
        /*List<User> result = userService.getAllUser();
        List<ExcelUser> list = result.stream().map(f -> {
            ExcelUser excelUser = new ExcelUser();
            excelUser.setId(f.getId());
            excelUser.setName(f.getName());
            return excelUser;
        }).collect(Collectors.toList());*/

        ExcelPaper excelPaper = new ExcelPaper();
        excelPaper.setName("李枝名");
        excelPaper.setWorkContent("1.拉取王者国度-安卓每日区服收入\n" +
                "2.拉取王者国度-ios新服数据汇总\n" +
                "3.拉取王者国度ios8/20订单信息,以及查询指定用户id的ip和设备号\n" +
                "4.拉取无双屠龙ios全平台设备号\n" +
                "5.拉取王者国度安卓8/20订单信息,以及查询指定用户id的ip和设备号");

        excelPaper.setProblemDescribe("1.拉取无双屠龙ios全平台设别号没有找到对应库,导致延期到第二天,\n" +
                "第一天晚上已和刘亮亮沟通,\n" +
                "刘亮亮同意第二天再拉2.GS后台两个程序在中午就开始报错执行不了");

        excelPaper.setReasonAnalysisSkill("1.对阿里云的数据库不熟悉\n" +
                "2.因为今天新集群升级,新加集群没有配置GS的白名单");

        excelPaper.setReasonAnalysisThinking("1.不熟悉无双屠龙的发行库\n" +
                "2.自己对于程序错误的定位太慢,发现问题到找到问题花了很长时间,需要提升这方面的能力");

        excelPaper.setFollowupStrategy("1.和少爷沟通找到对应日志,寻求吴组昌帮助解析日志");

        excelPaper.setTomorrowWorkPlan("1.为运营中心&商务中心提供数据支持");

        ArrayList<ExcelPaper> list = new ArrayList<>();
        list.add(excelPaper);
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, ExcelPaper.class);
        sheet.setSheetName("日报");

        TableStyle tableStyle = new TableStyle();
        tableStyle.setTableHeadBackGroundColor(IndexedColors.ROYAL_BLUE);
        tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE1);
        Font font = new Font();
        font.setFontHeightInPoints((short) 12);
        font.setBold(false);
        tableStyle.setTableContentFont(font);
        sheet.setTableStyle(tableStyle);

        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        String fileName = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        writer.write(list, sheet);

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "utf-8"));

        writer.finish();
        out.flush();
    }

}