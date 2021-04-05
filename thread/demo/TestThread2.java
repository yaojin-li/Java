import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Description: 模拟多线程同步下载图片
 * --------------------------------------
 * @ClassName: TestThread2.java
 * @Date: 2021/4/5 10:37
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestThread2 implements Runnable {

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println(String.format("下载文件[%s]", name));
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4015125149,3656732410&fm=26&gp=0.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=176549861,2908328616&fm=26&gp=0.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2654924537,3043598140&fm=26&gp=0.jpg", "3.jpg");

        // 方式1. 继承Thread类。启动线程：子类对象.start()
//        t1.start();
//        t2.start();
//        t3.start();

        // 执行结果：说明多个线程同时异步下载
        // 下载文件[3.jpg]
        // 下载文件[2.jpg]
        // 下载文件[1.jpg]

        // 方式2. 实现Runnable接口。启动线程：传入目标对象+Thread对象.start()
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

/**
 * 下载器
 */
class WebDownloader {

    /**
     * 下载方法
     */
    public void download(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常");
        }
    }


}
