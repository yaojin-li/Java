package producerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 线程之间的通信问题：生产者和消费者问题！ 等待唤醒，通知唤醒
 * 线程交替执行 A B 操作同一个变量 num = 0
 * A num+1
 * B num-1
 * --------------------------------------
 * @ClassName: ThreadCommunicate.java
 * @Date: 2021/5/27 23:29
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ThreadCommunicate {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }
}

/**
 * synchronized 实现
 * 状态随机。
 */
class Data {
    private int number = 0;

    // +1
    public synchronized void increment() throws InterruptedException {
        // 当number不等于0，此方法等待
        while (number != 0) {
            this.wait();
        }

        // 当number等于0，执行后续操作
        number++;
        System.out.println(Thread.currentThread().getName() + "==>" + number);
        // 通知其他线程完成自增
        this.notifyAll();
    }

    // -1
    public synchronized void decrement() throws InterruptedException {
        // 当number为0，此方法等待
        while (number == 0) {
            this.wait();
        }

        // 当number不为0，执行后续操作
        number--;
        System.out.println(Thread.currentThread().getName() + "==>" + number);
        // 通知其他线程完成自减
        this.notifyAll();
    }

}


/**
 * condition 实现
 * 精准的通知和唤醒线程。
 * 状态随机。
 */
class Data2 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // +1
    public void increment() throws InterruptedException {
        lock.lock();

        try {
            // 业务代码
            // 当number不等于0，此方法等待
            while (number != 0) {
                condition.await();
            }
            // 当number等于0，执行后续操作
            number++;
            System.out.println(Thread.currentThread().getName() + "==>" + number);
            // 通知其他线程完成自增
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // -1
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            // 业务代码
            // 当number为0，此方法等待
            while (number == 0) {
                condition.await();
            }
            // 当number不为0，执行后续操作
            number--;
            System.out.println(Thread.currentThread().getName() + "==>" + number);
            // 通知其他线程完成自减
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

