package com.example.demo2.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * 爬取招聘信息
 */
public class WordJsoupDemp {
    //https://www.zhipin.com/c101280600-p100101/?page=2&ka=page-2
    //深圳 java
    private static String bossUrl="https://www.zhipin.com/job_detail/?city=101280600&position=100101";
    private static String[] mJobTypes = {"android", "ios", "java", "python", "php", "h5", "大数据", "flutter", ""};
    private static int mIndex = 0;//切换不同岗位
    public static void main(String[] args) {
        Document boss;
        try{
            //获取编辑推荐页
            Document document = Jsoup.connect("https://www.zhipin.com/job_detail/?query=" + mJobTypes[mIndex] + "&city=101280100")
                    //模拟火狐浏览器
                    .userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .get();
            //获取工作列表数据
            Elements job_primary = document.select("div[class='job-primary']");
            System.out.println(111);
            //遍历取出每一条工作数据记录集合
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
