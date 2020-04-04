import java.util.Arrays;

/**
 * @Description: 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * --------------------------------------
 * @ClassName: test_905.java
 * @Date: 2019/7/31 14:43
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_905 {
    public static void main(String[] args) {
        int[] A = new int[]{3, 1, 2, 4, 6, 8, 9, 4, 1};
        Solution_905 solution = new Solution_905();
        solution.sortArrayByParity(A);
    }
}

class Solution_905 {
    /**
     * @Description: 位运算或余2判断奇偶；等长数组，奇数放后，偶数放前
     * @Date: 2019/7/31 15:00
     * @Params:
     * @ReturnType:
     **/
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                // 偶数
                result[start++] = A[i];
            } else {
                result[end--] = A[i];
            }
        }
        return result;
    }
}
