package test;

import java.util.Scanner;

public class Main{
    static class Person{
        Person() {
            System.out.println("person init");
        }

        Person(String param) {
            System.out.println("person init again");
        }
        public void test() {
            System.out.println("test person");
        }
    }

    static class Man extends Person {
        Man() {
            System.out.println("man init");
        }

        Man(String param) {
            System.out.println("man init again");
        }
        @Override
        public void test() {
            System.out.println("test man");
        }
    }

    static class Woman extends Person {
        Woman() {
            System.out.println("woman init");
        }

        @Override
        public void test() {
            System.out.println("test woman");
        }
    }


    public static void main(String[] args) {
        Person person = new Man(" ");
        person.test();
        System.out.println(1 == 1 ? 1 : 2 + " a ");
    }
}