package com.sunrise.algorithm.chapter1;

import com.sunrise.algorithm.annotation.ComputeTimer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @auther: sunrise
 * @date: 2018/9/12 23:16
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class BinarySearchMeTest {

    private Integer[] inters = new Integer[100000000];

    @Before
    public void setUp() throws Exception {
        //把读到内存中
        Random random = new Random();
        for (int i = 0; i <100000000 ; i++) {
            int randomInt = random.nextInt(100000)+1;
            this.inters[i] = randomInt;
        }

        Arrays.sort(this.inters);
    }

    @After
    public void tearDown() throws Exception {
        inters = null;
    }

    @Test
    @ComputeTimer
    public void findIndex() {
        BinarySearchMe.findIndex(362,this.inters);
    }
}