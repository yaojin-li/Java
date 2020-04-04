package annotaion;

import java.lang.reflect.Field;

/**
 * @Description: 注解处理器（通过反射获得注解）
 * --------------------------------------
 * @ClassName: FruitInfoUtil.java
 * @Date: 2020/2/2 21:24
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> oneClass) {

        String fruitNameStr = "名称：";
        String fruitColorStr = "颜色：";
        String fruitProviderStr = "供应商：";

        // 通过反射获得注解。此处为获得oneClass类的实例的所有字段
        Field[] fields = oneClass.getDeclaredFields();

        for (Field field : fields) {
            // 判断此元素上是否存在指定类型的注释，存在返回true，否则返回false。
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                fruitNameStr += fruitName.value();
                System.out.println(fruitNameStr);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                fruitColorStr += fruitColor.fruitColor();
                System.out.println(fruitColorStr);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                fruitProviderStr += " 编号：" + fruitProvider.id() +
                        " 名称：" + fruitProvider.name() + " 地址：" + fruitProvider.address();
                System.out.println(fruitProviderStr);
            }
        }
    }
}




















