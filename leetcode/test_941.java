/**
 * @Description: 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * 示例 1：
 * 输入：[2,1]
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：[3,5,5]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 * --------------------------------------
 * @ClassName: test_941.java
 * @Date: 2019/8/2 14:35
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_941 {
    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1};
        Solution_941 solution = new Solution_941();
        System.out.println(solution.validMountainArray(A));
    }
}

class Solution_941 {
    /**
     * @Description: 双指针，滑动窗口
     * @Date: 2019/8/2 14:38
     * @Params:
     * @ReturnType:
     **/

    public boolean validMountainArray(int[] A) {
        int length = A.length;
        int start = 0;

        // walk up
        while (start + 1 < length && A[start] < A[start + 1]) {
            start++;
        }

        // peak can't be first or last
        if (start == 0 || start == length - 1) {
            return false;
        }

        // walk down
        while (start + 1 < length && A[start] > A[start + 1]) {
            start++;
        }

        return start == length - 1;

    }

}




