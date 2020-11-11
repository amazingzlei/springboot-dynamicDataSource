package com.example.demo.thread.demo03;

class Person{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

public class Test {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setAge(20);
//        person.setName("a");
//        System.out.println(System.identityHashCode(person));
//        System.out.println(person.hashCode());
//        person.setName("b");
//        System.out.println(System.identityHashCode(person));
//        System.out.println(person.hashCode());

        String a = "a";
        String b = "a";

        // 由于jvm中存在字符串的常量池，当前直接赋值时都会去这个池子中找有没有这个值，有则返回，无则创建然后放入池中
        System.out.println(a == b);

        // 由于final是保证对象不会发生改变，但是对于引用类型而言，如果修改了属性值，它的地址并没有发生改变
        final int[] c = {1,2,3,4};
        System.out.println(c.hashCode());
        c[0] = 0;
        System.out.println(c.hashCode());
    }
}
