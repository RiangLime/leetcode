//我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如 "USA" 。 
// 单词中所有字母都不是大写，比如 "leetcode" 。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。 
// 
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "USA"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：word = "FlaG"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 由小写和大写英文字母组成 
// 
//
// Related Topics 字符串 👍 259 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0520 {
    public static void main(String[] args) {
        Solution solution = new Q0520().new Solution();
        solution.detectCapitalUse("Leetcode");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            if (word.toUpperCase().equals(word)){
                return true;
            }
            if (word.toLowerCase().equals(word)){
                return true;
            }
            char[] cArr = word.toCharArray();
            for (int i = 0; i <cArr.length; i++) {
                if (i==0){
                    if (!isUppercase(cArr[i])){
                        return false;
                    }
                }else {
                    if (isUppercase(cArr[i])){
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isUppercase(char c){
            return c>='A' && c<='Z';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}