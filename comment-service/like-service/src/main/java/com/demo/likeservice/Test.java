package com.demo.likeservice;

public class Node {
    int value;
    Node next;
}

public class Test implements Runnable {
    int N = 1;
    public void printEven() {
        N == odd
                wait()
                else
                    print
                            notify();
    }

    public void printOdd() {
        N == even
        wait()
                else
        print
        notify();
    }
    public static void main(String[] args) {
        Test test1 = new Runnable() {
            @Override
            public void run() {
                printEven();
            }
        };
        Test test2 = new  Runnable() {
            @Override
            public void run() {
                printOdd();
            }
        };;

        test1.start();
        test2.start();
    }

    @Override
    public void run() {

    }
}

