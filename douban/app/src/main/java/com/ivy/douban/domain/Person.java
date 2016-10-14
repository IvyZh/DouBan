package com.ivy.douban.domain;

/**
 * Created by Ivy on 2016/10/12.
 *
 * @description:
 */

public class Person {
    int type;
    String name;
    int age;

    public Person(int type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "type=" + type + "----" + name;

    }
}
