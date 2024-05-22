package com.example.lxd.controller;

import cn.hutool.core.util.StrUtil;
import com.example.lxd.config.page.PageRequest;
import com.example.lxd.config.page.PageResult;
import com.example.lxd.controller.common.PageRequestApi;
import com.example.lxd.entity.Employee;
import com.example.lxd.service.EchartsService;
import com.example.lxd.service.EmployeeService;
import com.example.lxd.util.JsonResult;
import com.example.lxd.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "员工信息")
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EchartsService echartsService;

    /**
     * 获取用户列表
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "员工列表")
    @PostMapping("/list")
    public JsonResult<Object> list(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest){
        List<Employee> employeeList = employeeService.findAll(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(employeeList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(),pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     *
     * 修改员工信息
     */
    @CrossOrigin
    @ApiOperation(value = "修改员工信息")
    @PostMapping("/update")
    public JsonResult<Object> employeeUpdate(@RequestBody @Valid Employee employee) {
        if (StrUtil.isEmpty(employee.getName()) || StrUtil.isEmpty(employee.getNumber())||employee.getPhone()==null || StrUtil.isEmpty(employee.getTeam())){
            return JsonResult.error("员工信息不能为空");
        }else {
            employeeService.updateEmployee(employee);
            return JsonResult.success();
        }
    }
    /**
     *
     * 添加员工信息
     */
    @CrossOrigin
    @ApiOperation(value = "添加员工信息")
    @PostMapping("/create")
    public JsonResult<Object> employeeCreate(@RequestBody @Valid Employee employee){
        if (StrUtil.isEmpty(employee.getName()) || StrUtil.isEmpty(employee.getNumber())||employee.getPhone()==null || StrUtil.isEmpty(employee.getTeam())){
            return JsonResult.error("员工信息不能为空");
        }else {
            employeeService.createEmployee(employee);
            echartsService.updateEmployeeCount();
            switch (employee.getTeam()) {
                case "1队":
                    echartsService.updateOneTeamCount();
                    break;
                case "2队":
                    echartsService.updateTwoTeamCount();
                    break;
                case "3队":
                    echartsService.updateThreeTeamCount();
                    break;
                case "4队":
                    echartsService.updateFourTeamCount();
                    break;
                case "5队":
                    echartsService.updateFiveTeamCount();
                    break;
            }
            return JsonResult.success();
        }
    }
    /**
     * 删除
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "删除员工")
    @PostMapping("/delete")
    public JsonResult<Object> userDelete(@RequestParam(value = "id") int id) {
        employeeService.deleteEmployee(id);
        return JsonResult.success();
    }

    /**
     * 查找
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "查找员工")
    @PostMapping("/search")
    public JsonResult<Object> userSearch(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest,@RequestParam String name) {
        List<Employee> employeeList = employeeService.findByName(pageRequest.getBody(),name);
        PageInfo pageInfo = new PageInfo(employeeList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(),pageInfo);
        return JsonResult.success(pageResult);
    }
}
