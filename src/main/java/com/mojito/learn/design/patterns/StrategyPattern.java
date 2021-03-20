package com.mojito.learn.design.patterns;

/**
 * 策略模式
 * <p>
 * 不同的接口实现通过不同的策略去实现。
 * 比如旅行可以坐飞机、可以坐火车、可以坐轮船。
 * 选择什么方式由旅行的人根据策略灵活变动
 *
 * @author liufengqiang
 * @date 2021-02-25 22:38:12
 */
public class StrategyPattern {

    public static void main(String[] args) {
        // 发年终奖了，坐飞机去旅行
        Person person0 = new Person(new Plane());
        person0.travel();

        // 月底没钱了，坐火车去旅行
        Person person1 = new Person(new Train());
        person1.travel();

        // 去岛上，坐轮船去旅行
        Person person2 = new Person(new Steamer());
        person2.travel();
    }

    /**
     * 旅行的人
     */
    static class Person {

        private Vehicle vehicle;

        public Person(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        /**
         * 旅行
         */
        public void travel() {
            vehicle.trip();
        }
    }

    /**
     * 交通工具
     */
    interface Vehicle {

        /**
         * 出行
         */
        void trip();
    }

    /**
     * 飞机
     */
    static class Plane implements Vehicle {

        @Override
        public void trip() {
            System.out.println("坐飞机出行");
        }
    }

    /**
     * 火车
     */
    static class Train implements Vehicle {

        @Override
        public void trip() {
            System.out.println("坐火车出行");
        }
    }

    /**
     * 轮船
     */
    static class Steamer implements Vehicle {

        @Override
        public void trip() {
            System.out.println("坐轮船出行");
        }
    }
}
