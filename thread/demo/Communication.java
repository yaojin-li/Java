/**
 * @Description: 线程通信测试
 * 使用两个线程打印 1-100。
 * 线程1,2交替打印。
 * --------------------------------------
 * @ClassName: Communication.java
 * @Date: 2021/5/4 18:53
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Communication {

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(demo, "线程一 >>>>>>>>").start();
        new Thread(demo, "线程二").start();
    }
}

class Demo implements Runnable {
    private int num = 0;
    /**
     * 创建一个资源对象用于加锁。
     * 获取此对象，即获取锁，可以继续操作。
     * */
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步代码块，也可以对当前类对象.class（Demo.class）加锁
            synchronized (obj) {
                // 结束等待，当前线程执行
                obj.notify();

                if (num >= 100) {
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "输出：" + num);
                    num++;
                }

                try {
                    // 通知当前线程等待，使别的线程可访问并修改共享资源
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

