package com.sunrise.algorithm.chapter1;


import com.sunrise.stdlib.StdRandom;

/**
 * @auther: sunrise
 * @date: 2018/8/28 20:24
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class MathMe {

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

    /**
     * @description: 找到数组中最大的值
     * @param: arrays
     * @return: int
     * @auther: sunriseme
     * @date: 2018/8/29 22:16
     */
    public static int findMax(int[] arrays) {
        int max = arrays[0];
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] > max) {
                max = arrays[i];
            } else {
                continue;
            }
        }
        return max;
    }

    /**
     * @description: 计算平均值
     * @param: numbers
     * @return: double
     * @auther: sunriseme
     * @date: 2018/8/29 22:26
     */
    public static double averageNumbers(int[] numbers) {

        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return (double) total / numbers.length;
    }

    /**
     * @description: 复制数组
     * @param: sourceArray
     * @return: int[]
     * @auther: sunriseme
     * @date: 2018/8/29 22:34
     */
    public static int[] copyArrays(int[] sourceArray) {
        int[] targetArray = new int[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            targetArray[i] = sourceArray[i];
        }
        return targetArray;
    }

    /**
     * @description: 翻转数组，注意只需要前后交换的次数为数组长度的一半即可
     * @param: sourceArray
     * @return: int[]
     * @auther: sunriseme
     * @date: 2018/8/29 22:43
     */
    public static int[] reverseArray(int[] sourceArray) {

        for (int i = 0; i < sourceArray.length / 2; i++) {
            int temp = sourceArray[i];
            sourceArray[i] = sourceArray[sourceArray.length - 1 - i];
            sourceArray[sourceArray.length - 1 - i] = temp;
        }
        return sourceArray;
    }

    /**
     * @description: 矩阵相乘
     * @param:
     * @return:
     * @auther: sunriseme
     * @date: 2018/8/29 22:48
     */
    public static int[][] matrixMultiple(int[] clom, int[] row) {
        int[][] maxtrix = new int[clom.length][row.length];
        for (int i = 0; i < clom.length; i++) {
            for (int j = 0; j < row.length; j++) {
                maxtrix[i][j] += clom[i] * row[j];
            }
        }
        return maxtrix;
    }

    /**
     * @description: 计算整数的绝对值
     * @param: null
     * @return:
     * @auther: sunriseme
     * @date: 2018/8/29 23:02
     */
    public static int caculateIntAbsolute(int num) {
        /*
        if (num>0){
            return num;
        }else {
            return -num;
        }
         */
        return num > 0 ? num : -num;

    }

    /**
     * @description:计算浮点数的绝对值
     * @param: num
     * @return: double
     * @auther: sunriseme
     * @date: 2018/8/29 23:05
     */
    public static double caculateDoubleAbsolute(double num) {

        return num > 0.0 ? num : -num;
    }

    /**
     * @description:判断一个数是否为素数（质素） 素数(质数)：只可以被1和自己整除的数
     * 只要在2 到n中有一个被整除 就不是质素
     * @param: num
     * @return: boolean
     * @auther: sunriseme
     * @date: 2018/8/29 23:07
     */
    public static boolean isPrimeNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * @description: 判断一个数是否为素数（质素）2
     * 只要在2到 n开方 内找到一个就不是素数
     * <p>
     * wiki：所谓素数是指除了1和它本身以外，不能被任何整数整除的数，例如17就是素数，
     * 因为它不能被2~16的任一整数整除。因此判断一个整数m是否是素数，
     * 只需把m被2~m-1之间的每一个整数去除，如果都不能被整除，那么m就是一个素数
     * 另外判断方法还可以简化。m不必呗2~m-1之间的每一个整数去除，
     * 只需被2~√m之间的每一个整数去除就可以了。如果m不能被2~√m间任一整数整除，m必定是素数。
     * 例如判别17是是否为素数，只需使17被2~4之间的每一个整数去除，
     * 由于都不能整除，可以判定17是素数。（原因：因为如果m能被2~m-1之间任一整数整除，
     * 其二个因子必定有一个小于或等于√m，另一个大于或等于√m。例如16能被2,4,8整除，
     * 16=2*8,2小于4,8大于4，16=4*4,4=√16，因此只需判定在2~4之间有无因子即可）
     * @param: null
     * @return:
     * @auther: sunriseme
     * @date: 2018/8/29 23:21
     */
    public static boolean isPrimeNumber2(int num) {
        for (int i = 2; i < (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * @description:计算平方根
     * @param: num
     * wiki：牛顿迭代法，
     * @return: double
     * @auther: sunriseme
     * @date: 2018/8/29 23:29
     */
    public static double calculateSqrt(double num) {
        double e = 1e-15;
        double x = num;
        double y = (x + num / x) / 2;
        while (Math.abs(x - y) > e) {
            x = y;
            y = (x + num / x) / 2;
        }
        return x;
    }

    /**
     * @description: 计算三角形斜边
     * @param: a
     * b
     * @return: double
     * @auther: sunriseme
     * @date: 2018/8/29 23:53
     */
    public static double calculateTrangle(int a, int b) {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * @description: 计算调和级数
     * @param: num
     * @return: double
     * @auther: sunriseme
     * @date: 2018/8/29 23:56
     */
    public static double calculateHarmonicSeries(int num) {
        double sum = 0.0;
        for (int i = 1; i < num; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static void main(String[] args) {
        /*
        System.out.println(euclid(14, 324523));
        System.out.println(stupid_euclid(324523, 1444445455));

        int max = findMax(new int[]{1, 2, 5, 8});
        System.out.println(max);

        System.out.println(averageNumbers(new int[]{1, 2, 5, 0}));

        int[] ints = reverseArray(new int[]{3, 2, 1});
        for (int i : ints) {
            System.out.println(i);
        }

        int[][] ints = matrixMultiple(new int[]{1, 3}, new int[]{3, 1});
        for (int[] i:ints) {
            for (int j:i){
                System.out.println(j);
            }
        }

        System.out.println(caculateAbsolute(-7));

        System.out.println(caculateDoubleAbsolute(-0.000000001));


        System.out.println(isPrimeNumber2(17));

        System.out.println(calculateSqrt(8));
        System.out.println(calculateTrangle(3,4));


        System.out.println(calculateHarmonicSeries(8));
         */
        System.out.println(StdRandom.getSeed());
    }
}
