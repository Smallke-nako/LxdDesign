package com.example.lxd.controller;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.config.page.PageResult;
import com.example.lxd.controller.common.PageRequestApi;
import com.example.lxd.entity.AttendanceRecord;
import com.example.lxd.service.AttendanceRecordService;
import com.example.lxd.service.EchartsService;
import com.example.lxd.util.JsonResult;
import com.example.lxd.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "出勤记录表")
@CrossOrigin
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceRecordService attendanceRecordService;
    @Autowired
    EchartsService echartsService;
    /**
     * 获取打卡列表
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "打卡列表")
    @PostMapping("/list")
    public JsonResult<Object> list(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest){
        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.findAll(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(attendanceRecordList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(),pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 根据日期查询打卡列表
     * @param pageRequest
     * @param dateValue
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "根据日期查询打卡列表")
    @PostMapping("/date")
    public JsonResult<Object> datelist(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest,String dateValue){
        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.selectDateTime(pageRequest.getBody(),dateValue);
        PageInfo pageInfo = new PageInfo(attendanceRecordList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(),pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 更新打卡状态
     * @param attendanceRecord
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "修改员工打卡状态")
    @PostMapping("/update")
    public JsonResult<Object> userUpdate(@RequestBody AttendanceRecord attendanceRecord) {
        attendanceRecordService.update(attendanceRecord);
        switch (attendanceRecord.getTeam()) {
            case "1队":
                echartsService.updateOneTeamAttendanceCount();
                break;
            case "2队":
                echartsService.updateTwoTeamAttendanceCount();
                break;
            case "3队":
                echartsService.updateThreeTeamAttendanceCount();
                break;
            case "4队":
                echartsService.updateFourTeamAttendanceCount();
                break;
            case "5队":
                echartsService.updateFiveTeamAttendanceCount();
                break;
        }
        echartsService.updateAttendanceCount();
        echartsService.updateUnAttendanceCount();
        return JsonResult.success("修改成功");
    }

    @CrossOrigin
    @ApiOperation(value = "清空表")
    @PostMapping("/deleteTable")
    public JsonResult<Object> deleteTable(){
        echartsService.deleteTable();
        return JsonResult.success();
    }

    @CrossOrigin
    @ApiOperation(value = "生成表")
    @PostMapping("/createTable")
    public JsonResult<Object> createTable(){
        attendanceRecordService.createList();
        return JsonResult.success();
    }
}
