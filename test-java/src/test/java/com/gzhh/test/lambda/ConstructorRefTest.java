package com.gzhh.test.lambda;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用:构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * 类名 :: new
 *
 * 数组引用
 * 类型[] :: new;
 */
public class ConstructorRefTest {

    /**
     * 无参构造
     */
    @Test
    public void testNoArgs(){

        Supplier<Employee> supplier_old = () -> new Employee();
        Supplier<Employee> supplier_new = Employee::new;

        Supplier<StringBuilder> supplier1 = () -> new StringBuilder();
        Supplier<StringBuilder> supplier2 = StringBuilder::new;

        Supplier<StringBuilder> supplier3 = () -> new StringBuilder();
        Supplier<StringBuilder> supplier4 = StringBuilder::new;
    }

    @Test
    public void testArgs(){

        Function<String, StringBuilder> function1 = x -> new StringBuilder(x);
        Function<String, StringBuilder> function2 = StringBuilder::new;
        function1.apply("test");
        function2.apply("test1");
    }

    @Test
    public void testArray(){

        Function<Integer, String[]> function1 = x -> new String[x];
        Function<Integer, String[]> function2 = String[]::new ;
        System.out.println(function1.apply(15).length);
        System.out.println(function2.apply(10).length);
    }

}
