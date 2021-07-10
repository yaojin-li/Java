import java.util.HashMap;
import java.util.Map;

/**
 * @Description: --------------------------------------
 * @ClassName: ReadWriteLockTest.java
 * @Date: 2021/7/10 14:48
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ReadWriteLockTest {

}

/**
 * 加锁
 */


/**
 * 自定义缓存
 * */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    // 存，写
    public void put(String key, String value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成：" + o);

    }


}
