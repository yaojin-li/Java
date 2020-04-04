import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 *
 * 注意:
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 *
 * 首先翻译，再统计。
 * --------------------------------------
 * @ClassName: test_804.java
 * @Date: 2019/4/23 21:51
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_804 {
    public static void main(String args[]) {
        String[] words = {"gin", "zen", "gig", "msg"};
        Solution_884 solution_884 = new Solution_884();
//        System.out.println(solution_884.uniqueMorseRepresentationsOne(words));
        System.out.println(solution_884.uniqueMorseRepresentationsTwo(words));
    }
}

class Solution_884 {
    /**
     * @Description: 双字符列表遍历
     * @Date: 2019/4/23 22:42
     * @Params:
     * @ReturnType:
     **/
    public int uniqueMorseRepresentationsOne(String[] words) {
        String[] signs = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < signs.length; i++) {
            for (int j = 0; j < alphabets.length; j++) {
                map.put(alphabets[j], signs[j]);
            }
        }
        Set<String> alphabetToSign = new HashSet<>();
        for (String word : words) {
            String temp = "";
            for (int i = 0; i < word.length(); i++) {
                temp += map.get(String.valueOf(word.charAt(i)));//char to string: String.valueOf()
            }
            alphabetToSign.add(temp);
        }
        return alphabetToSign.size();
    }

    /**
     * @Description: ascii码的差作为signs的索引；StringBuilder拼接
     * @Date: 2019/4/23 22:44
     * @Params:
     * @ReturnType:
     **/
    public int uniqueMorseRepresentationsTwo(String[] words) {
        String[] signs = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        if (words == null) return 0;
        Set<String> alphabetToSign = new HashSet<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char alphabet : word.toCharArray()) {
                //利用小写字母的ASCII码的差值找到对应的摩尔斯密码
                stringBuilder.append(signs[alphabet - 'a']);    //alphabet - 'a'：转化为ascii码
            }
            alphabetToSign.add(stringBuilder.toString());
        }
        return alphabetToSign.size();
    }

}
