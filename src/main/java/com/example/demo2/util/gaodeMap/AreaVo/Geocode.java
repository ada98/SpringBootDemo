package com.example.demo2.util.gaodeMap.AreaVo;

import java.util.List;

/**
 * @Description: 地理编码信息类
 * @Author: ada
 * @Date: 2020/1/11 15:33
 * @Vervion: 1.0
 */
public class Geocode{
    //结构化地址信息,省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码
    private String formatted_address;
    // 注释原因，district，street 不同地址,一会传string,一会传list
//    //国家,国内地址默认返回中国
//    private String country;
//    //地址所在的城市名
//    private String province;
//    //地址所在的城市名
//    private String city;
//    //城市编码
//    private String citycode;
//    //地址所在的区
//    private List<String> district;
//    //街道,高德有病
//    private List<String> street;
//    //门牌，高德有病
//    private List<String> number;
    //区域编码,例如：110101
    private String adcode;
    //坐标点,经度，纬度
    private String location;
    //匹配级别
    private String level;

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
