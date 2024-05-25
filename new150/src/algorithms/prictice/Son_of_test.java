package algorithms.prictice;

import prictice2.Person;


class Son_of_test extends Person {

    static {
        System.out.println("静态代码块");
    }
    int a = 1;

    public Son_of_test() {
        // 生命
        this("11",24);
    }

    public Son_of_test(String name, int age) {
        this(11);
        System.out.println(name + " " +age);
    }
    public Son_of_test( int age) {
        System.out.println(age);
    }

    public static void say(){
        System.out.println("i am son");
    }
    public static void main(String[] args) {
        Person p = new Son_of_test();
        p.say1();
    }
}
