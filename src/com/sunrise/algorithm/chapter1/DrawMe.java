package com.sunrise.algorithm.chapter1;

import com.sunrise.stdlib.StdDraw;
import com.sunrise.stdlib.StdRandom;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther: sunrise
 * @date: 2018/9/10 22:05
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class DrawMe {

    public static void lineme() {
        //坐标均在 0-1 之间的double数中
        StdDraw.line(0.01, 0.01, 0.5, 0.5);
    }

    /**
     * @description:
     * @param:   null
     * @return:
     * @auther: sunriseme
     * @date: 2018/9/10 22:27
     */
    public static void poitme() {
        StdDraw.point(0.3, 0.6);
    }

    // 三种函数曲线图
    public static void visulFunction(){
        int N = 100;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N*N);
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i <=N ; i++) {
            StdDraw.point(i,i);
            StdDraw.point(i,i*i);
            StdDraw.point(i,i*Math.log(i));
        }
    }

    //数组随机分布图
    //x,y代表是矩形中心的坐标。 rw, rh分别代表矩形宽的一半，和高的一半

    /*
    java中，当两个整数相除时，由于小数点以后的数字会被截断，运算结果将为整数，此时若希望得到运算结果为浮点数，

    必须将两整数其一或是两者都强制转换为浮点数。因为int 是整数，整数除整数就是整数double是小数。小数除小数才是小数

    转换成double，或直接定义成double
     */
    public static void arrayRandomPicture(){
        int N = 50;
        double[] arrays = new double[N];

        for (int i = 0; i <N ; i++) {
            arrays[i] = StdRandom.uniform(0.0,1.0);
            //System.out.println(arrays[i]);
        }

       drawRectangleForArray(arrays,N);

    }

    /**
     * @description:  对一个素组画出条形图
     * @param:   null
     * @return:
     * @auther: sunriseme
     * @date: 2018/9/10 23:38
     */
    public static void drawRectangleForArray(double[] arrays,int N){
        for (int i = 0; i <N ; i++) {
            //这里需要注意一下java的一个小坑
            /*
            System.out.println(1.0*5/100); ----> 0.05
            System.out.println(1.0*(5/100));---->0.0
            java 的整数 / 整数，只会保留整数位，如果这时候是小于1的正小数，则得到的答案为0.0
             */
            double x = 1.0*i/N;
            double y = arrays[i]/2.0;
            double halfWidth = 0.5/N;
            double halfHeight = arrays[i]/2.0;
            StdDraw.filledRectangle(x,y,halfWidth,halfHeight);
        }
    }
    /**
     * @description: 已排序的随机数组
     * @param:   null
     * @return:
     * @auther: sunriseme
     * @date: 2018/9/10 23:33
     */
    public static void sortedArrayPicture(){
        int N = 50;
        double[] arrays = new double[N];

        for (int i = 0; i <N ; i++) {
            arrays[i] = StdRandom.uniform(0.0,1.0);
            //System.out.println(arrays[i]);
        }
        Arrays.sort(arrays);

        drawRectangleForArray(arrays,N);
    }

    public static void main(String[] args) {
        /*
        lineme();
        poitme();

        StdDraw.setPenColor(255, 0, 0);
        StdDraw.setCanvasSize();
        StdDraw.line(0.01, 0.01, 0.5, 0.5);
        StdDraw.point(0.8, 0.8);
        StdDraw.text(0.8, 0.8,"fuck ccp deep");
        StdDraw.circle(20,20,30);

        visulFunction();

        arrayRandomPicture();


         */

        sortedArrayPicture();
        double s = 0.125125;
        double g = s/2;
        System.out.println(g);
        System.out.println(1.0*5/100);
        System.out.println(1.0*(5/100));





    }
}
