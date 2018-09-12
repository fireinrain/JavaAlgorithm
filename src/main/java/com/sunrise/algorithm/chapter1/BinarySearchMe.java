package com.sunrise.algorithm.chapter1;

import com.sunrise.stdlib.StdArrayIO;
import com.sunrise.stdlib.StdIn;

import java.io.*;
import java.util.Iterator;

/**
 * 二分法查找( 必须是一个有序的列表，或者数组）
 * 找出给定的值，在一个有序的列表中的第几个位置
 *
 * @auther: sunrise
 * @date: 2018/9/11 23:54
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class BinarySearchMe {

    public static Integer findIndex(int key, Integer[] arrays) {

        int start = 0;
        int end = arrays.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (key > arrays[middle]) {
                start = middle + 1;
            }
            if (key < arrays[middle]) {
                end = middle - 1;
            }
            if (key == arrays[middle]) {
                return middle;
            }
        }

        //表示在这个列表中不存在
        return -1;
    }

    public static void main(String[] args) {
        /*
        Integer[] arrays = new Integer[]{1,5,8,9,14};

        int index = BinarySearchMe.findIndex(8, arrays);
        System.out.println(index);
         */
        try (FileReader fileReader = new FileReader(new File("src\\main\\java\\datas\\largeT.txt"))) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = "";
            while (null != (temp = bufferedReader.readLine())) {
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
