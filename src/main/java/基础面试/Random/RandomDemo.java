package 基础面试.Random;

import java.util.Random;

public class RandomDemo {
    // 随机生成[30,100]的随机数，方法1
    public int random30to100ByMethod1() {
        int min = 30;
        int max = 101;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


    // 随机生成[30,100]的随机数，方法2
    public int random30to100ByMethod2() {
        int min = 30;
        int max = 101;
        //  Math.random()随机(0,1)之间随机生成一个数
        return (int) (Math.random() * (max - min)) + min;
    }
}
