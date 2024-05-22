package com.example.lxd.controller;

import com.example.lxd.entity.Echarts;
import com.example.lxd.service.EchartsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Echarts")
@CrossOrigin
@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    EchartsService echartsService;


    /**
     * 获取总登录记录
     * @return
     */
    @CrossOrigin
    @GetMapping("/SystemLoginCount")
    public Map<String,List<Echarts>> getSystemLoginCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateSystemLoginCount();
        map.put("SystemLoginAllCount",echartsService.getSystemLoginCount());
        return map;
    }

    /**
     * 获取系统登录成功情况
     * @return
     */
    @CrossOrigin
    @GetMapping("/SystemLoginSuccessCount")
    public Map<String,List<Echarts>> getSystemLoginSuccessCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateSystemLoginSuccessCount();
        map.put("SystemLoginSuccessCount",echartsService.getSystemLoginSuccessCount());
        return map;
    }

    /**
     * 获取系统登录失败情况
     * @return
     */
    @CrossOrigin
    @GetMapping("/SystemLoginFailCount")
    public Map<String,List<Echarts>> getSystemLoginFailCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateSystemLoginFailCount();
        map.put("SystemLoginFailCount",echartsService.getSystemLoginFailCount());
        return map;
    }

    /**
     * 获取员工总数
     * @return
     */
    @CrossOrigin
    @GetMapping("/employeeCount")
    public Map<String,List<Echarts>> getEmployeeCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateEmployeeCount();
        map.put("employeeCount",echartsService.getEmployeeCount());
        return map;
    }

    /**
     * 获取一队人员总数
     * @return
     */
    @CrossOrigin
    @GetMapping("/oneTeamCount")
    public Map<String,List<Echarts>> getOneTeamCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateOneTeamCount();
        map.put("oneTeamCount",echartsService.getOneTeamCount());
        return map;
    }

    /**
     * 获取二队人员总数
     * @return
     */
    @CrossOrigin
    @GetMapping("/twoTeamCount")
    public Map<String,List<Echarts>> getTwoTeamCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateTwoTeamCount();
        map.put("twoTeamCount",echartsService.getTwoTeamCount());
        return map;
    }

    /**
     * 获取三队人员总数
     * @return
     */
    @CrossOrigin
    @GetMapping("/threeTeamCount")
    public Map<String,List<Echarts>> getThreeTeamCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateThreeTeamCount();
        map.put("threeTeamCount",echartsService.getThreeTeamCount());
        return map;
    }

    /**
     * 获取四队人员总数
     * @return
     */
    @CrossOrigin
    @GetMapping("/fourTeamCount")
    public Map<String,List<Echarts>> getFourTeamCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateFourTeamCount();
        map.put("fourTeamCount",echartsService.getFourTeamCount());
        return map;
    }

    /**
     * 获取五队人员总数
     * @return
     */
    @CrossOrigin
    @GetMapping("/fiveTeamCount")
    public Map<String,List<Echarts>> getFiveTeamCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateFiveTeamCount();
        map.put("fiveTeamCount",echartsService.getFiveTeamCount());
        return map;
    }

    /**
     * 获取总出勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/AttendanceCount")
    public Map<String,List<Echarts>> getAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateAttendanceCount();
        map.put("AttendanceCount",echartsService.getAttendanceCount());
        return map;
    }

    /**
     * 获取一队出勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/oneTeamAttendanceCount")
    public Map<String,List<Echarts>> getOneTeamAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateOneTeamAttendanceCount();
        map.put("oneTeamAttendanceCount",echartsService.getOneTeamAttendanceCount());
        return map;
    }

    /**
     * 获取二队出勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/twoTeamAttendanceCount")
    public Map<String,List<Echarts>> getTwoTeamAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateTwoTeamAttendanceCount();
        map.put("twoTeamAttendanceCount",echartsService.getTwoTeamAttendanceCount());
        return map;
    }

    /**
     * 获取三队出勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/threeTeamAttendanceCount")
    public Map<String,List<Echarts>> getThreeTeamAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateThreeTeamAttendanceCount();
        map.put("threeTeamAttendanceCount",echartsService.getThreeTeamAttendanceCount());
        return map;
    }

    /**
     * 获取四队出勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/fourTeamAttendanceCount")
    public Map<String,List<Echarts>> getFourTeamAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateFourTeamAttendanceCount();
        map.put("fourTeamAttendanceCount",echartsService.getFourTeamAttendanceCount());
        return map;
    }

    /**
     * 获取五队出勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/fiveTeamAttendanceCount")
    public Map<String,List<Echarts>> getFiveTeamAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateFiveTeamAttendanceCount();
        map.put("fiveTeamAttendanceCount",echartsService.getFiveTeamAttendanceCount());
        return map;
    }

    /**
     * 获取总缺勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/UnAttendanceCount")
    public Map<String,List<Echarts>> getUnAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateUnAttendanceCount();
        map.put("UnAttendanceCount",echartsService.getUnAttendanceCount());
        return map;
    }

    /**
     * 获取一队缺勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/oneTeamUnAttendanceCount")
    public Map<String,List<Echarts>> getOneTeamUnAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateOneTeamUnAttendanceCount();
        map.put("oneTeamUnAttendanceCount",echartsService.getOneTeamUnAttendanceCount());
        return map;
    }

    /**
     * 获取二队缺勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/twoTeamUnAttendanceCount")
    public Map<String,List<Echarts>> getTwoTeamUnAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateTwoTeamUnAttendanceCount();
        map.put("twoTeamUnAttendanceCount",echartsService.getTwoTeamUnAttendanceCount());
        return map;
    }

    /**
     * 获取三队缺勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/threeTeamUnAttendanceCount")
    public Map<String,List<Echarts>> getThreeTeamUnAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateThreeTeamUnAttendanceCount();
        map.put("threeTeamUnAttendanceCount",echartsService.getThreeTeamUnAttendanceCount());
        return map;
    }

    /**
     * 获取四队缺勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/fourTeamUnAttendanceCount")
    public Map<String,List<Echarts>> getFourTeamUnAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateFourTeamUnAttendanceCount();
        map.put("fourTeamUnAttendanceCount",echartsService.getFourTeamUnAttendanceCount());
        return map;
    }

    /**
     * 获取五队缺勤人数
     * @return
     */
    @CrossOrigin
    @GetMapping("/fiveTeamUnAttendanceCount")
    public Map<String,List<Echarts>> getFiveTeamUnAttendanceCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateFiveTeamUnAttendanceCount();
        map.put("fiveTeamUnAttendanceCount",echartsService.getFiveTeamUnAttendanceCount());
        return map;
    }



    /**
     * 获取总用户数
     * @return
     */
    @CrossOrigin
    @GetMapping("/UsersCount")
    public Map<String,List<Echarts>> getUsersCount(){
        Map<String,List<Echarts>> map = new HashMap<>();
        echartsService.updateUsersCount();
        map.put("UsersCount",echartsService.getUsersCount());
        return map;
    }
}
