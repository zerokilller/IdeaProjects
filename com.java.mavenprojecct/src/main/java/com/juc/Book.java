package com.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)

public class Book {
    //链式编程 + 流式计算
    private int id;
    private String bookName;
    private double price;
    public static void main(String[] args) {
//        Book book = new Book();
//        book.setId(12).setBookName("hhh").setPrice(43.2);
//        Function<String,Integer> function = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return 1024;
//            }
//        };
//        System.out.println(function.apply("jingwenbo"));
        //lambada表达式的参数如果是单参的情况，参数的类型和小括号都可以省略。
        Function<String,Integer> function =  s -> { return s.length(); };
        System.out.println(function.apply("jingwenbo"));

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test("jing"));
        //Predicate<String> predicate = s->{return true;};

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> consumer1 = s->{ System.out.println(s);};
        consumer.accept("jing");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hahahhahah";
            }
        };
       // lambada表达式的参数如果没有的话，小括号不能省略。
        Supplier<Integer> supplier1 = ()->{return 1024;};
        System.out.println(supplier1.get());
    }
}
