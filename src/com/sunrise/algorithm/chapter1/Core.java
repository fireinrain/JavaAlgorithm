package com.sunrise.algorithm.chapter1;

/**
 * @auther: sunrise
 * @date: 2018/8/28 20:24
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class Core {

    /**
     * @description: 欧几里得算法
     * 计算两个非负整数p,q 的最大公约数
     * p = 14 q = 7 r = p%q = (2余0)，所以r = 0
     * 此时 p = 7 q = 0 返回p
     * p = 8 q = 24 r = p%q = (0余8)，所以r = 8
     * 此时 p = 24，q = 8 r = p%q= (3余0)，所以r = 0
     * 此时 p = 8,q = 0  返回p
     * <p>
     * 分析： 最大公约数肯定比pq两个值中的最小的一个要小 或者相等
     * @param: * @param
     * @return:
     * @auther: sunriseme
     * @date: 2018/8/28 20:24
     */
    public static int euclid(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return euclid(q, r);

    }

    //效率低下的算法啊
    public static int stupid_euclid(int p, int q) {
        if (p > q) {
            return stupid_euclid(q, p);
        }
        if (p == q) {
            return q;
        }
        if (q > p) {
            for (int i = p; i <= p; i--) {
                if ((p % i) == 0 && (q % i) == 0) {
                    return i;
                } else {
                    continue;
                }
            }
        }
        return q;
    }

    public static void main(String[] args) {
        System.out.println(euclid(14, 324523));
        System.out.println(euclid(8, 24));
        System.out.println(8 % 24);
        System.out.println(stupid_euclid(324523, 1444445455));
    }
}
