package juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Description: --------------------------------------
 * @ClassName: ForkJoinTest2.java
 * @Date: 2021/7/3 21:52
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ForkJoinTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1(); // 5059
        test2(); // 3424
        test3(); // 114

    }

    /**
     * 普通方式
     * */
    public static void test1() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "，耗时：" + (end - start));
    }

    /**
     * ForkJoin
     * */
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long>  task = new ForkJoinTest(0L, 10_0000_0000L);
        // 提交任务
        ForkJoinTask<Long> submit = pool.submit(task);
        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "，耗时：" + (end - start));
    }


    /**
     * Stream并行流
     * */
    public static void test3() {
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "，耗时：" + (end - start));
    }

}














