package juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: --------------------------------------
 * @ClassName: CompletableFutureTest.java
 * @Date: 2021/7/3 9:15
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // runAsync();

        supplyAsync();
    }

    /**
     * 有返回值的 supplyAsync 异步回调
     * ajax，成功和失败的回调
     * */
    public static void supplyAsync() throws ExecutionException, InterruptedException {

        // 返回错误信息
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync=>Integer");
//            int i = 10 / 0;
            return "1024";
        });

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);
            System.out.println("u=>" + u);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            // 根据CompletableFuture<T> 泛型，返回对接的结果。integer或string等。
            return String.format("cause[%s], msg[%s]", e.getCause(), e.getMessage());
        }).get());
    }


    /**
     * 没有返回值的 runAsync 异步回调
     */
    public static void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "runAsync => Void");
                }
        );

        System.out.println("end...");

        // 获取阻塞执行结果
        completableFuture.get();
    }


}
