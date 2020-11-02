/**
 * @Description: 测试线程执行顺序
 * --------------------------------------
 * @ClassName: ThreadTest.java
 * @Date: 2020/2/3 11:23
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ThreadTest {
    public static void main(String[] args) {

        System.out.println("begin...");//1

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("end");//3
            }
        }).start();

        System.out.println("end...");//2

    }
}
