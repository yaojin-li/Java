/**
 * @Description: 生产者消费者模型
 * 利用缓冲区；管程法
 * 生产者，消费者，产品，缓冲区
 * --------------------------------------
 * @ClassName: TestProducerConsumer.java
 * @Date: 2021/4/17 19:51
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestProducerConsumer {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

// 生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了第" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了>>>>>第" + container.pop().id + "只鸡");
        }
    }
}

// 产品
class Chicken {
    // 编号
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区
class SynContainer {
    // 容器
    Chicken[] chickens = new Chicken[10];

    // 容器计数器
    int count = 0;

    // 生产者放入产品。涉及并发，需要同步。
    public synchronized void push(Chicken chicken) {
        // 容器满了，等待消费者同步
        if (count == chickens.length) {
            // 通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果没有满，就需要加入产品
        chickens[count] = chicken;
        count++;
        // 通知消费者消费
        this.notifyAll();
    }

    // 消费者消费产品。涉及并发，需要同步。
    public synchronized Chicken pop() {
        // 判断能否继续消费
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];

        // 通知生产者生产
        this.notifyAll();
        return chicken;
    }

}
