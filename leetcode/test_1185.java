/**
 * @Description: 1185. 一周中的第几天
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 * 示例 1：
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * <p>
 * 示例 2：
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * <p>
 * 示例 3：
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 * 提示：
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 * --------------------------------------
 * @ClassName: test_1185.java
 * @Date: 2019/11/6 17:20
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_1185 {
    public static void main(String[] args) {
        int day = 3;
        int month = 5;
        int year = 2018;
        Solution_1185 solution = new Solution_1185();
        System.out.println(solution.dayOfTheWeek(day, month, year));
    }
}

class Solution_1185 {
    /**
     * @Description: 蔡勒公式
     * @Date: 2019/11/6 17:23
     * @Params:
     * @ReturnType:
     **/
    public String dayOfTheWeek(int day, int month, int year) {
        String[] res = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] days = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int alldays = 0;
        for (int i = 1970; i < year; i++)
            alldays += (i % 400 == 0 || (i % 100 != 0 && i % 4 == 0)) ? 366 : 365;
        alldays += days[month - 1];
        if ((year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) && month > 2)
            alldays++;
        alldays += day;
        return res[(alldays - 5) % 7];
    }
}
