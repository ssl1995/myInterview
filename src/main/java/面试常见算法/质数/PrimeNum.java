package 面试常见算法.质数;

public class PrimeNum {

    public static void main(String[] args) {
        getPrimeNumOf0to1000();
    }


    public static void getPrimeNumOf0to1000() {
        for (int i = 0; i <= 1000; i++) {
            boolean isPrime = true;
            // 质数:除了1和自身都不能被整除的数
            // 所以避开1和自身
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("质数:" + i);
            }
        }
    }

}
