//当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 
//'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。 
//
// 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "YazaAay"
//输出："aAa"
//解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
//"aAa" 是最长的美好子字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "Bb"
//输出："Bb"
//解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。 
//
// 示例 3： 
//
// 
//输入：s = "c"
//输出：""
//解释：没有美好子字符串。 
//
// 示例 4： 
//
// 
//输入：s = "dDzeE"
//输出："dD"
//解释："dD" 和 "eE" 都是最长美好子字符串。
//由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含大写和小写英文字母。 
// 
//
// Related Topics 位运算 哈希表 字符串 分治 滑动窗口 👍 235 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q1763 {
    public static void main(String[] args) {
        Solution solution = new Q1763().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestNiceSubstring(String s) {
            int n = s.length();
            int[][] cnt = new int[n + 1][128];
            for (int i = 1; i <= n; i++) {
                char c = s.charAt(i - 1);
                cnt[i] = cnt[i - 1].clone();
                cnt[i][c - 'A']++;
            }
            int idx = -1, len = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (j - i + 1 <= len) continue;
                    int[] a = cnt[i], b = cnt[j + 1];
                    if (check(a, b)) {
                        idx = i; len = j - i + 1;
                    }
                }
            }
            return idx == -1 ? "" : s.substring(idx, idx + len);

        }


        private boolean check(int[] a, int[] b) {
            for (int i = 0; i < 26; i++) {
                int low = b[i] - a[i], up = b[i + 32] - a[i + 32]; // 'A' = 65、'a' = 97
                if (low != 0 && up == 0) return false;
                if (low == 0 && up != 0) return false;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}