//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3266 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0072 {
    public static void main(String[] args) {
        Solution solution = new Q0072().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            return dynamic(word1,word2);
        }

        private int dynamic(String word1, String word2) {
            /*
                dp[i][j] str1前i位 变为 str2前j位 的编辑距离
                a -> b a添加一个字母
                a -> b b添加一个字符
                a -> b a修改一个字符
                转移方程
                dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1, dp[i-1][j-1]+1/dp[i-1][j-1])
             */

            int lengthA = word1.length(), lengthB = word2.length();
            if (lengthA == 0 || lengthB == 0) return lengthA + lengthB;

            // DP 数组
            int[][] dp = new int[lengthA + 1][lengthB + 1];
            // 边界状态初始化
            for (int i = 0; i < lengthA + 1; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < lengthB + 1; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i < lengthA + 1; i++) {
                for (int j = 1; j < lengthB + 1; j++) {
                    int m1 = dp[i-1][j] + 1;
                    int m2 = dp[i][j-1] +1;
                    int m3 = dp[i-1][j-1];
                    if (word1.charAt(i-1) != word2.charAt(j-1)){
                        m3 = m3+1;
                    }
                    dp[i][j] = Math.min(m1,Math.min(m2,m3));
                }
            }
            return dp[lengthA][lengthB];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}