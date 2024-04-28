//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
//
// Related Topics 哈希表 字符串 👍 644 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q0290 {
    public static void main(String[] args) {
        Solution solution = new Q0290().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] arr = s.split(" ");
            Map<Character,String> map = new HashMap<>();
            if (pattern.length()!=arr.length){
                return false;
            }
            for (int i = 0; i < pattern.toCharArray().length; i++) {
                if (map.containsKey(pattern.charAt(i))){
                    if (!map.get(pattern.charAt(i)).equals(arr[i])){
                        return false;
                    }
                }else {
                    //判断 value 中是否存在
                    if(map.containsValue(arr[i])){
                        return false;
                    }
                    map.put(pattern.charAt(i),arr[i]);
                }
            }
            return true;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}