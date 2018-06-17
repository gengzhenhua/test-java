package com.gzhh.test.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 * <pre>
 *     1. 对象的引用 :: 实例方法名
 *
 *     2. 类名 :: 静态方法名
 *
 *     3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 *
 * </pre>
 */
public class MethodRefTest {

    /**
     * 1. 对象的引用 :: 实例方法名
     */
    @Test
    public void testObject(){

        Consumer<String> consumer_old = x -> System.out.println(x);
        consumer_old.accept("this is test old");
        PrintStream printStream = System.out;
        Consumer<String> consumer_new = printStream::println;
        consumer_new.accept("this is test new");
    }

    /**
     * 1. 对象的引用 :: 实例方法名
     */
    @Test
    public void testObject1(){

        Employee employee = new Employee(10, "gzhh", 100);
        Supplier<Integer> supplier_old = () -> employee.getAge();
        int age = supplier_old.get();
        System.out.printf("result:" + age);
        Supplier<Integer> supplier_new = employee::getAge;
        int age_new = supplier_new.get();
        System.out.printf("result:" + age_new);
    }

    /**
     * 2. 类名 :: 静态方法名
     */
    @Test
    public void testClass(){

        Comparator<Integer> comparator_old = (x, y) -> Integer.compare(x, y);
        int result = comparator_old.compare(1, 2);
        System.out.println(result);
        Comparator<Integer> comparator_new = Integer::compare;
        int result1 = comparator_new.compare(2, 1);
        System.out.println(result1);

        DoubleFunction<Long> doubleFunction_old = x -> Math.round( x);
        long round = doubleFunction_old.apply(5.2);
        System.out.println(round);
        DoubleFunction<Long> doubleFunction_new = Math::round;
        long round1 = doubleFunction_new.apply(4.2);
        System.out.println(round1);

    }

    /**
     * 3. 类名 :: 实例方法名
     */
    @Test
    public void testObjectClass(){

        BiPredicate<String, String> biPredicate_old = (x, y) -> x.equals(y);
        BiPredicate<String, String> biPredicate_new = String::equals;
        boolean result = biPredicate_old.test("test", "test1");
        System.out.println(result);
        boolean result1 = biPredicate_new.test("test", "test");
        System.out.println(result1);

        ToIntFunction<StringBuilder> toIntFunction_old = x -> x.length();
        ToIntFunction<StringBuilder> toIntFunction_new = StringBuilder::length;
        StringBuilder sb = new StringBuilder();
        sb.append("hahah");
        int length = toIntFunction_old.applyAsInt(sb);
        int length1 = toIntFunction_new.applyAsInt(sb);
        System.out.println(length);
        System.out.println(length1);
    }

}
