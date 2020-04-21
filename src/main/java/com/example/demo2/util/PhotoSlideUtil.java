package com.example.demo2.util;

import java.awt.image.BufferedImage;

/**
 * 登陆界面图片滑动校验类
 * 滑动验证码的核心流程：
 * 1.后端随机生成抠图和带有抠图阴影的背景图片，后台保存随机抠图位置坐标
 * 2.前端实现滑动交互，将抠图拼在抠图阴影之上，获取到用户滑动距离值
 * 3.前端将用户滑动距离值传入后端，后端校验误差是否在容许范围内。
 *
 * 滑动图形验证码，重要有两个图片组成，抠块和带有抠块阴影的原图，
 *  这里面有两个重要特性保证被暴力破解的难度：抠块的形状随机和抠块所在原图的位置随机。
 *  这样就可以在有限的图集中制造出随机的、无规律可寻的抠图和原图的配对。
 *
 */
public class PhotoSlideUtil {
    private static int targetLength=10;
    private static int targetWidth=20;
    private static int circleR=5;
    private static int r1=3;
    private static int d1=1;
    private static int d2=1;

    public static void main(String[] args) {
        //第一步，先确定一个抠出图的轮廓，方便后续真正开始执行图片处理操作
        //第二步，有这个轮廓后就可以依据这个二维数组的值来判定抠图并在原图上抠图位置处加阴影。
        //第三步.还需要对图片做进一步处理。一般有两件事需要做，一对图片做模糊处理增加机器识别难度，二做适当同质量压缩
    }

    /**
     * 得到抠图
     * @return
     */
    private static int[][] getBlockData() {
        //随机图片范围
        int[][] data = new int[targetLength][targetWidth];
        double x2 = targetLength-circleR-2;
        //随机生成圆的位置
        double h1 = circleR + Math.random() * (targetWidth-3*circleR-r1);
        double po = circleR*circleR;

        double xbegin = targetLength-circleR-r1;
        double ybegin = targetWidth-circleR-r1;

        for (int i = 0; i < targetLength; i++) {
            for (int j = 0; j < targetWidth; j++) {
                //右边○
                double d3 = Math.pow(i - x2,2) + Math.pow(j - h1,2);
                if (d1 <= po || (j >= ybegin && d2 >= po)|| (i >= xbegin && d3 >= po) ) {
                    data[i][j] = 0;
                }  else {
                    data[i][j] = 1;
                }
            }
        }
        return data;
    }

    /**
     * 切割图片
     * @param oriImage
     * @param targetImage
     * @param templateImage
     * @param x
     * @param y
     */
    private void cutByTemplate(BufferedImage oriImage, BufferedImage targetImage, int[][] templateImage, int x, int y){
        for (int i = 0; i < targetLength; i++) {
            for (int j = 0; j < targetWidth; j++) {
                int rgb = templateImage[i][j];
                // 原图中对应位置变色处理
                int rgb_ori = oriImage.getRGB(x + i, y + j);
                if (rgb == 1) {
                    //抠图上复制对应颜色值
                    targetImage.setRGB(i, y + j, rgb_ori);
                    int r = (0xff & rgb_ori);
                    int g = (0xff & (rgb_ori >> 8));
                    int b = (0xff & (rgb_ori >> 16));
                    rgb_ori = r + (g << 8) + (b << 16) + (200 << 24);
                    //原图对应位置颜色变化
                    oriImage.setRGB(x + i, y + j, rgb_ori);
                }
            }
        }
    }
}
