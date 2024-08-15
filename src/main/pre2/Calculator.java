package com.ormispring.tdddemo;

public class Calculator {
    public int addTwoInteger(int a, int b) {
        if (willAdditionOverflow(a, b)) {
            if (a > 0) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return a + b;
    }

    public int subTwoInteger(int a, int b) {
        return a - b;
    }

    public int mulTwoInteger(int a, int b) {
        return 1;
    }

    private boolean willAdditionOverflow(int a, int b) {
        if (b > 0 && a > Integer.MAX_VALUE - b) {
            return true;
        }
        if (b < 0 && a < Integer.MIN_VALUE - b) {
            return true;
        }
        return false;
    }

    private boolean willMultiplyOverflow(int a, int b) {
        return true;
    }

}