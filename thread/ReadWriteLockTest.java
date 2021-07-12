import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 独占锁（写锁） 一次只能被一个线程占有
 * 共享锁（读锁） 多个线程可以同时占有
 * ReadWriteLock
 * 读-读 可以共存！
 * 读-写 不能共存！
 * 写-写 不能共存！
 * --------------------------------------
 * @ClassName: ReadWriteLockTest.java
 * @Date: 2021/7/10 14:48
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ReadWriteLockTest {
    public static void main(String[] args) {
        // 普通map
        MyCache myCache = new MyCache();

        // 读写锁
        MyCacheLock myCacheLock = new MyCacheLock();

        // 写入
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCacheLock.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        // 读取
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCacheLock.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * 加锁
 */
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 存，写入的时候，只有一个线程写
    public void put(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    // 取，读，所有线程可以操作
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成：" + o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

/**
 * 自定义缓存
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    // 存，写
    public void put(String key, String value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    // 取，读
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成：" + o);

    }
}
