package com.example.lxd.controller;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.config.page.PageResult;
import com.example.lxd.controller.common.PageRequestApi;
import com.example.lxd.entity.Warning;
import com.example.lxd.service.WarningService;
import com.example.lxd.util.JsonResult;
import com.example.lxd.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "危险区域不佩戴安全帽记录")
@CrossOrigin
@RestController
@RequestMapping("/warn")
public class WarningCheckController {
    @Autowired
    WarningService warningService;

    /**
     * 查询图片列表
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "获取图片列表")
    @PostMapping("/list")
    public JsonResult<Object> list(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest){
        List<Warning> warningList = warningService.findAll(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(warningList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(),pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 删除
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "删除图片")
    @PostMapping("/delete")
    public JsonResult<Object> imageDelete(@RequestParam(value = "id") int id) {
        warningService.deletePicture(id);
        return JsonResult.success();
    }
}
