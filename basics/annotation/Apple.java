/**
 * @Description: 注解使用
 * --------------------------------------
 * @ClassName: Apple.java
 * @Date: 2020/2/2 21:49
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    private String appleColor;

    @FruitProvider(id = 1, name = "红富士", address = "上海市")
    private String appleProvider;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

}
