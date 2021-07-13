package lock;

import jdk.internal.org.objectweb.asm.TypeReference;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 可重入锁
 * 1. synchronized
 * 2. Lock
 * --------------------------------------
 * @ClassName: Demo1.java
 * @Date: 2021/7/13 23:45
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Demo1 {
    public static void main(String[] args) {
        synchronizedLock();
    }

    private static void synchronizedLock() {
        Phone2 phone = new Phone2();
        new Thread(() -> {
            phone.sms();
        }, "a").start();

        new Thread(() -> {
            phone.sms();
        }, "b").start();
    }
}

class Phone {
    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + "sms");
        // 锁中有锁
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "call");
    }
}

class Phone2 {
    Lock lock = new ReentrantLock();

    public void sms() {
        // 细节问题：lock.lock(); lock.unlock(); // lock 锁必须配对，否则就会死在里面
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "sms");
            // 锁中有锁
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    private void call() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
