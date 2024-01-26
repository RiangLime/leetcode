//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
//
// Related Topics 贪心 双指针 字符串 👍 88 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class QLCR019 {
    public static void main(String[] args) {
        Solution solution = new QLCR019().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int low = 0;
            int high = s.length() - 1;
            while (low < high) {
                char lowC = s.charAt(low);
                char highC = s.charAt(high);
                // 相等直接移动指针
                if (highC == lowC){
                    low++;
                    high--;
                }
                // 不等看子串是不是
                else {
                    return isPalindrome(s,low+1,high) || isPalindrome(s,low,high-1);
                }
            }
            return true;
        }

        /**
         * @param s
         * @param low
         * @param high
         * @return
         */
        private boolean isPalindrome(String s, int low, int high) {
            for (int i = low, j = high; i < j; ++i,--j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}