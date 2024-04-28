//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
//
// Related Topics 字符串 👍 223 👎 0


package cn.lime.leetcode.leetcode.editor.cn;
public class Q0434{
    public static void main(String[] args) {
         Solution solution = new Q0434().new Solution();
    } 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {

        s= s.replaceAll("\s{2,}", " ");
        if (s.startsWith(" ")){
            s = s.substring(1);
        }
        if (s.equals("")){
            return 0;
        }
        return s.split(" ").length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}