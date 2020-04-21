package com.example.demo2.util.gaodeMap.AreaVo;

/**
 * @ClassName: GeocodeParameterVo
 * @Description: 地理编码API服务,请求参数类
 * @Author: ada
 * @Date: 2020/1/11 15:04
 * @Vervion: 1.0
 */
public class GeocodeParameterVo {
    //高德Key|必填
    private String key;
    //结构化地址信息|必填,
    // 规则遵循：国家、省份、城市、区县、城镇、乡村、街道、门牌号码、屋邨、大厦，如：北京市朝阳区阜通东大街6号。
    // 如果需要解析多个地址的话，请用"|"进行间隔，并且将 batch 参数设置为 true，最多支持 10 个地址进进行"|"分割形式的请求
    private String address;
    //指定查询的城市
    private String city;
    //批量查询控制
    private Boolean batch;
    //数字签名
    private String sig;
    //返回数据格式类型
    //可选输入内容包括：JSON，XML。设置 JSON 返回结果数据将会以JSON结构构成；如果设置 XML 返回结果数据将以 XML 结构构成。
    private String output;
    //回调函数:callback 值是用户定义的函数名称，此参数只在 output 参数设置为 JSON 时有效。
    private String callback;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getBatch() {
        return batch;
    }

    public void setBatch(Boolean batch) {
        this.batch = batch;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
