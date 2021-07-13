package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: --------------------------------------
 * @ClassName: cas.CasTest.java
 * @Date: 2021/7/13 22:34
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class CasTest {
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(1);
//
//        // compareAndSet 期望、更新
//        // public final boolean compareAndSet(int expect, int update)
//        // 如果期望值达到就更新，否则不更新，CAS 是 CPU 的并发原语！
//        System.out.println(atomicInteger.compareAndSet(1,2));
//        System.out.println(atomicInteger.get());
//
//        atomicInteger.getAndIncrement();
//        System.out.println(atomicInteger.compareAndSet(1,2));
//        System.out.println(atomicInteger.get());

        abaTest();
    }

    public static void abaTest(){
        AtomicInteger atomicInteger = new AtomicInteger(1);

        // aba 问题的线程
        System.out.println(atomicInteger.compareAndSet(1,2));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2,1));
        System.out.println(atomicInteger.get());

        // 正常线程
        System.out.println(atomicInteger.compareAndSet(1,3));
        System.out.println(atomicInteger.get());
    }

}
