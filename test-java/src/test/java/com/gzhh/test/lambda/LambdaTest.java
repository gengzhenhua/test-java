package com.gzhh.test.lambda;


import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class LambdaTest {

    private List<Employee> emps = Lists.newArrayList();

    @Before
    public void init(){

        Employee e1 = new Employee(10,"gzhh",100);
        Employee e2 = new Employee(9,"gzhh9",100);
        Employee e3 = new Employee(11,"gzhh11",100);
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
    }

    @Test
    public void test1(){

        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        TreeSet<String> treeSet = new TreeSet<String>(comparator);
        TreeSet<String> treeSet1 = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Test
    public void test2(){

        Comparator<String> comparator = (x, y) -> Integer.compare(x.length(), y.length());
        TreeSet<String> treeSet = new TreeSet<String>(comparator);
    }

    @Test
    public void test3(){

        emps.stream().filter(employee -> employee.getAge() >= 10).forEach(System.out::println);
    }

    @Test
    public  void  test4(){

        emps.stream().map(employee -> employee.getName());
    }

}
