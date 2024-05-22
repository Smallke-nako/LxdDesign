package com.example.lxd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @TableName attendance_record
 */
@TableName(value ="attendance_record")
@Data
public class AttendanceRecord implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    @TableId
    private String number;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Long phone;

    /**
     * 所属队伍
     */
    private String team;

    /**
     * 状态；0：未签到 1：已签到
     */
    private Integer status;

    /**
     * 打卡表创建时间
     */
    private String createTime;

    /**
     * 打卡表更新时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
