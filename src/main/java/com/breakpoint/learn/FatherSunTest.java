package com.breakpoint.learn;

public class FatherSunTest {

    static abstract class Father {
        public int money = 3;

        {
            System.out.println("bbb");
        }

        public Father() {
            money = 7;
            print();
        }

        {
            System.out.println("ccc");
        }

        protected void print() {
            System.out.println("father money is " + money);
        }
    }

    static class Sun extends Father {
        public int money = 1;

        {
            System.out.println("aaa");
        }

        public Sun() {
            money = 2;
            print();
        }

        protected void print() {
            System.out.println("Sun money is " + money);
        }
    }


    public static void main(String[] args) {
        Sun sun = new Sun();
    }
}
