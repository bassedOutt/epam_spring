package com.epam.spring.homework3.test;

import java.util.List;
import java.util.Objects;

public class Test {

    private static class A {
        private int a;

        public A(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a1 = (A) o;
            return a == a1.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a);
        }
    }

    public static void main(String[] args) {
        A a = new A(3);
        A b = new A(4);
        A c = new A(5);
        A d = new A(6);

        List<A> list = List.of(a, b, c, d);

        A a1 = new A(3);




    }

}
