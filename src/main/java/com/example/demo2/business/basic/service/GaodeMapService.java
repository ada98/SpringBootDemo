package com.example.demo2.business.basic.service;

import com.example.demo2.util.gaodeMap.AreaVo.Geocode;
import com.example.demo2.util.gaodeMap.AreaVo.GeocodeParameterVo;
import com.example.demo2.util.gaodeMap.AreaVo.GeocodeReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GaodeMapService {
    @Autowired
    private RestTemplate restTemplate;//这样就可以直接调用api使用了或者直接new对象也一样
    @Value("${gaodeKey}")
    private String gaodeKey;
    @Value("${geocodeUrl}")
    private String geocodeUrl;


    /*
    * @Desciption:  输入中文地址，获取该地址经纬度
    * @param address:如：北京市朝阳区阜通东大街6号。
    * @Return: java.lang.String
    * @Author: ada
    * @Date: 2020/1/11 14:52
    * @Version: 1.0
    */
    public String getAreaLocationInfo(String address){
        GeocodeReturnVo geocodeReturnVo=getAreaInfo(address);
        if(geocodeReturnVo==null){
            return "无法访问服务提供商";
        }
        String location=geocodeReturnVo.getGeocodes().get(0).getLocation();
        return location;
    }

    /*
    * @Desciption: 输入中文地址，获取该地址经纬度等相关信息
    * @param address: 中文地址
    * @Return: com.example.demo2.util.gaodeMap.AreaVo.Geocode
    * @Author: ada
    * @Date: 2020/1/11 15:36
    * @Version: 1.0
    */
    public GeocodeReturnVo getAreaInfo(String address){
        GeocodeParameterVo geocodeParameterVo=new GeocodeParameterVo();
        geocodeParameterVo.setKey(gaodeKey);
        geocodeParameterVo.setAddress(address);
        Map<String,Object> map=new HashMap<>();
        map.put("key",gaodeKey);
        map.put("address",address);
        String url="https://restapi.amap.com/v3/geocode/geo?key=&address=深圳南山";
        //参数没有随着发送过去
        ResponseEntity<GeocodeReturnVo> responseEntity1 = restTemplate.getForEntity(geocodeUrl,GeocodeReturnVo.class,map);
        HttpStatus statusCode = responseEntity1.getStatusCode();
        if(!statusCode.is2xxSuccessful()){
            return null;
        }else{
            GeocodeReturnVo geocodeReturnVo = responseEntity1.getBody();
            return geocodeReturnVo;
        }
    }

}
