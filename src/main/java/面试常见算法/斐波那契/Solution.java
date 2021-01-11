package 面试常见算法.斐波那契;

public class Solution {
    public int fib(int n) {
        if (n < 0) {
            throw new RuntimeException("n<0");
        } else {
            if (n < 2) {
                return n;
            }
            return fib(n - 1) + fib(n - 2);
        }
    }

    public int fib1(int n) {
        if (n < 0) {
            throw new RuntimeException("n<0");
        } else {
            if (n < 2) {
                return n;
            }
            int a = 0;
            int b = 1;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            return sum;
        }
    }
}
