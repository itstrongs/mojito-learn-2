package com.mojito.learn.design.patterns;

/**
 * description 单例模式
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-05-21 11:16
 */
public class SingletonPattern {

    public static void main(String[] args) {
        Singleton1.getInstance().test();
        Singleton2.getInstance().test();
        SingletonByVolatile.getInstance().test();
        Singleton4.getInstance().test();
        Singleton5.INSTANCE.test();
    }

    /**
     * 饿汉式
     * 优点：免线程同步的问题
     * 缺点：类加载就完成了实例化，没有达到懒加载，如果类没用上那资源就浪费了
     */
    public static class Singleton1 {

        private static Singleton1 singleton = new Singleton1();

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            return singleton;
        }

        public void test() {
            System.out.println("实现单例了！");
        }
    }

    /**
     * 懒汉式
     * 优点：懒加载，没用到的时候不会占用内存
     * 缺点：有线程同步问题，每次getInstance都会同步，效率很低
     */
    public static class Singleton2 {

        private static Singleton2 singleton;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (singleton == null) {
                singleton = new Singleton2();
            }
            return singleton;
        }

        public void test() {
            System.out.println("实现单例了！");
        }
    }

    /**
     * 双重检查式
     * 优点：线程安全、延迟加载、效率更高
     * 缺点：可以被反序列化。通过反射可以创建多个实例
     */
    public static class SingletonByVolatile {

        private static volatile SingletonByVolatile singleton;

        private SingletonByVolatile() {
        }

        public static synchronized SingletonByVolatile getInstance() {
            if (singleton == null) {
                synchronized (SingletonByVolatile.class) {
                    if (singleton == null) {
                        singleton = new SingletonByVolatile();
                    }
                }
            }
            return singleton;
        }

        public void test() {
            System.out.println("实现单例了！");
        }
    }

    /**
     * 静态内部类
     * 优点：线程安全、延迟加载、效率高
     * 缺点：可以被反序列化。通过反射可以创建多个实例
     */
    public static class Singleton4 {

        private Singleton4() {
        }

        private static class SingletonInstance {

            private static final Singleton4 singleton = new Singleton4();
        }

        public static Singleton4 getInstance() {
            return SingletonInstance.singleton;
        }

        public void test() {
            System.out.println("实现单例了！");
        }
    }

    /**
     * 枚举式
     */
    public enum Singleton5 {

        /**
         * 单例
         */
        INSTANCE;

        public void test() {
            System.out.println("实现单例了！");
        }
    }
}
