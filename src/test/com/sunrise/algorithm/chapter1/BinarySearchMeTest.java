package com.sunrise.algorithm.chapter1;

import com.sunrise.algorithm.annotation.ComputeTimer;
import com.sunrise.algorithm.util.ComputeTimeUtil;

import java.util.*;

import static org.junit.Assert.*;

/** 测试计算方法运行时间的注解
 * @auther: sunrise
 * @date: 2018/9/12 23:16
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class BinarySearchMeTest {

    @ComputeTimer
    public void arrayListAdd() {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            l.add(1);
        }
    }

    @ComputeTimer
    public void linkedListAdd() {
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            l.add(1);
        }
    }

    @ComputeTimer
    public void vectorAdd() {
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i < 10000000; i++) {
            v.add(1);
        }
    }

    @ComputeTimer
    public void arrayAdd() {
        int[] v = new int[1000_0000];
        for (int i = 0; i < 10000000; i++) {
            v[i] = 1;
        }
    }



    public static void main(String[] args) {
        ComputeTimeUtil computeTimeUtil = new ComputeTimeUtil();
        computeTimeUtil.computeTime();
    }
}