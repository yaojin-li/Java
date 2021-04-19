/**
 * @Description: 生产者消费者模型
 * 信号灯法
 * --------------------------------------
 * @ClassName: TestProducerConsumer2.java
 * @Date: 2021/4/18 16:35
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestProducerConsumer2 {

    public static void main(String[] args) {
        // 测试生产者消费者问题:信号灯法,标志位解决
        Tv tv = new Tv();
        new Watcher(tv).start();
        new Player(tv).start();
    }

}

// 演员
class Player extends Thread {
    private Tv tv = null;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            tv.play("第" + i + "个节目");
        }
    }
}

// 观众
class Watcher extends Thread {
    private Tv tv = null;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            tv.watch();
        }
    }
}

// 节目
// 演员表演，观众等待
// 观众观看，演员等待
class Tv {
    // 表演的节目
    String voice;

    // 信号灯标志。true：表演，false：观看。
    boolean flag = true;

    // 表演
    public synchronized void play(String voice) {

        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员表演了：" + voice);
        this.voice = voice;
        // 通知观看
        this.notifyAll();
        // 改变状态
        this.flag = !flag;
    }

    // 观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(">>>>>>观众观看了：" + voice);
        // 通知表演
        this.notifyAll();
        // 改变状态
        this.flag = !flag;
    }
}


