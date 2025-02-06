package com.jackiewang.IO;

import com.jackiewang.designPattern.decorator.decoratorTest;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class example {

    public static void readline() throws IOException {
        URL resource = example.class.getClassLoader().getResource("a.text");
        System.out.println(resource.toString());
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5}));

        Stream<Integer> stream = list1.stream();
        stream.map(item->item+1).forEach(System.out::println);

        //        try {
//            List<String> lines = Files.readAllLines(Paths.get(resource.toURI()));
//            for (String line : lines) {
//                System.out.println(line); // 处理每一行
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void copyFile() {

        File file1 = new File("C:\\Users\\jackwang\\Downloads\\test\\a.txt");
        File file2 = new File("C:\\Users\\jackwang\\Downloads\\test\\b.txt");
//        file2.createNewFile();
        try (FileReader f1 = new FileReader(file1);
                FileWriter f2 = new FileWriter(file2);)
        {
//            file2.createNewFile();
            int ch;
            while((ch = f1.read()) != -1){
                f2.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void copyFileByBuffered() throws Exception {
        String filePath = "C:\\Users\\jackwang\\Downloads\\test\\Book1.xlsx"; // 替换为你的大文件路径

        // 使用 FileInputStream 读取文件
        long startTime = System.currentTimeMillis();
        readWithFileInputStream(filePath);
        long endTime = System.currentTimeMillis();
        System.out.println("FileInputStream 耗时: " + (endTime - startTime) + " 毫秒");

        // 使用 BufferedInputStream 读取文件
        startTime = System.currentTimeMillis();
        readWithBufferedInputStream(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("BufferedInputStream 耗时: " + (endTime - startTime) + " 毫秒");
    }

    // 使用 FileInputStream 读取文件
    public static void readWithFileInputStream(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int data;
            while ((data = fis.read()) != -1) {
                // 模拟处理数据（这里不实际处理，只是读取）
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用 BufferedInputStream 读取文件
    public static void readWithBufferedInputStream(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int data;
            while ((data = bis.read()) != -1) {
                // 模拟处理数据（这里不实际处理，只是读取）
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByByte() {

        File file1 = new File("C:\\Users\\jackwang\\Downloads\\test\\a.txt");
        File file2 = new File("C:\\Users\\jackwang\\Downloads\\test\\b.txt");
//        file2.createNewFile();
        try (FileInputStream f1 = new FileInputStream(file1);
             FileOutputStream f2 = new FileOutputStream(file2);)
        {
//            file2.createNewFile();
            int ch;
            while((ch = f1.read()) != -1){
                f2.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
//          copyFile();
//          copyFileByByte();
        copyFileByBuffered();
//        URL resource = example.class.getClassLoader().getResource("a.text");
//        System.out.println(resource.toString());
//        InputStreamReader inputStreamReader = new InputStreamReader(resource.openStream(), "UTF-8");
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        FileReader fileReader = new FileReader(resource.getFile());
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        try( FileReader fileReader = new FileReader(resource.getFile());
//             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
//            String line;
//            while ((line=bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }

//        URL resource = example.class.getClassLoader().getResource("a.txt");
//        String filePath = resource.toString(); // 文件路径
//
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(resource.toURI()));
//            for (String line : lines) {
//                System.out.println(line); // 处理每一行
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

//        Stream<String> lines = Files.lines(Paths.get(resource.toString()));

//        try (Stream<String> lines = Files.lines(Paths.get(resource.toURI()))) {
////            lines.filter(line -> line.contains("error")) // 中间操作
//                    lines.map(String::toUpperCase)              // 中间操作
//                    .forEach(System.out::println);         // 终端操作
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

//        int a[] = {1,2,3,4,5};
//        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5}));
//
//        Stream<Integer> stream = list1.stream();
//        stream.map(item->item+1).forEach(System.out::println);

//        stream.forEach(System.out::println);

        //        FileInputStream fileInputStream = new FileInputStream(resource.getFile());

//        System.out.println(fileInputStream.read());
//        System.out.println(fileReader.read());

//        fileInputStream.close();
//        fileReader.close();
    }
}
