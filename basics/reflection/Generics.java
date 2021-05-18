package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 泛型相关
 * --------------------------------------
 * @ClassName: Generics.java
 * @Date: 2020/2/22 17:02
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class Generics {
    public static void main(String[] args) throws Exception {
        // unCheckGenerics();
        genericParameter();
    }

    /**
     * 反射操作泛型
     */
    public static void genericParameter() throws NoSuchMethodException {
        // 通过反射获取类中方法
        Method method = Generics.class.getMethod("test01", Map.class, List.class);

        //
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("参数泛型：" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                // 获取实际参数类型
                Type[] actualTypeArguments = ((ParameterizedType) (ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("实际参数泛型：" + actualTypeArgument);
                }
            }
        }

        //
        Method method1 = Generics.class.getMethod("test02", null);
        Type genericReturnType = method1.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("返回值泛型：" + actualTypeArgument);
            }
        }
    }

    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }


    /**
     * 通过反射越过泛型检查
     * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
     */
    public static void unCheckGenerics() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        // 此时无法向数组中加入int元素
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
