package com.jackiewang.reflection;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class reflectionLearning {


    public static void main(String[] args) throws ClassNotFoundException {
//        abc a = new abc();
//        System.out.println(a.getClass().getName());

        String name;
        if(args.length > 0)
            name = args[0];
        else{
            var in = new Scanner(System.in);
            System.out.println("Enter class path:");
            name = in.next();
        }
        Class cl = Class.forName(name);
        Class suppercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        System.out.println(modifiers);
        if(modifiers.length() > 0)
            System.out.print(modifiers+" " + "class "+ name);
        if(suppercl != null && suppercl != Object.class)
            System.out.println(" extends "+ suppercl.getName());
        System.out.println();
        printConstructors(cl);
        printMethods(cl);
        printFileds(cl);
        //bcd b = new bcd();
//        Class xxx = reflectionLearning.class;
//        InputStream steam = xxx.getResourceAsStream("global.txt");
//        InputStream steam2 = InputStream
//        System.out.println(steam);
//        bcd b = new bcd();
//        System.out.println(b instanceof abc);
//
//        if(b instanceof bcd)
//        System.out.println(b instanceof ccc);
    }

    private static void printFileds(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for(Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("     ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length()>0)
                System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name+";");
        }
    }

    private static void printMethods(Class cl) {
        Method[] methods = cl.getMethods();
        for(Method method:methods) {
            String name = method.getName();
            String Modifiers = Modifier.toString(method.getModifiers());
            //System.out.println(Modifiers);


            if(Modifiers.length() > 0)
                System.out.print(Modifiers+" "+name+"(");
            Class[] paramTypes = method.getParameterTypes();
            for(Class param:paramTypes){
                System.out.print(param.getName());
                System.out.print(",");
            }
            System.out.println(");");

        }
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for(Constructor c:constructors) {
            String name = c.getName();
            String Modifiers = Modifier.toString(c.getModifiers());
            if(Modifiers.length() > 0)
                System.out.print(Modifiers+" " + name+"(");
            Class[] paramTypes = c.getParameterTypes();
            for(Class param:paramTypes){
                System.out.print(param.getName());
                System.out.print(",");
            }
            System.out.println(");");
        }
    }
}
