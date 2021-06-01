package com.mojito.learn.design.patterns;

import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-05-20 10:51:03
 */
class FactoryPatternTest {

    @Test
    void main() {
        FactoryPattern.ShapeFactory shapeFactory = new FactoryPattern.ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        FactoryPattern.Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        FactoryPattern.Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        FactoryPattern.Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
