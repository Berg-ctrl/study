package com.yq.study.controller;

import com.yq.study.dao.StudyDao;
import com.yq.study.entity.Study;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author: yangq
 * @create: 2020-09-26 13:50
 **/
@Api("接口文档说明")
@RestController
@Slf4j
public class StudyController {
    @Autowired
    private StudyDao studyDao;
    private static Integer num = 0;

    @ApiOperation(value = "在线人数加一",notes = "提示接口使用者注意事项",httpMethod = "GET")
    @RequestMapping("/addOnline")
    private void addOnline(){
        num++;
    }

    @ApiOperation(value = "查看在线人数",notes = "提示接口使用者注意事项",httpMethod = "GET")
    @RequestMapping("/online")
    private Integer online(){
        return num;
    }

    @ApiOperation(value = "新增学习记录",notes = "提示接口使用者注意事项",httpMethod = "POST")
    @PostMapping("/addStudy")
    private String addStudy(@RequestBody Study study){
        try {
            studyDao.save(study);
            return "新增成功";
        }catch (Exception e){
            log.error("新增失败");
            return "新增失败";
        }
    }

    @ApiOperation(value = "查询学习记录",notes = "提示接口使用者注意事项",httpMethod = "POST")
    @PostMapping("/studyByNum")
    private List<Study> studyByNum(@RequestBody @ApiParam("微信号") String num){
        try {
            List<Study> studies = studyDao.studyByNum(num);
            return studies;
        }catch (Exception e){
            log.error("查询失败");
            return null;
        }
    }



}
