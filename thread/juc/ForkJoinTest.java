package juc;

import java.util.concurrent.RecursiveTask;

/**
 * @Description: 求和计算的任务！
 * 3000 6000（ForkJoin） 9000（Stream并行流）
 * 如何使用 forkjoin
 * 1、forkjoinPool 通过它来执行
 * 2、计算任务 forkjoinPool.execute(ForkJoinTask task)
 * 3. 计算类要继承 ForkJoinTask
 * --------------------------------------
 * @ClassName: ForkJoinTest.java
 * @Date: 2021/7/3 10:03
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ForkJoinTest extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    // 临界值
    private Long temp = 10000L;

    public ForkJoinTest(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        ForkJoinTest test = new ForkJoinTest(1L, 100000L);
        System.out.println(test.compute());
    }


    @Override
    protected Long compute() {
        //
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // ForkJoin 递归
            // 取中间值
            long middle = (start + end) / 2;
            ForkJoinTest task1 = new ForkJoinTest(start, middle);
            // 拆分任务，把任务压入线程队列
            task1.fork();
            ForkJoinTest task2 = new ForkJoinTest(middle + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}

























