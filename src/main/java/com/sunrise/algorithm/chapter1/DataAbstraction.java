package com.sunrise.algorithm.chapter1;

import com.sunrise.stdlib.StdOut;
import com.sunrise.stdlib.StdRandom;

/**
 * @auther: sunrise
 * @date: 2018/9/16 17:01
 * @description: 第一章 第二小节 数据抽象
 * @Gmail: liu575563079@gmail.com
 */
public class DataAbstraction {
    public static void main(String[] args) {
        Counter counter = new Counter("gas counter");

    }





}

//投掷骰子
class Rolls{
    public static void main(String[] args) {
        //需要用 java Rolls 10
        //int T = Integer.valueOf(args[0]);
        int T = 1000;
        int SIDES = 6;

        Counter[] conters = new Counter[SIDES+1];
        for (int i = 1; i <=SIDES ; i++) {
            conters[i] = new Counter(i+"'s");
        }

        for (int t = 0; t < T; t++) {
            int result  = StdRandom.uniform(1,SIDES+1);
            conters[result].increase();
        }

        for (int i = 1; i <conters.length ; i++) {
            StdOut.println(conters[i]);
        }
    }
}


//投掷硬币
class Flips{
    public static void main(String[] args) {
        //需要用 java Flips 10
        //int T = Integer.valueOf(args[0]);
        int T = 1000;
        Counter heads = new Counter("heads");
        Counter tails =  new Counter("tails");

        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli(0.5)){
                heads.increase();
            }else{
                tails.increase();
            }
        }

        StdOut.println(heads);
        StdOut.println(tails);
        //差距
        int d = heads.tally() - tails.tally();
        StdOut.println("delta: "+Math.abs(d));
    }
}

//计数器
class Counter{
    private String id;
    private int count;
    public Counter(String id) {
        this.id = id;
    }
    public void increase(){
        this.count +=1;
    }

    public int tally(){
        return this.count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
