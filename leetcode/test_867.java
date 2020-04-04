/**
 * @Description: 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 * 提示：
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 * --------------------------------------
 * @ClassName: test_867.java
 * @Date: 2019/8/7 9:57
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_867 {
    public static void main(String[] args) {
        Solution_867 solution = new Solution_867();
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] result = solution.transpose(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class Solution_867 {
    /**
     * @Description: i, j 索引倒置存储
     * @Date: 2019/8/7 10:17
     * @Params:
     * @ReturnType:
     **/
    public int[][] transpose(int[][] A) {
        // A 的行数
        int rowLen = A.length;
        // A 的列数
        int colLen = A[0].length;
        // 由 A 的行列数反向构造转置矩阵的行列数
        int[][] result = new int[colLen][rowLen];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
