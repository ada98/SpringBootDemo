package com.example.demo2.business.basic.controller;

import com.example.demo2.business.basic.service.GaodeMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 地图控制器
 * @Author: ada
 * @Date: 2020/1/13 21:40
 * @Vervion: 1.0
 */
@RestController
@RequestMapping("web/map")
@Api(value="地图控制器",tags={"地图操作接口"})
public class MapController {
    @Autowired
    private GaodeMapService gaodeMapService;

    @GetMapping("getAreaLocation/{address}")
    @ResponseBody
    @ApiOperation(value = "查询位置的经纬度", notes = "查询位置的经纬度")
    public String getAreaLocation(@PathVariable("address") String address){
        return gaodeMapService.getAreaLocationInfo(address);
    }



}
