import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: --------------------------------------
 * @ClassName: TestCallable.java
 * @Date: 2021/6/1 16:09
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThread thread = new CallableThread();
        FutureTask futureTask = new FutureTask(thread);

        new Thread(futureTask, "A").start();

        // get() 方法可能造成阻塞，或用异步通信处理
        Integer result = (Integer) futureTask.get();
        System.out.println(result);
    }
}

class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
