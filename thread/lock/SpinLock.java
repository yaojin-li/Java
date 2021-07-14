package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: --------------------------------------
 * @ClassName: SpinLock.java
 * @Date: 2021/7/14 23:08
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class SpinLock {
    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo lockDemo = new SpinLockDemo();

        new Thread(() -> {
            lockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockDemo.myUnLock();
            }
        }, "a").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            lockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockDemo.myUnLock();
            }
        }, "b").start();
    }
}

class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock() {
        // 当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "=>myLock");

        // 自旋锁的CAS
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    // 解锁
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "=>myUnLock");
        atomicReference.compareAndSet(thread, null);
    }
}

