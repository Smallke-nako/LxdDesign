package com.example.lxd.service.impl;


import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.OperationLog;
import com.example.lxd.mapper.OperationLogMapper;
import com.example.lxd.service.OperationLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Resource
    OperationLogMapper operationLogMapper;
    @Override
    public void saveOperationLog(OperationLog operationLog) {
        operationLogMapper.createOperationLog(operationLog);
    }

    @Override
    public List<OperationLog> LogPage(PageRequest pageRequest) {
        return null;
    }
}
