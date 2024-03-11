package com.jackiewang.collection;

import java.util.*;

public class CollectionLearning {



    public static void comparatorLearning(){
        Set<Student> myset= new TreeSet<>();
        myset.add(new Student("1",12));
        myset.add(new Student("1",12));
        myset.add(new Student("2",14));
        myset.add(new Student("5",122));
        System.out.println(myset);
    }

    public static void main(String[] args) {
        comparatorLearning();

    }

}

class Student implements Comparable {
    private String name;
    private Integer grade;

    public Student(String name, Integer grade){
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, grade);
//    }
}