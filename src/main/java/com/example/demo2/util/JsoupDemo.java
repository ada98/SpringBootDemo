package com.example.demo2.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * 爬取時事熱點新聞
 */
public class JsoupDemo {

    public static String toutiaoUrl="https://www.toutiao.com/ch/news_hot/";
    public static String wangyiUrl="http://news.163.com/special/0001386F/rank_news.html";
    public static String baiduUrl="http://top.baidu.com/buzz?b=1&fr=20811";

    public static void main(String[] args) {
        Document doc=null;
        try{
            doc = Jsoup.connect(wangyiUrl).get();
            System.out.println(doc.title());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取首页失败");
        }
        Elements links = doc.select(".tabContents"); //带有href属性的a元素
        Element new24=links.get(1);
        Elements redEl=new24.getElementsByTag("tr");

        for(int i=1;i<=10;i++){
            Element e=redEl.get(i);
            if(e.getElementsByClass("red").hasText()){
                System.out.print("  排序："+e.getElementsByTag("span").html());
                System.out.print("  标题"+e.getElementsByTag("a").html());
                System.out.print("  点击数:"+e.getElementsByClass("cBlue").html());
                System.out.print("  链接："+e.getElementsByTag("a").attr("href"));
                System.out.println();
            }else{
                System.out.print("  排序："+e.getElementsByTag("span").html());
                System.out.print("  标题"+e.getElementsByTag("a").html());
                System.out.print("  点击数:"+e.getElementsByClass("cBlue").html());
                System.out.print("  链接："+e.getElementsByTag("a").attr("href"));
                System.out.println();
            }
        }
    }
}
