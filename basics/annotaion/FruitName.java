package annotaion;

import java.lang.annotation.*;

/**
 * @Description: --------------------------------------
 * @ClassName: FruitName.java
 * @Date: 2020/2/2 21:15
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
