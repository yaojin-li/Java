import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Description:
 * 1. 创建线程方式三：实现Callable接口
 * 优势：
 * 1. 可以定义返回值；
 * 2. 可以抛出异常；
 * --------------------------------------
 * @ClassName: TestThread5.java
 * @Date: 2021/4/5 18:02
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestThread5 implements Callable {

    private String url;
    private String name;

    public TestThread5(String url, String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public Object call() throws Exception {
        // 1. 实现callable接口，需要返回值类型
        // 2. 重写call方法，需要抛出异常
        WebDownloaders downloaders = new WebDownloaders();
        downloaders.download(url, name);
        System.out.println(String.format("下载文件[%s]", name));
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3. 创建目标对象
        TestThread5 t1 = new TestThread5("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4015125149,3656732410&fm=26&gp=0.jpg", "1.jpg");
        TestThread5 t2 = new TestThread5("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=176549861,2908328616&fm=26&gp=0.jpg", "2.jpg");
        TestThread5 t3 = new TestThread5("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2654924537,3043598140&fm=26&gp=0.jpg", "3.jpg");

        // 4. 创建执行任务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 5. 提交执行
        Future future1 = executorService.submit(t1);
        Future future2 = executorService.submit(t2);
        Future future3 = executorService.submit(t3);

        // 6. 获取结果
        System.out.println(future1.get() + "，执行完成。");
        System.out.println(future2.get() + "，执行完成。");
        System.out.println(future3.get() + "，执行完成。");

        // 7. 关闭服务
        executorService.shutdownNow();
    }

}

/**
 * 下载器
 */
class WebDownloaders {

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
