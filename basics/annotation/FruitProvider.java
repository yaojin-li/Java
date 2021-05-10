import java.lang.annotation.*;

/**
 * @Description: --------------------------------------
 * @ClassName: FruitProvider.java
 * @Date: 2020/2/2 21:21
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    // 供应商编号
    public int id() default -1;

    // 供应商名称
    public String name() default "";

    // 供应商地址
    public String address() default "";
}
