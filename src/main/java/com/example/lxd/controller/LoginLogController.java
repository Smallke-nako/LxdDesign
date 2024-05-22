package com.example.lxd.controller;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.config.page.PageResult;
import com.example.lxd.controller.common.PageRequestApi;
import com.example.lxd.entity.PersonLoginLog;
import com.example.lxd.service.EchartsService;
import com.example.lxd.service.PersonLoginLogService;
import com.example.lxd.util.JsonResult;
import com.example.lxd.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "登录日志管理")
@CrossOrigin
@RestController
@RequestMapping("/loginlog")
public class LoginLogController {
    @Autowired
    PersonLoginLogService personLoginLogService;
    @Autowired
    EchartsService echartsService;
    /**
     *获取登录日志列表
     */
    @CrossOrigin
    @ApiOperation(value = "登录日志列表")
    @PostMapping("/list")
    public JsonResult<Object> list(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest){
        List<PersonLoginLog> logList = personLoginLogService.getLogPage(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(logList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(),pageInfo);
        return JsonResult.success(pageResult)       ;
    }

    /**
     * 删除
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "删除日志")
    @PostMapping("/delete")
    public JsonResult<Object> logDelete(@RequestParam(value = "id") int id) {
        personLoginLogService.deleteLog(id);
        echartsService.updateSystemLoginCount();
        echartsService.updateSystemLoginSuccessCount();
        echartsService.updateSystemLoginFailCount();
        return JsonResult.success();
    }
}
