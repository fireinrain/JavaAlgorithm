package com.sunrise.algorithm.chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: sunrise
 * @date: 2018/9/7 22:18
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class TestMe<T> {

    private T t;


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static <T> T mains(T t) {
        return t;
    }


    public static void main(String[] args) {
//        TestMe<String> stringTestMe = new TestMe<String>();
//        stringTestMe.setT("abdsc");
//        System.out.println(stringTestMe.getT());

        G<String, Integer> g = (s) -> s.length();
        F<Integer, Boolean> f = (x) -> x % 2 != 0;
        List<String> strings = Arrays.asList("a", "abc", "abcde", "sdsddsdsds");
        List<Integer> collect = strings.stream().map(e -> e.length())
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("collect:" + collect);
    }
}


interface G<A, B> {
    B apply(A a);
}

interface F<B, C> {
    C apply(B b);
}

interface FG<A, B, C> {
    C apply(A a);
}
