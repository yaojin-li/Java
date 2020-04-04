import java.util.*;

/**
 * @Description: 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
 * 标识符后面的每个字将仅由小写字母组成，或；
 * 标识符后面的每个字将仅由数字组成。
 * <p>
 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
 * 将日志重新排序，使得所有字母日志都排在数字日志之前。
 * 字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。
 * 数字日志应该按原来的顺序排列。
 * 返回日志的最终顺序。
 * <p>
 * 示例 ：
 * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * <p>
 * 提示：
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 保证有一个标识符，并且标识符后面有一个字。
 * --------------------------------------
 * @ClassName: test_937.java
 * @Date: 2019/5/28 14:39
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_937 {
    public static void main(String[] args) {
        String[] logs = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"};
        Solution_937 solution = new Solution_937();

        String[] result = solution.reorderLogFiles(logs);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        String[] resultTwo = solution.reorderLogFilesTwo(logs);
        for (int i = 0; i < resultTwo.length; i++) {
            System.out.println(resultTwo[i]);
        }
    }
}

class Solution_937 {
    /**
     * @Description:
     * 1. 提取所有数字日志，顺序存储；字母日志另起存储；
     * 2. 字母日志忽略标识符，按字母内容排序；字母内容相同，按标识符排序；
     * 3. 追加数字日志内容返回结果
     * @Date: 2019/5/28 16:15
     * @Params:
     * @ReturnType:
     **/
    public String[] reorderLogFiles(String[] logs)  {
        int n = logs.length;
        List<String> letter = new LinkedList<String>(),digit = new ArrayList<String>();
        for(int i = 0;i<n;i++){
            char[] tmp = logs[i].toCharArray();
            if(Character.isDigit(tmp[tmp.length-1])){
                digit.add(logs[i]);
            }
            else{
                letter.add(logs[i]);
            }
        }

        //重写compare方法
        Comparator<String> c = new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                int t1 = s1.indexOf(" "),t2 = s2.indexOf(" ");
                return s1.substring(t1,s1.length()).compareTo(s2.substring(t2,s2.length()));
            }
        };
        Comparator<String> c1 = new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                int t1 = s1.indexOf(" "),t2 = s2.indexOf(" ");
                return s1.substring(0,t1).compareTo(s2.substring(0,t2));
            }
        };

        Collections.sort(letter,c1);
        Collections.sort(letter,c);

        String[] ans = new String[logs.length];
        int t = 0;
        for(String s : letter){
            ans[t++] = s;
        }
        for(String s : digit){
            ans[t++] = s;
        }
        return ans;
    }


    /**
     * @Description:
     * 1. 提取所有数字日志，顺序存储；字母日志另起存储；
     * 2. 字母日志忽略标识符，按字母内容排序；字母内容相同，按标识符排序；
     * 3. 追加数字日志内容返回结果
     * @Date: 2019/5/28 16:15
     * @Params:
     * @ReturnType:
     **/
    public String[] reorderLogFilesTwo(String[] logs) {
        List<String> numList = new ArrayList<String>();
        List<String> alpList = new LinkedList<String>();

        // 分离字母日志与数字日志
        for (int i = 0; i < logs.length; i++) {
            String oneLog = logs[i];
            int spaceFirstIndex = oneLog.indexOf(" ");
            if ('a' <= oneLog.charAt(spaceFirstIndex + 1) && oneLog.charAt(spaceFirstIndex + 1) <= 'z') {
                alpList.add(oneLog);
            } else {
                numList.add(oneLog);
            }
        }

        //字母日志排序。先排序第一个空格之前的内容，在此基础上再排序第一个空格之后的内容。
        alpList.sort((a, b) -> a.substring(0, a.indexOf(" ")).
                compareTo(b.substring(0, b.indexOf(" "))));

        alpList.sort((a, b) -> a.substring(a.indexOf(" ") + 1).
                compareTo(b.substring(b.indexOf(" ") + 1)));

        // 字母日志与数字日志拼接
        String[] result = new String[logs.length];
        int index = 0;
        for (String alp : alpList) {
            result[index++] = alp;
        }
        for (String num : numList) {
            result[index++] = num;
        }
        return result;
    }
}

