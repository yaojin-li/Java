import java.lang.annotation.*;

/**
 * @Description: --------------------------------------
 * @ClassName: FruitColor.java
 * @Date: 2020/2/2 21:18
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    public enum Color {BLUE, RED, GREEN}

    Color fruitColor() default Color.GREEN;
}
