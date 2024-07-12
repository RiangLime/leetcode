//给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。 
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aa"
//输出：0
//解释：最优的子字符串是两个 'a' 之间的空子字符串。 
//
// 示例 2： 
//
// 输入：s = "abca"
//输出：2
//解释：最优的子字符串是 "bc" 。
// 
//
// 示例 3： 
//
// 输入：s = "cbzxy"
//输出：-1
//解释：s 中不存在出现出现两次的字符，所以返回 -1 。
// 
//
// 示例 4： 
//
// 输入：s = "cabbac"
//输出：4
//解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// s 只含小写英文字母 
// 
//
// Related Topics 哈希表 字符串 👍 87 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Q1624 {
    public static void main(String[] args) {
        Solution solution = new Q1624().new Solution();
        solution.maxLengthBetweenEqualCharacters("aa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            Map<Character, List<Integer>> countMap = new HashMap<>();
            for (int i = 0; i < s.toCharArray().length; i++) {
                char c = s.charAt(i);
                if (countMap.containsKey(c)) {
                    countMap.get(c).add(i);
                } else {
                    List<Integer> position = new ArrayList<>();
                    position.add(i);
                    countMap.put(c, position);
                }
            }

            int res = -1;

            for (Map.Entry<Character, List<Integer>> entry : countMap.entrySet()) {
                List<Integer> position = entry.getValue();
                if (position.size() > 2) {
                    Collections.sort(position);
                    res = Math.max(res, position.get(position.size() - 1) - position.get(0) - 1);
                }
                else if (position.size() == 2){
                    Collections.sort(position);
                    if ((position.get(1)-position.get(0)) == 1){
                        res = Math.max(res,0);
                    }else {
                        res = Math.max(res, position.get(position.size() - 1) - position.get(0) - 1);
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}