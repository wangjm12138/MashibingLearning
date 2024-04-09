package com.jackiewang.collection;

import java.util.*;

public class CollectionLearning {


    public static void HashMapLearning(){
        HashMap<Integer,String> ObjectHashMap = new HashMap<>();
        ObjectHashMap.put(1,"lili");
        ObjectHashMap.put(2,"xiaoxiao");
        System.out.println(ObjectHashMap.put(1,"sxil"));
        System.out.println(ObjectHashMap);

    }

    //TreeSet可以外部比较器，也可以内部比较器，内部比较器实现comparable接口，外部比较器要实现comparator接口
    public static void TreeSetLearning(){
        //内部的比较器要实现comparable
//        Set<StudentInside> treeset= new TreeSet<>();
//        treeset.add(new StudentInside("airoha",12));
//        treeset.add(new StudentInside("bili",12));
//        treeset.add(new StudentInside("center",14));
//        treeset.add(new StudentInside("demo",122));
//        treeset.add(new StudentInside("demo",123));
//        System.out.println(treeset);

        //外部比较器的两种写法，第一种是实现compartor，第二种是匿名类
        //Set<StudentOutside> treeset2= new TreeSet<>(new outside());

        Set<StudentOutside> treeset2= new TreeSet<>(new Comparator<StudentOutside>() {
            @Override
            public int compare(StudentOutside o1, StudentOutside o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        treeset2.add(new StudentOutside("airoha",12));
        treeset2.add(new StudentOutside("bili",12));
        treeset2.add(new StudentOutside("center",14));
        treeset2.add(new StudentOutside("demo",122));
        treeset2.add(new StudentOutside("demo",123));
        System.out.println(treeset2);

    }
    //无序，底层，数组+链表
    public static void HashSetLearning(){
        Set<Student2> hashSet= new HashSet<>();
        hashSet.add(new Student2("airoha",12));
        hashSet.add(new Student2("bili",12));
        hashSet.add(new Student2("center",14));
        hashSet.add(new Student2("demo",122));
        hashSet.add(new Student2("demo",123));
        System.out.println(hashSet);
    }
    //有先后顺序，底层，数组+链表
    public static void LinkHashSetLearning(){
        Set<Student2> linkedHashSet= new LinkedHashSet<>();
        linkedHashSet.add(new Student2("airoha",12));
        linkedHashSet.add(new Student2("bili",12));
        linkedHashSet.add(new Student2("center",14));
        linkedHashSet.add(new Student2("demo",122));
        linkedHashSet.add(new Student2("demo",122));
        System.out.println(linkedHashSet);
    }

    public static void main(String[] args) {
        //TreeSetLearning();
        //HashSetLearning();
        //LinkHashSetLearning();
        //HashMapLearning();
        HashMapLearning();

    }

}


class Student2{
    private String name;
    private Integer grade;

    public Student2(String name, Integer grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    //????
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return Objects.equals(name, student2.name)&& Objects.equals(grade, student2.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }
}
class StudentInside implements Comparable<StudentInside> {
    private String name;
    private Integer grade;

    public StudentInside(String name, Integer grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(StudentInside o) {
        return this.getName().compareTo(o.getName());
    }
}
class StudentOutside{
    private String name;
    private Integer grade;

    public StudentOutside(String name, Integer grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}

class outside implements Comparator<StudentOutside> {

    public outside() {
    }

    @Override
    public int compare(StudentOutside o1, StudentOutside o2) {
        return o1.getName().compareTo(o2.getName());
    }
}