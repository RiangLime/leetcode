//给你两个下标从 0 开始的字符串 word1 和 word2 。 
//
// 一次 移动 由以下两个步骤组成： 
//
// 
// 选中两个下标 i 和 j ，分别满足 0 <= i < word1.length 和 0 <= j < word2.length ， 
// 交换 word1[i] 和 word2[j] 。 
// 
//
// 如果可以通过 恰好一次 移动，使 word1 和 word2 中不同字符的数目相等，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "ac", word2 = "b"
//输出：false
//解释：交换任何一组下标都会导致第一个字符串中有 2 个不同的字符，而在第二个字符串中只有 1 个不同字符。
// 
//
// 示例 2： 
//
// 输入：word1 = "abcc", word2 = "aab"
//输出：true
//解释：交换第一个字符串的下标 2 和第二个字符串的下标 0 。之后得到 word1 = "abac" 和 word2 = "cab" ，各有 3 个不同字符
//。
// 
//
// 示例 3： 
//
// 输入：word1 = "abcde", word2 = "fghij"
//输出：true
//解释：无论交换哪一组下标，两个字符串中都会有 5 个不同字符。 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10⁵ 
// word1 和 word2 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 28 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q2531 {
    public static void main(String[] args) {
        Solution solution = new Q2531().new Solution();
        solution.isItPossible("ab", "abcc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isItPossible(String word1, String word2) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (char c : word1.toCharArray()) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }
            for (char c : word2.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }


            for (Map.Entry<Character, Integer> entry1 : map1.entrySet()) {
                for (Map.Entry<Character, Integer> entry2 : map2.entrySet()) {
                    char c1 = entry1.getKey();
                    char c2 = entry2.getKey();

                    Map<Character, Integer> temp1 = new HashMap<>(map1);
                    Map<Character, Integer> temp2 = new HashMap<>(map2);
                    // 处理word1
                    if (temp1.get(c1)==1){
                        temp1.remove(c1);
                    }else {
                        temp1.put(c1,temp1.get(c1) -1);
                    }

                    if (temp2.containsKey(c1)){
                        temp2.put(c1,temp2.get(c1)+1);
                    }else {
                        temp2.put(c1,1);
                    }

                    // 处理word2
                    if (temp2.get(c2) ==1){
                        temp2.remove(c2);
                    }else {
                        temp2.put(c2,temp2.get(c2)-1);
                    }
                    if (temp1.containsKey(c2)){
                        temp1.put(c2,temp1.get(c2)+1);
                    }else {
                        temp1.put(c2,1);
                    }

                    if (temp1.keySet().size() ==temp2.keySet().size()){
                        return true;
                    }

                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}