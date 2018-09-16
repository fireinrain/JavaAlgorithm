package com.sunrise.algorithm.chapter1;

/**
 * @auther: sunrise
 * @date: 2018/9/16 17:01
 * @description: 第一章 第二小节 数据抽象
 * @Gmail: liu575563079@gmail.com
 */
public class DataAbstraction {
    public static void main(String[] args) {
        Counter counter = new DataAbstraction().new Counter("gas counter");

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

}
