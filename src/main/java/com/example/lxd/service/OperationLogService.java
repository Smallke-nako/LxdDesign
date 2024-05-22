package com.example.lxd.service;


import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.OperationLog;

import java.util.List;

public interface OperationLogService {
    /**
     * 保存操作日志
     *
     * @param operationLog
     * @return
     */
    void saveOperationLog(OperationLog operationLog);

    /**
     * 操作日志（分页功能）
     */
    List<OperationLog> LogPage(PageRequest pageRequest);
}
