//给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。 
//
// 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出："110"
//解释：(-2)² + (-2)¹ = 2
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出："111"
//解释：(-2)² + (-2)¹ + (-2)⁰ = 3
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出："100"
//解释：(-2)² = 4
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 数学 👍 191 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q1017 {
    public static void main(String[] args) {
        Solution solution = new Q1017().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                int mod = n % (-2);
                n /= -2;
                if (mod == -1) {
                    // 修正一下
                    sb.append(1);
                    ++n;
                } else {
                    sb.append(mod);
                }
            }
            return sb.reverse().toString();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}