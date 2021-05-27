package producerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: condition 实现多个线程有序等待与唤醒
 * 有序执行
 * A 执行完调用B，B执行完调用C，C执行完调用A
 * --------------------------------------
 * @ClassName: PcUsedCondition.java
 * @Date: 2021/5/27 23:55
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class PcUsedCondition {
    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "C").start();
    }
}


class Data3 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    // 自定义对应关系。 假定 1A 2B 3C
    private int number = 1;

    public void printA() {
        lock.lock();
        try {
            // 业务代码
            while (number!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"==> A");
            // 精准指定唤醒 B，condition2
            number=2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            // 业务代码
            while (number!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"==> B");
            // 精准指定唤醒 C，condition3
            number=3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            // 业务代码
            while (number!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"==> C");
            // 精准指定唤醒 1，condition1
            number=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}