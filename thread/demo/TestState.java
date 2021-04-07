/**
 * @Description: 测试线程状态
 * --------------------------------------
 * @ClassName: TestState.java
 * @Date: 2021/4/7 21:24
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        // 新建线程
        Thread thread = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(".....");
        });

        // 观察线程状态
        Thread.State state = thread.getState();
        // new
        System.out.println(state);

        // 启动线程
        thread.start();
        state = thread.getState();
        // runnable
        System.out.println(state);

        // 线程不终止，一直输出状态
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            // 更新线程状态
            state = thread.getState();
            System.out.println(state);
        }

    }

}
