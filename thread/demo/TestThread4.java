/**
 * @Description: 测试并发问题-模拟抢票
 * --------------------------------------
 * @ClassName: TestThread4.java
 * @Date: 2021/4/5 16:59
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestThread4 implements Runnable {

    /**
     * 总票数。多个线程同时操作同一个对象
     * */
    private Integer count = 10;

    @Override
    public void run() {
        while (true) {
            if (count <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "抢了第" + count-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 thread4 = new TestThread4();

        new Thread(thread4, "张三").start();
        new Thread(thread4, "李四").start();
        new Thread(thread4, "王五").start();

    }

}
