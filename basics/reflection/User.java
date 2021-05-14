package reflection;

/**
 * @Description: --------------------------------------
 * @ClassName: User.java
 * @Date: 2021/5/14 12:17
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class User {
    private int age;
    private String name;
    public int height;
    protected String address;

    User() {
    }

    User(String str) {
        System.out.println("(默认)的构造方法 s = " + str);
    }

    User(String str, int age, int height) {
        System.out.println(String.format("(默认)的构造方法。str[%s],age[%s],height[%s]", str, age, height));
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
