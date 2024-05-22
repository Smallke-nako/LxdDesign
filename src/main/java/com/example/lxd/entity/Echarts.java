package com.example.lxd.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Echarts {
    private Long id;
    /**
     * 统计类别
     */
    private String name;
    /**
     * 统计个数
     */
    private Long count;
    /**
     * 查询更新时间
     */
    private LocalDateTime time;
}
