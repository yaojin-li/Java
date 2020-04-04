/**
 * @Description: 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * 输入: "PPALLP"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "PPALLL"
 * 输出: False
 * --------------------------------------
 * @ClassName: test_551.java
 * @Date: 2019/5/5 15:38
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_551 {
    public static void main(String args[]) {
        String s = "PPALLALP";
        Solution_551 solution = new Solution_551();
        System.out.println(solution.checkRecord(s));
    }
}

class Solution_551 {
    public boolean checkRecord(String s) {
        boolean flag = true;
        int aNum = 0;
        //有两个A，或者有LLL，返回false
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                aNum++;
            }
        }
        if (aNum > 1) {
            flag = false;
        }
        if (s.contains("LLL")) {
            flag = false;
        }
        return flag;
    }
}