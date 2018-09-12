package com.sunrise.algorithm.util;

import com.sunrise.algorithm.annotation.ComputeTimer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther: sunrise
 * @date: 2018/9/12 22:18
 * @description:
 * @Gmail: liu575563079@gmail.com
 */
public class ComputeTimeUtil {
    public void computeTime() {
        //获取当前的类名
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("current className(expected): "+className);

        try {
            //获取类
            Class c = Class.forName(className);
            //实例化类
            Object object = c.newInstance();
            //获取类的方法
            Method[] declaredMethods = c.getDeclaredMethods();
            for (Method method:declaredMethods) {
                //判断该方法是否包含了ComputeTimer注解
                if(method.isAnnotationPresent(ComputeTimer.class)){
                    //如果有，先设置可见性
                    method.setAccessible(true);
                    long startTime = System.currentTimeMillis();
                    method.invoke(object);
                    long endTime = System.currentTimeMillis();

                    System.out.println(method.getName()+"() spend: "+ String.valueOf(endTime-startTime)+"\n\r");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new ComputeTimeUtil().computeTime();
    }
}
