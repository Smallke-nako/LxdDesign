package com.example.lxd.mapper;

import com.example.lxd.entity.Echarts;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EchartsMapper {
    /**
     * 查询员工总数
     * @return
     */
    List<Echarts> selectEmployeeCount();

    /**
     * 查询1队员工总数
     * @return
     */
    List<Echarts> selectOneTeamCount();

    /**
     * 查询2队员工总数
     * @return
     */
    List<Echarts> selectTwoTeamCount();

    /**
     * 查询3队员工总数
     * @return
     */
    List<Echarts> selectThreeTeamCount();

    /**
     * 查询4队员工总数
     * @return
     */
    List<Echarts> selectFourTeamCount();

    /**
     * 查询5队员工总数
     * @return
     */
    List<Echarts> selectFiveTeamCount();

    /**
     * 查询用户总数
     * @return
     */
    List<Echarts>  selectUsersCount();

    /**
     * 查询当日签到人数
     * @return
     */
    List<Echarts>  selectAttendanceCount();

    /**
     * 查询当日未签到人数
     * @return
     */
    List<Echarts>  selectUnAttendanceCount();

    /**
     * 查询1队签到人数
     * @return
     */
    List<Echarts> selectOneTeamAttendanceCount();

    /**
     * 查询1队未签到人数
     * @return
     */
    List<Echarts> selectOneTeamUnAttendanceCount();

    /**
     * 查询2队签到人数
     * @return
     */
    List<Echarts> selectTwoTeamAttendanceCount();

    /**
     * 查询2队未签到人数
     * @return
     */
    List<Echarts> selectTwoTeamUnAttendanceCount();

    /**
     * 查询3队签到人数
     * @return
     */
    List<Echarts> selectThreeTeamAttendanceCount();

    /**
     * 查询3队未签到人数
     * @return
     */
    List<Echarts> selectThreeTeamUnAttendanceCount();

    /**
     * 查询4队签到人数
     * @return
     */
    List<Echarts> selectFourTeamAttendanceCount();

    /**
     * 查询4队未签到人数
     * @return
     */
    List<Echarts> selectFourTeamUnAttendanceCount();

    /**
     * 查询5队签到人数
     * @return
     */
    List<Echarts> selectFiveTeamAttendanceCount();

    /**
     * 查询5队未签到人数
     * @return
     */
    List<Echarts> selectFiveTeamUnAttendanceCount();
    /**
     * 查询系统登录成功次数
     * @return
     */
    List<Echarts> selectSystemLoginSuccessCount();
    /**
     * 查询系统登录失败次数
     * @return
     */
    List<Echarts> selectSystemLoginFailCount();

    /**
     * 查询系统总登录次数
     * @return
     */
    List<Echarts> selectSystemLoginCount();

    void deleteA();


    /**
     * 更新系统登录成功次数
     */
    void updateSystemLoginSuccessCount();
    /**
     * 更新系统登录失败次数
     */
    void updateSystemLoginFailCount();


    void updateSystemLoginCount();

    /**
     * 更新员工总数
     */
    void updateEmloyeeCount();


    void updateUsersCount();

    /**
     * 更新1队员工总数
     */
    void updateOneTeamCount();

    /**
     * 更新2队员工总数
     */
    void updateTwoTeamCount();

    /**
     * 更新3队员工总数
     */
    void updateThreeTeamCount();

    /**
     * 更新4队员工总数
     */
    void updateFourTeamCount();

    /**
     * 更新5队员工总数
     */
    void updateFiveTeamCount();

    /**
     * 更新今日签到人数
     */
    void updateAttendanceCount();

    /**
     * 更新今日未签到人数
     */
    void updateUnAttendanceCount();

    /**
     * 更新1队今日签到人数
     */
    void updateOneTeamAttendanceCount();

    /**
     * 更新2队今日签到人数
     */
    void updateTwoTeamAttendanceCount();

    /**
     * 更新3队今日签到人数
     */
    void updateThreeTeamAttendanceCount();

    /**
     * 更新4队今日签到人数
     */
    void updateFourTeamAttendanceCount();

    /**
     * 更新5队今日签到人数
     */
    void updateFiveTeamAttendanceCount();

    /**
     * 更新1队今日未签到人数
     */
    void updateOneTeamUnAttendanceCount();

    /**
     * 更新2队今日未签到人数
     */
    void updateTwoTeamUnAttendanceCount();

    /**
     * 更新3队今日未签到人数
     */
    void updateThreeTeamUnAttendanceCount();

    /**
     * 更新4队今日未签到人数
     */
    void updateFourTeamUnAttendanceCount();

    /**
     * 更新5队今日未签到人数
     */
    void updateFiveTeamUnAttendanceCount();

}
