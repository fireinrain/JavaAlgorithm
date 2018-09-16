package com.sunrise.algorithm.chapter1;

import com.sunrise.stdlib.StdIn;

/**
 * 第一章的一些练习
 *
 * @auther: sunrise
 * @date: 2018/9/14 00:02
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class ExerciseMe {

    public static void main(String[] args) {
        //System.out.println(2.0e-6*1000000.1);
        //System.out.println((1+2.236)/2);
        //System.out.println(true && false || true &&true);
        //System.out.println(3+"3");

        //static method test
        //printEqual();

        //printANumberIn1and2();

        //printFibonacci();

        //printSequence();

        //printNumbers();

        //printCharIsInt();

        //System.out.println(intToBinaryString(13));

        //System.out.println((int)(Math.random()* 10)-1);

        //printSecondOrderArray();

        //printArraysIndex();

        //int[][] ints = printTwoDementionArraysTransition(5, 3);
        //System.out.println("------------------");
        //transformerArrays(ints);

        //System.out.println(lg(8));


        //int a[]={1,2,3,2,3,4,4,5,6};
        //int M=7;
        //histogram(a,M);

    }


    /**
     * @description: 编写一个静态方法histogram()，接受一个整型数组a[]和一个整数M为参数并返回一个大小为M的数组，
     * 其中第i个元素为整数i在参数数组中出现的次数。如果a[]中的值均在0到M-1之间，返回数组中的所有元素之和应该和a.length相等
     * @param: null
     * @return:
     * @auther: sunriseme
     * @date: 2018/9/16 15:52
     */
    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] <= M - 1) && (a[i] >= 0)) {
                if (i<M){
                    result[i] = findNumberFrequency(i, a);
                }
                continue;
            }
        }
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        if (sum == a.length) {
            System.out.println("符合！");
            return result;
        }
        return result;
    }

    public static int findNumberFrequency(int x, int[] arrays) {
        int count = 0;
        for (int i : arrays) {
            if (i == x) {
                count += 1;
            }
        }
        return count;
    }


    /**
     * @description: 编写一个静态方法lg（），接受一个整型参数N，返回不大于log2N的最大整数（ps：不使用Math库）
     * @param: null
     * @return:
     * @auther: sunriseme
     * @date: 2018/9/16 15:37
     */
    public static int lg(double N) {
        int k = 0;
        if (N > 0 && N < 1) {
            double count = 1;
            while (count >= N) {
                count *= 1 / 2.0;
                k -= 1;
            }
            return k + 1;
        } else if (N >= 1) {
            int count = 1;
            while (count <= N) {
                count *= 2;
                k += 1;
            }
            return k - 1;
        } else
            return -1;
    }


    //将一个n*m 的二维素组转换为m*n 的
    public static void transformerArrays(int[][] arrays) {
        int n = arrays.length;
        int m = arrays[0].length;
        int[][] newArrays = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newArrays[j][i] = arrays[i][j];
            }
        }

        betterPrintArrays(newArrays);
    }

    //二维素组的转列 N*M-》M*N
    public static int[][] printTwoDementionArraysTransition(int n, int m) {
        int[][] nBymArrays = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int random = (int) (Math.random() * 100 - 1);
                nBymArrays[i][j] = random;
            }
        }

        betterPrintArrays(n, m, nBymArrays);
        return nBymArrays;
    }

    public static void betterPrintArrays(int n, int m, int[][] nBymArrays) {
        betterPrintArrays(nBymArrays);
    }

    /**
     * @description: 更好的打印数组
     * @param: null
     * @return:
     * @auther: sunriseme
     * @date: 2018/9/16 15:25
     */
    public static void betterPrintArrays(int[][] nBymArrays) {
        int n = nBymArrays.length;
        int m = nBymArrays[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                System.out.print(nBymArrays[i][j] + "|");
            }
            System.out.println("");
        }
    }


    //关于数组索引和初始化
    public static void printArraysIndex() {
        class PrintsMe {
            void print1() {
                int[] a = new int[10];
                for (int i = 0; i < 10; i++) {
                    a[i] = 9 - i;
                }

                for (int k : a
                        ) {
                    System.out.println(k);
                }
            }

            void print2() {
                int[] a = new int[10];
                for (int i = 0; i < 10; i++) {
                    a[i] = a[a[i]];
                }

                for (int k : a
                        ) {
                    System.out.println(k);
                }
            }

            void print3() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }

        }
        PrintsMe printsMe = new PrintsMe();
        printsMe.print1();
        printsMe.print2();
        printsMe.print3();

    }


    //打印一个二维数组
    public static void printSecondOrderArray() {
        boolean[][] arrays = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int random = (int) (Math.random() * 10 - 1);
                if (random <= 5) {
                    arrays[i][j] = false;

                } else {
                    arrays[i][j] = true;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arrays[i][j] == false) {
                    System.out.print("- ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    //int 转换为二进制字符串
    public static String intToBinaryString(int num) {
        String binaryString = "";
        for (int i = num; i > 0; i /= 2) {
            binaryString = num % 2 + binaryString;
        }
        return binaryString;

    }


    //字符 的toString 方法 其实是去assic 值
    private static void printCharIsInt() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println('b' + 12);
    }


    //打印二重循环
    public static void printNumbers() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }

        System.out.println("sum is: " + sum);
    }

    //打印数列Sum of equal difference series
    public static void printSequence() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }

        System.out.println("sum is: " + sum);
    }

    //打印 斐波那契数列前15个......数字
    public static void printFibonacci() {
        int f = 0;
        int g = 1;
        for (int i = 0; i < 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }


    //打印两个严格在1到2 区间的数字
    public static void printANumberIn1and2() {
        double[] doubles = new double[2];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = StdIn.readDouble();
        }
        if ((doubles[0] - 1) > 0 && (doubles[1] - 2) < 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


    //从控制台读取三个数字 如果都相等打印 equal，否则打印not equal
    public static void printEqual() {
        int[] ints = new int[3];
        for (int i = 0; i < 3; i++) {
            int i1 = StdIn.readInt();
            ints[i] = i1;
        }

        if (ints[0] == ints[1] && ints[1] == ints[2]) {
            System.out.println("equal!");
            return;
        }
        System.out.println("not equal!");

    }


}
