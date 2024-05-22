package com.example.lxd.service;

import com.example.lxd.entity.Echarts;

import java.util.List;

public interface EchartsService {

    /**
     * 查询员工总数
     * @return
     */
    List<Echarts> getEmployeeCount();

    /**
     * 查询1队员工总数
     * @return
     */
    List<Echarts> getOneTeamCount();

    /**
     * 查询2队员工总数
     * @return
     */
    List<Echarts> getTwoTeamCount();

    /**
     * 查询3队员工总数
     * @return
     */
    List<Echarts> getThreeTeamCount();

    /**
     * 查询4队员工总数
     * @return
     */
    List<Echarts> getFourTeamCount();
    /**
     * 查询5队员工总数
     * @return
     */
    List<Echarts> getFiveTeamCount();
    /**
     * 查询用户总数
     * @return
     */
    List<Echarts> getUsersCount();

    /**
     * 查询当日签到人数
     * @return
     */
    List<Echarts> getAttendanceCount();

    /**
     * 查询当日未签到人数
     * @return
     */
    List<Echarts> getUnAttendanceCount();

    /**
     * 查询1队当日签到人数
     * @return
     */
    List<Echarts> getOneTeamAttendanceCount();
    /**
     * 查询2队当日签到人数
     * @return
     */
    List<Echarts> getTwoTeamAttendanceCount();
    /**
     * 查询3队当日签到人数
     * @return
     */
    List<Echarts> getThreeTeamAttendanceCount();
    /**
     * 查询4队当日签到人数
     * @return
     */
    List<Echarts> getFourTeamAttendanceCount();
    /**
     * 查询5队当日签到人数
     * @return
     */
    List<Echarts> getFiveTeamAttendanceCount();
    /**
     * 查询1队当日未签到人数
     * @return
     */
    List<Echarts> getOneTeamUnAttendanceCount();
    /**
     * 查询2队当日未签到人数
     * @return
     */
    List<Echarts> getTwoTeamUnAttendanceCount();
    /**
     * 查询3队当日未签到人数
     * @return
     */
    List<Echarts> getThreeTeamUnAttendanceCount();
    /**
     * 查询4队当日未签到人数
     * @return
     */
    List<Echarts> getFourTeamUnAttendanceCount();
    /**
     * 查询5队当日未签到人数
     * @return
     */
    List<Echarts> getFiveTeamUnAttendanceCount();
    /**
     * 查询系统登录成功次数
     * @return
     */
    List<Echarts> getSystemLoginSuccessCount();
    /**
     * 查询系统登录失败次数
     * @return
     */
    List<Echarts> getSystemLoginFailCount();
    /**
     * 查询系统登录总次数
     * @return
     */
    List<Echarts> getSystemLoginCount();

    void deleteTable();
    /**
     * 更新系统登录成功次数
     */
    void updateSystemLoginSuccessCount();
    /**
     * 更新系统登录失败次数
     */
    void updateSystemLoginFailCount();

    void updateEmployeeCount();

    void updateOneTeamCount();

    void updateTwoTeamCount();

    void updateThreeTeamCount();

    void updateFourTeamCount();

    void updateFiveTeamCount();

    void updateUsersCount();

    void updateAttendanceCount();

    void updateUnAttendanceCount();

    void updateOneTeamAttendanceCount();

    void updateTwoTeamAttendanceCount();

    void updateThreeTeamAttendanceCount();

    void updateFourTeamAttendanceCount();

    void updateFiveTeamAttendanceCount();

    void updateOneTeamUnAttendanceCount();

    void updateTwoTeamUnAttendanceCount();

    void updateThreeTeamUnAttendanceCount();

    void updateFourTeamUnAttendanceCount();

    void updateFiveTeamUnAttendanceCount();

    void updateSystemLoginCount();

}
