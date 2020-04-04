import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 托普利茨矩阵
 * <p>
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * <p>
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 * <p>
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 * <p>
 * 说明:
 * matrix 是一个包含整数的二维数组。
 * matrix 的行数和列数均在 [1, 20]范围内。
 * matrix[i][j] 包含的整数在 [0, 99]范围内。
 * <p>
 * 进阶:
 * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
 * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
 * --------------------------------------
 * @ClassName: test_766.java
 * @Date: 2019/8/15 20:48
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_766 {
    public static void main(String[] args) {
        Solution_766 solution = new Solution_766();
        int[][] matrix = {{1}, {2}, {3}};
        System.out.println(solution.isToeplitzMatrix(matrix));
    }
}

class Solution_766 {
    /**
     * @Description: 先生成对角线矩阵；在遍历对角线矩阵里的每个列表中的数值是否一致
     * @Date: 2019/8/15 20:54
     * @Params:
     * @ReturnType:
     **/
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 生成对角线矩阵
        List<List<Integer>> result = new ArrayList<>();
        // 行数
        int rowIndex = matrix.length - 1;
        // 当行数大于零
        while (rowIndex > 0) {
            // 当前行的开始索引
            int beginIndex = 0;
            // 记录当前开始索引对角线上的所有数字
            List<Integer> temp = new ArrayList<>();
            // 缓存当前的行索引
            int testIndex = rowIndex;
            // 当前行索引 <= 最大行数
            while (rowIndex <= matrix.length - 1) {
                // 若该行的开始索引大于该行的长度时，break
                if (beginIndex > matrix[rowIndex].length - 1) {
                    break;
                }
                // 记录当前值
                temp.add(matrix[rowIndex][beginIndex]);
                // 下移一行
                rowIndex++;
                // 行的开始索引++，记录对角线数字
                beginIndex++;
            }
            // 结果集添加对角线结果
            result.add(temp);
            // 当前行索引上移一行。（使用缓存是因为 while 循环中会改变 rowIndex 的值）
            rowIndex = testIndex - 1;

            // 当移动到第一行时，行索引为0
            if (rowIndex == 0) {
                // 重新定义第一行的开始索引
                int newBeginIndex = 0;
                // 当第一行的开始索引 <= 第一行的长度时
                while (newBeginIndex <= matrix[0].length - 1) {
                    // 缓存开始索引
                    int testNewBeginIndex = newBeginIndex;
                    // 记录第一行中对角线的结果
                    List<Integer> temp2 = new ArrayList<>();
                    // 当第一行的开始索引 <= 第一行的长度时
                    while (matrix[0].length - 1 >= newBeginIndex) {
                        // 当递增的行索引大于矩阵行数时，break
                        if (rowIndex > matrix.length - 1) {
                            break;
                        }
                        // 记录对角线值
                        temp2.add(matrix[rowIndex][newBeginIndex]);
                        // 行索引下移
                        rowIndex++;
                        // 第一行的开始索引++，记录对角线数字
                        newBeginIndex++;
                    }
                    // 结果集添加对角线结果
                    result.add(temp2);
                    // 第一行的开始索引后移一位
                    newBeginIndex = testNewBeginIndex + 1;
                    // 行索引置零，此时只在第0行记录对角线数字
                    rowIndex = 0;
                }
            }
        }

        // 判断对角线矩阵每个列表是否一致
        for (int i = 0; i < result.size(); i++) {
            List<Integer> temp = result.get(i);
            if (temp.size() != 1) {
                // set 去重
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < temp.size(); j++) {
                    set.add(temp.get(j));
                }
                if (set.size() != 1) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * @Description: 对角线结果对比，比较 matrix[i][j] 与 matrix[i-1][j-1] 是否相等
     * @Date:        2019/8/15 22:40
     * @Params:
     * @ReturnType:
     **/
    public boolean isToeplitzMatrixTwo(int[][] matrix){
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
