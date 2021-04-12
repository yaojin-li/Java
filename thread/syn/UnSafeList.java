package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 线程不安全的集合
 * --------------------------------------
 * @ClassName: UnSafeList.java
 * @Date: 2021/4/12 22:50
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class UnSafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                /**
                 * 对列表list资源上锁
                 * */
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}
