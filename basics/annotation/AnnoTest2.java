/**
 * @Description: --------------------------------------
 * @ClassName: AnnoTest2.java
 * @Date: 2021/5/11 22:56
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class AnnoTest2 {
    public static void main(String[] args) {
        Class c1 = int[].class; // 一维整型数组
        Class c2 = int[][].class; // 二维整型数组
        Class c3 = String[].class; // 一维字符串数组
        int[] i1 = new int[10]; // 初值容量为10的一维整型数组
        int[] i2 = new int[100]; // 初始容量为100的一维整型数组

        System.out.println("一维整型数组：" + c1.hashCode());
        System.out.println("初值容量为10的一维整型数组：" + i1.getClass().hashCode());
        System.out.println("初始容量为100的一维整型数组：" + i2.getClass().hashCode());

        System.out.println("一维字符串数组：" + c3.hashCode());
        System.out.println("二维整型数组：" + c2.hashCode());
    }
}