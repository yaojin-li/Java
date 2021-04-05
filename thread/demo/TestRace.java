/**
 * @Description: 模拟并发-龟兔赛跑
 * --------------------------------------
 * @ClassName: TestRace.java
 * @Date: 2021/4/5 17:36
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestRace implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 判断比赛是否结束
            if (gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->跑了" + i + "步");
        }
    }

    /**
     * 判断比赛是否结束
     */
    public boolean gameOver(int steps) {
        // winner不为空就说明已经有冠军
        if (null != winner) {
            return true;
        }

        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is" + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TestRace race = new TestRace();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }

}


