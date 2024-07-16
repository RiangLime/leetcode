//给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 
//false 。 
//
// 
// 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。 
// 
//
// 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1101"
//输出：true
//解释：
//由 1 组成的最长连续子字符串的长度是 2："1101"
//由 0 组成的最长连续子字符串的长度是 1："1101"
//由 1 组成的子字符串更长，故返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：s = "111000"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 3："111000"
//由 0 组成的最长连续子字符串的长度是 3："111000"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 示例 3： 
//
// 
//输入：s = "110100010"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 2："110100010"
//由 0 组成的最长连续子字符串的长度是 3："110100010"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 不是 '0' 就是 '1' 
// 
//
// Related Topics 字符串 👍 32 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q1869 {
    public static void main(String[] args) {
        Solution solution = new Q1869().new Solution();
        solution.getLongestCharLength("111000",'0');
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkZeroOnes(String s) {
            int a = getLongestCharLength(s, '1');
            int b = getLongestCharLength(s, '0');
            System.out.println("a:" + a + ",b:" + b);
            return a > b;
        }

        private int getLongestCharLength(String str, char c) {
            int res = 0;
            int cur = 0;
            boolean flag = false;
            char[] arr = str.toCharArray();
            for (char value : arr) {
                if (value == c) {
                    flag = true;
                    cur++;
                } else {
                    if (flag) {
                        res = Math.max(res, cur);
                    }
                    cur = 0;
                    flag = false;
                }
            }
            return Math.max(res, cur);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}