package com.example.lxd.annotation;

import lombok.Getter;

@Getter
public enum OperationType {
    /**
     * 默认系统
     */
    SYSTEM("SYSTEM"),
    /**
     * 登录
     */
    LOGIN("LOGIN"),
    /**
     * 添加
     */
    INSERT("INSERT"),
    /**
     * 删除
     */
    DELETE("DELETE"),
    /**
     * 查询
     */
    SELECT("SELECT"),
    /**
     * 更新
     */
    UPDATE("UPDATE");

    private String value;

    OperationType(String s) {
        this.value = s;
    }

}
