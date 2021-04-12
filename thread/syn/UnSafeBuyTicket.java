package syn;

/**
 * @Description: 不安全的买票
 * --------------------------------------
 * @ClassName: UnSafeBuyTicket.java
 * @Date: 2021/4/12 21:44
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "张三").start();
        new Thread(buyTicket, "李四").start();
        new Thread(buyTicket, "王五").start();
    }
}

class BuyTicket implements Runnable {
    // 票
    private int ticketNums = 1000;
    // 外部停止方式
    private boolean flag = true;

    @Override
    public void run() {
        // 买票
        while (flag) {
            buy();
        }
    }

    /**
     * 对于购买方法加锁
     * 锁住的是公共资源或对象
     * */
    private synchronized void buy() {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        // 模拟延时，放大问题发生几率
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}

