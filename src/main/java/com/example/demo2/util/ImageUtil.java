package com.example.demo2.util;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageUtil {

    public static void cut(int x,int y,int width,int height,String srcpath,String subpath) throws IOException {//裁剪方法
        FileInputStream is=null;
        ImageInputStream iis=null;
        try{
            is=new FileInputStream(srcpath); //读取原始图片
            Iterator<ImageReader>it=ImageIO.getImageReadersByFormatName("jpg"); //ImageReader声称能够解码指定格式
            ImageReader reader=it.next();
            iis=ImageIO.createImageInputStream(is); //获取图片流
            reader.setInput(iis, true); //将iis标记为true（只向前搜索）意味着包含在输入源中的图像将只按顺序读取
            ImageReadParam param=reader.getDefaultReadParam(); //指定如何在输入时从 Java Image I/O框架的上下文中的流转换一幅图像或一组图像
            Rectangle rect=new Rectangle(x, y, width, height); //定义空间中的一个区域
            param.setSourceRegion(rect); //提供一个 BufferedImage，将其用作解码像素数据的目标。
            BufferedImage bi=reader.read(0, param); //读取索引imageIndex指定的对象
            ImageIO.write(bi, "jpg", new File(subpath)); //保存新图片
        }finally{
            if(is!= null)
                is.close();
            if(iis != null)
                iis.close();
        }
    }

    private void cutByTemplate2(BufferedImage oriImage,BufferedImage newSrc,BufferedImage newSrc2,int x,int y,int width,int height){
        //固定圆半径为5
        int c_r=20;
        double rr=Math.pow(c_r, 2);//r平方
        //圆心的位置
        Random rand=new Random();
        int c_a=rand.nextInt(width-2*c_r)+(x+c_r);//x+c_r+10;//圆心x坐标必须在(x+r,x+with-r)范围内
        //System.out.println(c_a);
        int c_b=y;

        //第二个圆（排除圆内的点）
        Random rand2=new Random();
        int c2_a=x;
        int c2_b=rand2.nextInt(height-2*c_r)+(y+c_r);//y+c_r+50;//圆心y坐标必须在(y+r,y+height-r)范围内

        //System.out.println(oriImage.getWidth()+"   "+oriImage.getHeight());
        for(int i=0;i<oriImage.getWidth();i++){
            for(int j=0;j<oriImage.getHeight();j++){
                //data[i][j]=oriImage.getRGB(i,j);

                //(x-a)²+(y-b)²=r²中，有三个参数a、b、r，即圆心坐标为(a，b)，半径r。
                double f=Math.pow((i-c_a), 2)+Math.pow((j-c_b), 2);

                double f2=Math.pow((i-c2_a), 2)+Math.pow((j-c2_b), 2);

                int rgb=oriImage.getRGB(i,j);
                if(i>=x&&i<(x+width) &&j>=y&&j<(y+height) && f2>=rr){//在矩形内
                    //块范围内的值
                    in(newSrc, newSrc2, i, j, rgb);
                }else if(f<=rr){
                    //在圆内
                    in(newSrc, newSrc2, i, j, rgb);
                }else{
                    //剩余位置设置成透明
                    out(newSrc, newSrc2, i, j, rgb);
                }

            }
        }

    }

    private void in(BufferedImage newSrc,BufferedImage newSrc2,int i,int j,int rgb){
        newSrc.setRGB(i, j, rgb);
        //原图设置变灰
        int r = (0xff & rgb);
        int g = (0xff & (rgb >> 8));
        int b = (0xff & (rgb >> 16));
        rgb = r + (g << 8) + (b << 16) + (100 << 24);
        //rgb = r + (g << 8) + (b << 16);
        newSrc2.setRGB(i, j, rgb);
    }

    private void out(BufferedImage newSrc,BufferedImage newSrc2,int i,int j,int rgb){
        newSrc.setRGB(i, j, 0x00ffffff);
        newSrc2.setRGB(i, j, rgb);
    }

    /**
     * 生成图片，并返回偏移值和图片路径
     *  实现随机读取指定文件夹下的png图片，存入session中
     * @return
     */
    public Map<String,String> getSlideSetting() throws IOException {
        Map<String,String> setMap=new HashMap<String,String>();
        File file = new File("E:\\java\\ideaWorkspace\\demo2\\src\\main\\resources\\static\\image\\slideImage\\测试1.png");// 参数为空
        String filePath = file.getCanonicalPath();
        int dir=filePath.lastIndexOf(File.separator);
        int houzhui=filePath.lastIndexOf(".png");
        String fileDir=filePath.substring(0,dir);
        String fileName=filePath.substring(dir+1,houzhui);
        String imageSlide=fileDir+File.separator+fileName+"s.png";
        String imageCut=fileDir+File.separator+fileName+"c.png";

        ImageUtil tt=new ImageUtil();
        //图片必须是png格式，因为需要做透明背景
        //原图
        BufferedImage src=ImageIO.read(file);
        //移动图
        BufferedImage newSrc=new BufferedImage(src.getWidth(), src.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);//新建一个类型支持透明的BufferedImage
        //对比图
        BufferedImage newSrc2=new BufferedImage(newSrc.getWidth(), newSrc.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);//新建一个类型支持透明的BufferedImage

        //抠块的大小
        int blockWidth=100;
        int blockHeight=100;

        Random rand1=new Random();
        int x=rand1.nextInt(src.getWidth()-blockWidth-20)+100;//10,width-200
        System.out.println(x);
        Random rand2=new Random();
        //int y=rand2.nextInt(src.getHeight()-blockHeight-20)+20;//
        int y=200;
        tt.cutByTemplate2(src,newSrc,newSrc2,x,y,blockWidth,blockHeight);//图片大小是固定，位置是随机

        //生成移动图
        ImageIO.write(newSrc, "png", new File(imageSlide));
        //生成对比图
        ImageIO.write(newSrc2, "png", new File(imageCut));
        setMap.put("x",x+"");
        setMap.put("y",y+"");
        setMap.put("imageSlide",imageSlide);
        setMap.put("imageCut",imageCut);
        return setMap;
    }

    public static void main(String[]args)throws Exception {
        System.out.println(new Date().getTime());
        File file = new File("E:\\java\\ideaWorkspace\\demo2\\src\\main\\resources\\static\\image\\slideImage\\测试1.png");// 参数为空
        String filePath = file.getCanonicalPath();
        int dir=filePath.lastIndexOf(File.separator);
        int houzhui=filePath.lastIndexOf(".png");
        String fileDir=filePath.substring(0,dir);
        String fileName=filePath.substring(dir+1,houzhui);
        String imageSlide=fileDir+File.separator+fileName+"s.png";
        String imagCut=fileDir+File.separator+fileName+"c.png";

        ImageUtil tt=new ImageUtil();
        //图片必须是png格式，因为需要做透明背景
        //原图
        BufferedImage src=ImageIO.read(file);
        //移动图
        BufferedImage newSrc=new BufferedImage(src.getWidth(), src.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);//新建一个类型支持透明的BufferedImage
        //对比图
        BufferedImage newSrc2=new BufferedImage(src.getWidth(), src.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);//新建一个类型支持透明的BufferedImage

        //抠块的大小
        int blockWidth=200;
        int blockHeight=200;

        Random rand1=new Random();
        int x=rand1.nextInt(src.getWidth()-blockWidth-20)+20;//10,width-200
        Random rand2=new Random();
        int y=rand2.nextInt(src.getHeight()-blockHeight-20)+20;//
        tt.cutByTemplate2(src,newSrc,newSrc2,x,y,blockWidth,blockHeight);//图片大小是固定，位置是随机

        //生成移动图
        ImageIO.write(newSrc, "png", new File(imageSlide));
        //生成对比图
        ImageIO.write(newSrc2, "png", new File(imagCut));
        System.out.println(new Date().getTime());

    }
}
