package com.yq.study.entity;

import com.sun.jmx.snmp.Timestamp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: yangq
 * @create: 2020-09-26 13:09
 **/
@Data
@ApiModel("study参数说明")
@Entity
@Table(name = "t_study")
public class Study implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//主键生成策略
    @ApiParam("id,不用传")
    private Integer id;

    @ApiParam("微信号，必传")
    @Column(name = "number")
    private String number;

    @ApiParam("微信名称，必传")
    @Column(name = "userName")
    private String name;

    @ApiParam("学习开始时间，必传")
    @Column(name = "timeBegin")
    private Date begin;

    @ApiParam("学习结束时间")
    @Column(name = "timeEnd")
    private Date end;

    @ApiParam("开小差时间")
    @Column(name = "userLeave")
    private Long leave;
}
