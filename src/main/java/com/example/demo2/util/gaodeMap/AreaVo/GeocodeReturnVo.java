package com.example.demo2.util.gaodeMap.AreaVo;

import java.util.List;

/**
 * @ClassName: GeocodeReturnVo
 * @Description: 地理编码API服务,返回参数类
 * @Author: ada
 * @Date: 2020/1/11 15:12
 * @Vervion: 1.0
 */
public class GeocodeReturnVo {
    //返回结果状态值 返回值为 0 或 1，0 表示请求失败；1 表示请求成功。
    private Integer status;
    //返回结果数目
    private Integer count;
    //返回状态说明,当status为0时，info会返回具体错误原因，否则返回“OK”。详情可以参阅info状态表
    private String info;
    //地理编码信息列表
    private List<Geocode> geocodes;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Geocode> getGeocodes() {
        return geocodes;
    }

    public void setGeocodes(List<Geocode> geocodes) {
        this.geocodes = geocodes;
    }
}