package juc;

import reflection.User;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 要求：一分钟内完成此题，只能用一行代码实现！
 * 现在有5个用户！筛选：
 * 1、身高必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名字母倒着排序
 * 5、只输出一个用户！
 * --------------------------------------
 * @ClassName: StreamTest.java
 * @Date: 2021/7/3 22:14
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class StreamTest {
    public static void main(String[] args) {
        User u1 = new User(21, "a", 1);
        User u2 = new User(22, "b", 2);
        User u3 = new User(23, "c", 3);
        User u4 = new User(24, "d", 4);
        User u5 = new User(25, "e", 5);
        User u6 = new User(25, "e", 6);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5, u6);

        // 计算交给stream流
        // lambda表达式、链式编程、函数式接口、Stream流式计算
        list.stream()
                .filter(user -> {
                    return user.getHeight() % 2 == 0;
                })
                .filter(user -> {
                    return user.getAge() > 23;
                })
                .map(user -> {
                    return user.getName().toUpperCase();
                })
                .sorted((userName1, userName2) -> {
                    return userName2.compareTo(userName1);
                })
                .limit(1)
                .forEach(System.out::println);

    }
}











