package juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * 7、1个静态的同步方法，1个普通的同步方法 ，一个对象，先打印 发短信？打电话？ // 打电话
 * 8、1个静态的同步方法，1个普通的同步方法 ，两个对象，先打印 发短信？打电话？ // 打电话
 * --------------------------------------
 * @ClassName: Test4.java
 * @Date: 2021/5/1 19:41
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class Test4 {
    public static void main(String[] args) {
        // 两个对象，两个调用者，两把锁
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(() -> {
            phone1.call();
        }, "B").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.sendSms();
        }, "A").start();
    }
}

@SuppressWarnings("all")
class Phone4 {
    /**
     * synchronized 锁的对象是方法的调用者！
     * 静态的同步方法 锁的是 Class 类模板
     */
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "发短信");
    }

    /**
     * 普通的同步方法 锁的调用者
     * */
    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "打电话");
    }

}