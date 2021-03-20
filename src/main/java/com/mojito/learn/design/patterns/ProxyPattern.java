package com.mojito.learn.design.patterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description 代理模式
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-05-20 10:41
 */
public class ProxyPattern {

    public static void main(String[] args) {
        //静态代理：代理对象持有被代理对象的引用，增强被代理对象的功能
        System.out.println("---------------- 静态代理 ----------------");
        UserProxy userProxy = new UserProxy();
        userProxy.sing();
        userProxy.dance();

        //JDK 动态代理：在内存中生成了新的字节码、通过反射达到代理的目的
        System.out.println("---------------- 动态代理 ----------------");
        User user = new User();
        JdkProxy jdkProxy = new JdkProxy(user);
        UserInterface proxy = jdkProxy.createProxy();
        System.out.println(proxy.getClass().getName());
        proxy.sing();
        proxy.dance();
    }

    static class User implements UserInterface {

        @Override
        public void sing() {
            System.out.println("我在唱歌");
        }

        @Override
        public void dance() {
            System.out.println("我在跳舞");
        }
    }

    static class JdkProxy implements InvocationHandler {

        // 要被代理的目标对象
        private UserInterface target;

        public JdkProxy(UserInterface target) {
            this.target = target;
        }

        public UserInterface createProxy() {
            return (UserInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object invoke = null;
            String methodName = method.getName();
            if ("sing".equals(methodName)) {
                System.out.println("开始唱歌");
                invoke = method.invoke(target, args);
                System.out.println("完成唱歌");
            } else if ("dance".equals(methodName)) {
                System.out.println("开始跳舞");
                invoke = method.invoke(target, args);
                System.out.println("完成跳舞");
            }
            return invoke;
        }
    }

    private static class UserProxy implements UserInterface {

        private UserInterface userInterface;

        @Override
        public void sing() {
            System.out.println("开始唱歌");
            if (userInterface == null) {
                userInterface = new User();
            }
            userInterface.sing();
            System.out.println("完成唱歌");
        }

        @Override
        public void dance() {
            System.out.println("开始跳舞");
            if (userInterface == null) {
                userInterface = new User();
            }
            userInterface.dance();
            System.out.println("完成跳舞");
        }
    }

    public interface UserInterface {

        /**
         * 唱歌
         */
        void sing();

        /**
         * 跳舞
         */
        void dance();
    }
}
