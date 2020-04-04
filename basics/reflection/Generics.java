package reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Description: 通过反射越过泛型检查
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 * --------------------------------------
 * @ClassName: Generics.java
 * @Date: 2020/2/22 17:02
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Generics {

    public static void main(String[] args) throws Exception {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        // strList.add(100);

        // 获取ArrayList的Class对象，反向的调用add()方法，添加数据
        // 得到 strList 对象的字节码对象
        Class listClass = strList.getClass();
        // 获取add()方法
        Method method = listClass.getMethod("add", Object.class);
        // 调用add()方法
        method.invoke(strList, 100);

        //遍历集合
        for (Object obj : strList) {
            System.out.println(obj);
        }
    }

}
