import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * --------------------------------------
 * @ClassName: test_118.java
 * @Date: 2019/8/13 14:16
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_118 {
    public static void main(String[] args) {
        int numRows = 5;
        Solution_118 solution = new Solution_118();
        List<List<Integer>> result = solution.generate(numRows);
        for (int i = 0; i < result.size(); i++) {
            for (int j = i; j < result.get(i).size(); j++) {
                System.out.println(result.get(j));
            }
        }
    }
}

class Solution_118 {
    /**
     * @Description: 定义第一个列表，其后列表中间内容，为前一个列表的index项与index-1项之和
     * @Date: 2019/8/13 14:18
     * @Params:
     * @ReturnType:
     **/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // 长度为0直接返回
        if (numRows==0){
            return result;
        }
        // 往第一个 list 中添加1
        result.add(new ArrayList<>());
        result.get(0).add(1);

        // 从低往高依次构建每个列表
        for (int i = 1; i < numRows; i++) {
            // 定义当前列表
            List<Integer> row = new ArrayList<>();
            // 获取前一项列表
            List<Integer> preRwo = result.get(i-1);
            // 第一项为1。添加值时不用索引指定，易引起索引异常。
            row.add(1);
            // 从第二项开始，每项值为前一个列表对应index与index-1的值之和
            for (int j = 1; j < preRwo.size(); j++) {
                row.add(preRwo.get(j)+preRwo.get(j-1));
            }
            // 最后一项为1
            row.add(1);
            // 每一个列表添加到结果集
            result.add(row);
        }
        return result;
    }
}










