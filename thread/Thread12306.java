/**
 * @Description: Runnable 共享资源。并发（线程安全）
 * 模拟网络延迟与加锁防止并发问题
 * --------------------------------------
 * @ClassName: Thread12306.java
 * @Date: 2020/6/20 17:28
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Thread12306 {
    public static void main(String[] args) {
        Website website = new Website();

        for (int i = 0; i < 10; i++) {
            new Thread(website, String.valueOf(i)).start();
        }

//        new Thread(website, "张三").start();
//        new Thread(website, "李四").start();
//        new Thread(website, "王五").start();
    }

}

class Website implements Runnable {

    private static int NUM = 99;

    @Override
    public void run() {
        while (true) {
            if (NUM <= 0) {
                break;
            }

            // TODO 遇到网络延迟，存在并发问题（多人抢同一张票、超卖情况）
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 加锁防止并发问题
            synchronized (this){
                // 在锁住的代码块中再进行一次判断，防止超卖的问题
                if (NUM <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "----->" + (NUM--));
            }
        }
    }
}
