package com.example.lxd.mapper;


import com.example.lxd.entity.OperationLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationLogMapper {
    /**
     * 创建操作日志
     * @param operationLog
     * @return
     */
    int createOperationLog(OperationLog operationLog);

    /**
     * 分页
     * @return
     */
    List<OperationLog> LogPage();
}
