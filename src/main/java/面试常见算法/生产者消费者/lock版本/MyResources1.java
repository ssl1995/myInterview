package 面试常见算法.生产者消费者.lock版本;

import atguigu.session1.SE.初始化过程.Father;


class MyResources1 {
    private int num = 0;

    // 方式一：synchronized+wait+notifyAll

    //生产者,规定：生产一个，消费一个
    public synchronized void productor() {
        //1 判断，生产者等待的条件：产品数量等待消费，num>0
        while (num != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2 干活
        num++;
        System.out.println(Thread.currentThread().getName() + "\tnum值：" + num);
        //3 通知唤醒
        notifyAll();
    }

    //消费者
    public synchronized void consumer() {
        //1 判断 多线程是while判断
        while (num == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2 干活：消费
        num--;
        System.out.println(Thread.currentThread().getName() + "\tnum值：" + num);
        //3 通知唤醒
        notifyAll();

    }
}