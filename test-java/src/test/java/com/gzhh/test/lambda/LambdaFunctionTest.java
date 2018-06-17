package com.gzhh.test.lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 四大内置函数式接口
 *
 * <pre>
 *     1. 消费型接口 Consumer<T> void accept(T t)
 *     2. 供给型接口 Supplier<T> T get()
 *     3. 函数型接口 Function<T, R>  R apply(T t)
 *     4. 断言型接口 Predicate<T> boolean test(T t)
 * </pre>
 */
public class LambdaFunctionTest {

    @Test
    public void testConsumer(){

        consumer("this is param", e -> System.out.println(e));
    }

    private void consumer(String str, Consumer<String> consumer){

        consumer.accept(str);
    }

    @Test
    public void testSupplier(){

        double result = get(() -> Math.random());
        System.out.println(result);
    }

    private double get(Supplier<Double> supplier){

        return supplier.get();
    }

    @Test
    public void testFunction(){

        String result = apply("srcParam", (x) -> x.substring(0, 3));
        System.out.println(result);
    }

    private String apply(String param, Function<String, String> function){

        return function.apply(param);
    }

    @Test
    public void testPredicate(){

        boolean result = test("default", x -> x != null);
        System.out.println(result);
    }

    private boolean test(String param, Predicate<String> predicate){

        return predicate.test(param);
    }

}
