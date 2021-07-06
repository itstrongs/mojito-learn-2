package com.mojito.learn.demo;

import lombok.Data;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 泛型测试
 *
 * @author liufengqiang
 * @date 2020-12-25 17:26:49
 */
public class TemplateTest {

    public static void main(String[] args) {
        test1();
        test2(args);
    }

    private static void test2(String[] args) {
        try {
            Apple instance = createInstance(Apple.class);
            Fruit instance2 = createInstance(Fruit.class);
            System.out.println("Apple==>" + instance);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        SpringApplication.run(TemplateTest.class, args);
    }

    /**
     * 上界通配符和下界通配符
     */
    private static void test1() {
        // 无法将苹果盘子用水果盘接收
        // Plate<Fruit> applePlate = new Plate<Apple>(new Apple());

        // 上界通配符：<? extends T>
        Plate<? extends Fruit> applePlate1 = new Plate<Apple>(new Apple());

        // 无法set数据，只能get数据，而且是父类型
        // applePlate1.setItem(new Fruit());
        Fruit item = applePlate1.getItem();

        // 下界通配符：<? super T>
        Plate<? super Fruit> applePlate2 = new Plate<Food>(new Apple());

        // 正常set，get只能获取Object
        applePlate2.setItem(new Apple());
        Object item1 = applePlate2.getItem();
    }

    private static <T> T createInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    static class SpringApplication {

        public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
            return null;
        }
    }

    @Data
    static class Plate<T> {

        private T item;

        public Plate(T t) {
            item = t;
        }
    }

    static class Food {}

    static class Fruit extends Food {}

    static class Apple extends Fruit {}
}
