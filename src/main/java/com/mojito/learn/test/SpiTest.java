package com.mojito.learn.test;

/**
 * @author liufengqiang
 * @date 2020-11-05 16:13:36
 */
public class SpiTest {

    public interface SpiService {
        void exe();
    }

    public class SpiServiceImplA implements SpiService {
        @Override
        public void exe() {
            System.out.println("I am A...");
        }
    }

    public class SpiServiceImplB implements SpiService {
        @Override
        public void exe() {
            System.out.println("I am B...");
        }
    }
}
