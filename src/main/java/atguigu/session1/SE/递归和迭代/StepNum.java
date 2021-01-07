package atguigu.session1.SE.递归和迭代;

/**
 * 斐波那契函数
 */
public class StepNum {
    public static void main(String[] args) {
        System.out.println("递归：" + function1(7));
        System.out.println("迭代：" + function2(7));
    }

    private static int function1(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n异常");
        } else {
            if (n == 0 || n == 1 || n == 2) {
                return n;
            } else {
                return function1(n - 1) + function1(n - 2);
            }
        }
    }

    private static int function2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n异常");
        } else {
            if (n == 0 || n == 1 || n == 2) {
                return n;
            } else {
                int one = 1;
                int two = 2;
                int sum = 0;
                for (int i = 3; i <= n; i++) {
                    sum = one + two;
                    one = two;
                    two = sum;
                }
                return sum;
            }
        }
    }


    /*//递归：缺点时间很长
    private static int stepNum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + "不能小于0");
        } else if (n == 0 || n == 1 || n == 2) {
            return n;
        } else {
            return stepNum(n - 1) + stepNum(n - 2);
        }
    }

    //迭代：缺点是代码不够直观
    private static int loopNum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + "不能小于0");
        } else if (n == 0 || n == 1 || n == 2) {
            //前三个数，不用迭代，直接返回
            return n;
        } else {
            //第一个数
            int one = 1;
            //第二个数
            int two = 2;
            //求和
            int sum = 0;
            //循环从第三个数开始
            for (int i = 3; i <= n; i++) {
                //求和
                sum = one + two;
                //第一个数得到第二个数的和
                one = two;
                //第二个数得到求和的数
                two = sum;
            }
            return sum;
        }
    }*/
}



