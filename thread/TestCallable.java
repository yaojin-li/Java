import java.util.concurrent.Callable;
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
public class TestCallable {
    public static void main(String[] args) {
        new Thread().start();

        CallableThread thread = new CallableThread();
        FutureTask futureTask = new FutureTask(thread);

    }
}

class CallableThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
