import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description: --------------------------------------
 * @ClassName: UnSafeCollections.java
 * @Date: 2021/5/1 19:59
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
// java.util.ConcurrentModificationException 并发修改异常！
public class UnSafeCollections {
    public static void main(String[] args) {
//        unSafeList();
//        unSafeSet();
        unSafeMap();
    }

    public static void unSafeList() {
        /**
         * 并发下 new ArrayList<>(); 不安全。
         *
         * 解决方案：
         * 1. new Vector<>();
         * 2. Collections.synchronizedList(new ArrayList<>());
         * 3. new CopyOnWriteArrayList<>();
         *
         * CopyOnWrite 写入时复制。COW 计算机程序设计领域的一种优化策略；
         * 多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
         * 在写入的时候避免覆盖，造成数据问题！
         * 读写分离
         * CopyOnWriteArrayList 比 Vector Nb 在哪里？
         * */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }).start();
        }
    }

    private static void unSafeSet() {
        /**
         * 并发下 new HashSet<>(); 不安全。
         *
         * 解决方案：
         * 1. new Vector<>();
         * 2. Collections.synchronizedSet(new HashSet<>());
         * 3. new CopyOnWriteArraySet<>();
         * */
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }).start();
        }
    }

    private static void unSafeMap() {
        /**
         * 并发下 new HashMap<>(); 不安全。
         * new HashMap<>() 默认为：new HashMap<>(16, 0.75);
         *
         * 解决方案：
         * 1. new ConcurrentHashMap<>();
         * 2. Collections.synchronizedMap(new HashMap<>());
         * */
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }).start();
        }

    }

}
