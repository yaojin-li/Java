import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description: 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * 示例 2 :
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * <p>
 * 注意：
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * <p>
 * 1.按要求，字串长度是偶数，一半一半全是0全是1
 * 2.找到所有偶数长度的字串放到list<String>中；
 * 3.筛选一半长度全是0或1的字串，返回list长度；
 * <p>
 * 1.遍历按步长截取的偶数串判断是否一半一半全是0全是1
 * 2.筛选一半长度全是0或1的字串、不全是0不全是1，加入list，步长+2
 * 3.返回list长度；
 * <p>
 * 	if s.len<2 return 0
 * 	步长=2
 * 	while(步长<=s.len)
 * 		for(i=0;i+步长<=s.len;i++)
 * 			one = s.substring(i,i+步长)
 * 			if(isTar(one))
 * 				list.add()
 * 		步长=步长+2
 * 	return list.len
 * <p>
 * 注意点：
 * 1. 000111000    基数，步长+2
 * 2. 时间超时
 * 3. 善用字符数组s.toCharArray()
 * --------------------------------------
 * @ClassName: test_696.java
 * @Date: 2019/5/27 15:45
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_696 {
    public static void main(String[] args) {
        String s = "000111000";
        Solution_696 solution = new Solution_696();
        System.out.println(solution.countBinarySubstrings(s));
        System.out.println(solution.countBinarySubstringsTwo(s));
    }
}

class Solution_696 {
    /**
     * @Description:
     * @Date: 2019/5/27 17:03
     * @Params:
     * @ReturnType:
     **/
    public int countBinarySubstrings(String s) {
        int last = 0;
        int current = 1;    // 开始至少有一个数据
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                current++;
            } else {
                last = current;
                current = 1;
            }
            // 现在的数据与之前的数据不同，累加二者的差，000111 从一开始0001，00011，000111 类似的结果
            if (last >= current) {
                result++;
            }
        }
        return result;
    }


    /**
     * @Description: 计算连续的0或者1的长度
     * 例如“0011100001”， 则为 (2,3,4,1),
     * 只需计算相邻的两个元素的最小值，因为要求0和1必须在子串中连续。 即sum(2 min 3, 3 min 4, 4 min 1)
     * @Date: 2019/5/27 17:01
     * @Params:
     * @ReturnType:
     **/
    public int countBinarySubstringsTwo(String s) {
        List<Integer> list = new ArrayList<>();
        HashSet set = new HashSet();
        int num = 0;
        // 遍历连续相同字符，计算个数
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() > 1) {
                set.clear();
                list.add(num);
                i = i - 1;
                num = 0;
            } else {
                num++;
            }
        }
        // 添加最后一位不同的字符
        list.add(num);

        // 比较相邻两个num，累加小值
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int min = list.get(i) > list.get(i + 1) ? list.get(i + 1) : list.get(i);
            res += min;
        }
        return res;
    }

}
