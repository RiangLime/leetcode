package cn.lime.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9911 👎 0

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)){
            return 0;
        }
        int max = 1;
        int ptrStart = 0;
        for (int ptrEnd = 0; ptrEnd < s.length(); ptrEnd++) {
            String subString = s.substring(ptrStart,ptrEnd+1);
            System.out.println("[Judge] "+ subString);
            Set<Character> set = new HashSet<>();
            for (char c : subString.toCharArray()) {
                set.add(c);
            }
            if (subString.length()!=set.size()){
                ptrStart++;
            }else {
                max = Math.max(max,ptrEnd-ptrStart+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "bbbbb";
        System.out.println(lengthOfLongestSubstring(test));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
