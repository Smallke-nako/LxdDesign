package com.example.lxd.service.impl;

import com.example.lxd.entity.Echarts;
import com.example.lxd.mapper.EchartsMapper;
import com.example.lxd.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchartsServiceImpl implements EchartsService {
    @Autowired
    EchartsMapper echartsMapper;

    @Override
    public List<Echarts> getEmployeeCount() {
        return echartsMapper.selectEmployeeCount();
    }

    @Override
    public List<Echarts> getOneTeamCount() {
        return echartsMapper.selectOneTeamCount();
    }

    @Override
    public List<Echarts> getTwoTeamCount() {
        return echartsMapper.selectTwoTeamCount();
    }

    @Override
    public List<Echarts> getThreeTeamCount() {
        return echartsMapper.selectThreeTeamCount();
    }

    @Override
    public List<Echarts> getFourTeamCount() {
        return echartsMapper.selectFourTeamCount();
    }

    @Override
    public List<Echarts> getFiveTeamCount() {
        return echartsMapper.selectFiveTeamCount();
    }

    @Override
    public List<Echarts> getUsersCount() {
        return echartsMapper.selectUsersCount();
    }

    @Override
    public List<Echarts> getAttendanceCount() {
        return echartsMapper.selectAttendanceCount();
    }

    @Override
    public List<Echarts> getUnAttendanceCount() {
        return echartsMapper.selectUnAttendanceCount();
    }

    @Override
    public List<Echarts> getOneTeamAttendanceCount() {
        return echartsMapper.selectOneTeamAttendanceCount();
    }

    @Override
    public List<Echarts> getTwoTeamAttendanceCount() {
        return echartsMapper.selectTwoTeamAttendanceCount();
    }

    @Override
    public List<Echarts> getThreeTeamAttendanceCount() {
        return echartsMapper.selectThreeTeamAttendanceCount();
    }

    @Override
    public List<Echarts> getFourTeamAttendanceCount() {
        return echartsMapper.selectFourTeamAttendanceCount();
    }

    @Override
    public List<Echarts> getFiveTeamAttendanceCount() {
        return echartsMapper.selectFiveTeamAttendanceCount();
    }

    @Override
    public List<Echarts> getOneTeamUnAttendanceCount() {
        return echartsMapper.selectOneTeamUnAttendanceCount();
    }

    @Override
    public List<Echarts> getTwoTeamUnAttendanceCount() {
        return echartsMapper.selectTwoTeamUnAttendanceCount();
    }

    @Override
    public List<Echarts> getThreeTeamUnAttendanceCount() {
        return echartsMapper.selectThreeTeamUnAttendanceCount();
    }

    @Override
    public List<Echarts> getFourTeamUnAttendanceCount() {
        return echartsMapper.selectFourTeamUnAttendanceCount();
    }

    @Override
    public List<Echarts> getFiveTeamUnAttendanceCount() {
        return echartsMapper.selectFiveTeamUnAttendanceCount();
    }

    @Override
    public List<Echarts> getSystemLoginSuccessCount() {
        return echartsMapper.selectSystemLoginSuccessCount();
    }

    @Override
    public List<Echarts> getSystemLoginFailCount() {
        return echartsMapper.selectSystemLoginFailCount();
    }

    @Override
    public List<Echarts> getSystemLoginCount() {
        return echartsMapper.selectSystemLoginCount();
    }

    @Override
    public void deleteTable() {
        echartsMapper.deleteA();
    }

    @Override
    public void updateSystemLoginSuccessCount() {
        echartsMapper.updateSystemLoginSuccessCount();
    }

    @Override
    public void updateSystemLoginFailCount() {
        echartsMapper.updateSystemLoginFailCount();
    }

    @Override
    public void updateEmployeeCount() {
        echartsMapper.updateEmloyeeCount();
    }

    @Override
    public void updateOneTeamCount() {
        echartsMapper.updateOneTeamCount();
    }

    @Override
    public void updateTwoTeamCount() {
        echartsMapper.updateTwoTeamCount();
    }

    @Override
    public void updateThreeTeamCount() {
        echartsMapper.updateThreeTeamCount();
    }

    @Override
    public void updateFourTeamCount() {
        echartsMapper.updateFourTeamCount();
    }

    @Override
    public void updateFiveTeamCount() {
        echartsMapper.updateFiveTeamCount();
    }

    @Override
    public void updateUsersCount() {
        echartsMapper.updateUsersCount();
    }

    @Override
    public void updateAttendanceCount() {
        echartsMapper.updateAttendanceCount();
    }

    @Override
    public void updateUnAttendanceCount() {
        echartsMapper.updateUnAttendanceCount();
    }

    @Override
    public void updateOneTeamAttendanceCount() {
        echartsMapper.updateOneTeamAttendanceCount();
    }

    @Override
    public void updateTwoTeamAttendanceCount() {
        echartsMapper.updateTwoTeamAttendanceCount();
    }

    @Override
    public void updateThreeTeamAttendanceCount() {
        echartsMapper.updateThreeTeamAttendanceCount();
    }

    @Override
    public void updateFourTeamAttendanceCount() {
        echartsMapper.updateFourTeamAttendanceCount();
    }

    @Override
    public void updateFiveTeamAttendanceCount() {
        echartsMapper.updateFiveTeamAttendanceCount();
    }

    @Override
    public void updateOneTeamUnAttendanceCount() {
        echartsMapper.updateOneTeamUnAttendanceCount();
    }

    @Override
    public void updateTwoTeamUnAttendanceCount() {
        echartsMapper.updateTwoTeamUnAttendanceCount();
    }

    @Override
    public void updateThreeTeamUnAttendanceCount() {
        echartsMapper.updateThreeTeamUnAttendanceCount();
    }

    @Override
    public void updateFourTeamUnAttendanceCount() {
        echartsMapper.updateFourTeamUnAttendanceCount();
    }

    @Override
    public void updateFiveTeamUnAttendanceCount() {
        echartsMapper.updateFiveTeamUnAttendanceCount();
    }

    @Override
    public void updateSystemLoginCount() {
        echartsMapper.updateSystemLoginCount();
    }
}
