package com.thomas.products.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyang32 on 16/7/21.
 * 1.8新特性
 */
public class Main {
    public static void main(String[] args) {

        //1 lambda表达式
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a,b) -> a.compareTo(b));
        System.out.println(names);

        // 2 接口的静态方法和默认方法
        System.out.println(MethodInInterfact.round(100));
        MethodInInterfact formula = (a) -> a+1; //此处实现了calculate方法(因为接口中只有一个方法没有实现,参照3特性)
        System.out.println(formula.sqrt(100));
        System.out.println(formula.calculate(100));


        // 3 函数式接口
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        //4 静态方法引用
        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted2 = converter2.convert("123");
        System.out.println(converted2);   // 123

        //4.2 构造函数引用 ??不太明白
        // (我们只需要使用 Person::new 来获取Person类构造函数的引用，
        // Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。)
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);


    }
}

/**
 * 函数式接口注解声明
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}


class Person {
    String firstName;
    String lastName;
    Person() {}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}