package com.example.demo2.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;
import java.util.*;

/**
 * @Description: 读取英文pdf并输出
 * @Author: ada
 * @Date: 2020/4/25 23:16
 * @Vervion: 1.0
 */
public class PdfUtil {
    public static void main(String[] args) throws IOException {
        getWordsFromPdf("e:/Thinking In Java（英文版 第四版）.pdf","e:/2.txt",15);
    }
    /*
    * @Desciption: 从英文pdf中读取出现频率最高的单词，并输出到txt中
    * @param readPath   pdf文件位置
    * @param outPath    输出位置
    * @param p  出现次数
    * @Return: void
    * @Author: ada
    * @Date: 2020/4/26 0:51
    * @Version: 1.0
    */
    public static void getWordsFromPdf(String readPath,String outPath,int p)  {
        String pdfContent="";
        try {
            pdfContent=readPDFtoFile(readPath);
        } catch (IOException e) {
            System.out.println(readPath+"：文件读取异常");
        }
        if(pdfContent!=""){
            String[] lineWords=pdfContent.split("[^a-zA-z]");
            //单词-数字表
            Map<String,Integer> map=getTable(lineWords);
            List<Map.Entry<String,Integer>> list=sortMap(map);
            try {
                outFile(list,p,outPath);
            } catch (IOException e) {
                System.out.println(outPath+"：文件输出异常");
            }
        }
    }

    /*
    * @Desciption: 把排序后的list，按出现次数降序，按行输入到txt文件中
    * @param list   排序后的list
    * @param p      出现次数
    * @param path   保存文件路径
    * @Return: void
    * @Author: ada
    * @Date: 2020/4/26 0:45
    * @Version: 1.0
    */
    public static void outFile(List<Map.Entry<String,Integer>> list,int p,String path) throws IOException {
        Map.Entry<String, Integer> mapping = null;
        File file = new File(path);
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (int i = 0 ;i<list.size() ;i++) {
            mapping = list.get(i);
            if (mapping.getValue()>p){
                writer.write(mapping.getKey() + "\r\n");
                //System.out.println(mapping.getKey() + "=" + mapping.getValue());
            }
        }
        writer.close();
        System.out.println("出现频率为"+p+"次的单词已经按降序已经输入到："+path);
    }

    /*
    * @Desciption: 对单词-数量表，进行排序，得到排序后的数组
    * @param map 单词-数量表
    * @Return: java.util.List<java.util.Map.Entry<java.lang.String,java.lang.Integer>>  排序后的数组
    * @Author: ada
    * @Date: 2020/4/26 0:24
    * @Version: 1.0
    */
    public static List<Map.Entry<String,Integer>> sortMap(Map<String,Integer> map){
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> mapping2, Map.Entry<String, Integer> mapping1){
                return mapping1.getValue().compareTo(mapping2.getValue());
            }
        });
        return list;
    }

    /*
    * @Desciption: 输入内容数组，得到单词-数量表
    * @param content 内容数组
    * @Return: java.util.Map<java.lang.String,java.lang.Integer> 单词-数量表
    * @Author: ada
    * @Date: 2020/4/26 0:21
    * @Version: 1.0
    */
    public static Map<String,Integer> getTable(String[] content){
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<content.length;i++){
            if(content[i].length()>0 && content[i]!=""){
                if(map.containsKey(content[i])){
                    map.put(content[i],map.get(content[i])+1);
                }else{
                    map.put(content[i],0);
                }
            }
        }
        return map;
    }

    /*
    * @Desciption: 读取PDf内容，返回string
    * @param sourceFile pdf文件路径
    * @Return: java.lang.String
    * @Author: ada
    * @Date: 2020/4/25 23:18
    * @Version: 1.0
    */
    public static String readPDFtoFile(String sourceFile) throws IOException {
        //创建文档对象
        PDDocument doc =null;
        String content="";
        //加载一个pdf对象
        doc =PDDocument.load(new File(sourceFile));
        //获取一个PDFTextStripper文本剥离对象
        PDFTextStripper textStripper =new PDFTextStripper("GBK");
        content=textStripper.getText(doc);
        //System.out.println("内容:"+content);
        //System.out.println("全部页数"+doc.getNumberOfPages());
        //关闭文档
        doc.close();
        return content;
    }
}
