//给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。 
//
// 返回 n 的长度。如果不存在这样的 n ，就返回-1。 
//
// 注意： n 可能不符合 64 位带符号整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 1
//输出：1
//解释：最小的答案是 n = 1，其长度为 1。 
//
// 示例 2： 
//
// 
//输入：k = 2
//输出：-1
//解释：不存在可被 2 整除的正整数 n 。 
//
// 示例 3： 
//
// 
//输入：k = 3
//输出：3
//解释：最小的答案是 n = 111，其长度为 3。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 数学 👍 167 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q1015 {
    public static void main(String[] args) {
        Solution solution = new Q1015().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestRepunitDivByK(int k) {

            Set<Integer> set = new HashSet<>();
            int len = 1;
            int mod = 1 % k;

            while (mod!=0){
                mod = (mod * 10 + 1) % k;
                len++;
                if (set.contains(mod)){
                    return -1;
                }else {
                    set.add(mod);
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}