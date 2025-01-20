package com.jackiewang.reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;


public class AnnotationLearning {


    public static void main(String[] args) {
        try {
            Class<?> myClass = Class.forName("com.jackiewang.reflection.MyClass");
            if (myClass.isAnnotationPresent(MyConfiguration.class)) {
                System.out.println("Class has MyConfiguration.");
                MyConfiguration annotation = myClass.getAnnotation(MyConfiguration.class);
                System.out.println("Annotation value: " + annotation.value());

                Annotation[] annotations = myClass.getAnnotations();
                Class<? extends Annotation> myConfigurationType = annotation.annotationType();
                // 检查 MyConfiguration 注解是否被 MyComponent 注解修饰
                if (myConfigurationType.isAnnotationPresent(MyComponent.class)) {
                    System.out.println("MyConfiguration is annotated with MyComponent.");

                    // 获取 MyComponent 注解
                    MyComponent myComponent = myConfigurationType.getAnnotation(MyComponent.class);
                    System.out.println("MyComponent value: " + myComponent.value());
                } else {
                    System.out.println("MyConfiguration is not annotated with MyComponent.");
                }
                // 获取类的方法
//                Method method = myClass.getMethod("myMethod");
//                // 判断方法是否有注解
//                if (method.isAnnotationPresent(MyComponent.class)) {
//                    System.out.println("Method has MyAnnotation.");
//                } else {
//                    System.out.println("Method does not have MyAnnotation.");
//                }
            } else {
                System.out.println("Class does not have MyConfiguration.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
