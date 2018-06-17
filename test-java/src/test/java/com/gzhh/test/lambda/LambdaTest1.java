package com.gzhh.test.lambda;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 左右遇一括号省
 * 左侧推导类型省
 * Lambda表达式需要函数式接口的支持
 * 函数式接口：接口中只有一个抽象方法，称为函数式接口，可以使用@FunctionalInterface标注
 */
public class LambdaTest1 {

    private List<Employee> emps = Lists.newArrayList();

    @Before
    public void init(){

        Employee e1 = new Employee(10,"gzhh",100);
        Employee e2 = new Employee(9,"gzhh9",100);
        Employee e3 = new Employee(11,"gzhh11",100);
        Employee e4 = new Employee(9,"gzhh8",100);
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
        emps.add(e4);
    }

    /**
     * 语法格式1：无参数，无返回值
     */
    @Test
    public  void  test1(){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable!");
            }
        };
        Runnable runnable1 = () -> System.out.println("Hello lambda!");
        runnable.run();
        runnable1.run();
    }


    /**
     * 语法格式2：有一个参数，无返回值
     */
    @Test
    public void  test2(){

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("hello:" + s);
            }
        };
        Consumer<String> consumer1 = (x) -> System.out.println("hello:"  + x);
        //只有一个参数小括号可以省略
        Consumer<String> consumer2 = x -> System.out.println("hello:"  + x);
        consumer.accept("111");
        consumer1.accept("222");
        consumer2.accept("333");
    }

    /**
     * 语法格式3：有多个参数，有返回值
     */
    @Test
    public void test3(){

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<String> comparator1 = (x, y) -> {

            System.out.println(x + ":" + y);
            return  x.compareTo(y);
        };

        comparator.compare("56", "54");
        comparator1.compare("x", "X");
    }

    /**
     * 语法格式4：有多个参数，有返回值(若lambda体中只有一条语句，返回值和大括号都可以省略)
     */
    @Test
    public void test4(){

        Comparator<String> comparator = (o1, o2) -> o1.compareTo(o2);
    }

    @Test
    public void test5(){
        //类型推断
        //String[] str = {"a1", "b1"};
        //String[] str1;
        //str1 = {"c1"};
    }

    /**
     * 调用 Collections.sort() 方法， 通过定制的排序比较两个Employee(先按照年龄，再按照姓名比较，使用lambda作为参数传递)
     */
    @Test
    public void test6(){

        Collections.sort(emps, (x, y) -> {

            if(x.getAge() == y.getAge()){
                return x.getName().compareTo(y.getName());
            }
            return Integer.compare(x.getAge(), y.getAge());
        });
        emps.forEach( x -> System.out.println(x));
    }

    /**
     * 1. 声明函数式接口，接口中声明抽象方法，String transfer(String str);
     */
    @Test
    public void test7(){

        String result = trans("gzhh", x -> x.toUpperCase());
        System.out.println(result);
        String result1 = trans("gzhh", x -> x.substring(0, 2));
        System.out.println(result1);
    }

    public String trans(String str, TransferString trans){

        trans.print();
        return trans.transfer(str);
    }

}

@FunctionalInterface
interface TransferString{

    String transfer(String str);

    default void print(){
        System.out.println("Hello. Interface default");
    }
}