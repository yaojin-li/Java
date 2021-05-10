package pack;

/**
 * @Description: --------------------------------------
 * @ClassName: Test.java
 * @Date: 2021/5/10 23:04
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Test {    public static void main(String[] args) throws ClassNotFoundException {
    // 通过反射返回类的Class对象，这里的Class就是Object类中getClass()方法的返回值
    // Class是一样的，获取的c1是Class类的对象
    Class c1 = Class.forName("pack.User");
    System.out.println(c1);

    // 一个类在方法区中只有一个Class对象
    // 一个类被加载之后，类的整个结构(构造器、方法、属性等等)都会被封装在Class对象中
    Class c2 = Class.forName("pack.User");
    System.out.println(c1.hashCode());
    System.out.println(c2.hashCode());
}

}

class User {
    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

