/**
 * @Description: 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *  
 * 提示：
 * 0 ≤ N ≤ 30
 * --------------------------------------
 * @ClassName: test_509.java
 * @Date: 2019/8/6 19:23
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_509 {
    public static void main(String[] args) {
        int N = 2;
        Solution_509 solution = new Solution_509();
        System.out.println(solution.fib(N));
        System.out.println(solution.fibTwo(N));
    }
}

class Solution_509 {
    /**
     * @Description: 递归
     * @Date: 2019/8/6 20:30
     * @Params:
     * @ReturnType:
     **/
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * @Description: 循环（速度比递归快很多）
     * @Date: 2019/8/6 20:30
     * @Params:
     * @ReturnType:
     **/
    public int fibTwo(int N) {
        if (N <= 1) {
            return N;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < N - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

}