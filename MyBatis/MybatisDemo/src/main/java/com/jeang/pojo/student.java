package com.jeang.pojo;

public class student {
    private int student_id;
    private String student_name;
    private int age;

    public int getId() {
        return student_id;
    }

    public void setId(int id) {
        this.student_id = student_id;
    }

    public String getName() {
        return student_name;
    }

    public void setName(String name) {
        this.student_name = student_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + student_id +
                ", name='" + student_name + '\'' +
                ", age=" + age +
                '}';
    }
}
