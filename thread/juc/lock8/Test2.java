package juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * 3、 增加了一个普通方法后！先执行发短信还是Hello？ 普通方法
 * 4、 两个对象，两个同步方法， 发短信还是 打电话？ // 打电话
 * --------------------------------------
 * @ClassName: Test2.java
 * @Date: 2021/5/1 19:17
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class Test2 {
    public static void main(String[] args) {
        // 两个对象，两个调用者，两把锁
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();

        new Thread(() -> {
            phone2.call();
        }, "B").start();

        new Thread(() -> {
            phone2.hello();
        }, "C").start();
    }
}

@SuppressWarnings("all")
class Phone2 {
    /**
     * synchronized 锁的对象是方法的调用者！
     */
    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "打电话");
    }

    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "发短信");
    }

    // 这里没有锁！不是同步方法，不受锁的影响
    public void hello() {
        System.out.println(Thread.currentThread().getName() + " say hello");
    }
}
