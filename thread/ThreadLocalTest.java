/**
 * @Description: --------------------------------------
 * @ClassName: ThreadLocalTest.java
 * @Date: 2021/8/26 18:31
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/

public class ThreadLocalTest {
    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar1");
                localVar.set("测试覆盖");
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("thread1 after remove : " + localVar.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar2");
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("thread2 after remove : " + localVar.get());
            }
        });

        t1.start();
        t2.start();
    }
}
