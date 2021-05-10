import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Description: --------------------------------------
 * @ClassName: AnnoTest.java
 * @Date: 2021/5/10 22:26
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@MyAnnotation()
public class AnnoTest {
    public static void main(String[] args) throws ClassNotFoundException {

    }
}

@Target(ElementType.TYPE)
@interface MyAnnotation {
    // 注解参数：参数类型 参数名() default 默认值；
    // 其中 default 默认值可以不写；
    String[] value() default {"a", "b"};
}
