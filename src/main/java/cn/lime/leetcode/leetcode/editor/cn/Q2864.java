//给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。 
//
// 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。 
//
// 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。 
//
// 注意 返回的结果字符串 可以 含前导零。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "010"
//输出："001"
//解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "0101"
//输出："1001"
//解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 仅由 '0' 和 '1' 组成 
// s 中至少包含一个 '1' 
// 
//
// Related Topics 贪心 数学 字符串 👍 4 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q2864 {
    public static void main(String[] args) {
        Solution solution = new Q2864().new Solution();
        solution.maximumOddBinaryNumber("0101");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumOddBinaryNumber(String s) {
            /**
             *  执行耗时:11 ms,击败了5.23% 的Java用户
             * 	内存消耗:42.3 MB,击败了28.37% 的Java用户
             */
            int cnt = (int) s.chars().filter(c -> c == '1').count();
            return "1".repeat(cnt-1) + "0".repeat(s.length()-cnt) + "1";

            /**
             * 执行耗时:6 ms,击败了13.22% 的Java用户
             * 内存消耗:43.8 MB,击败了5.23% 的Java用户
             * String res = new String();
             *             if (cnt==1){
             *                 for (int i = 0; i < s.length() - 1; i++) {
             *                     res = res + '0';
             *                 }
             *                 res = res + '1';
             *
             *             }else {
             *                 for (int i = 0; i < cnt-1; i++) {
             *                     res = res + '1';
             *                 }
             *                 for (int i = res.length(); i < s.length(); i++) {
             *                     res = res + "0";
             *                 }
             *                 res = res.substring(0,res.length()-1);
             *                 res = res + '1';
             *             }
             *             return res;
             */

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}