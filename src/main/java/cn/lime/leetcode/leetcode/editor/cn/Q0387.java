//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 734 👎 0


package cn.lime.leetcode.leetcode.editor.cn;
public class Q0387{
    public static void main(String[] args) {
         Solution solution = new Q0387().new Solution();
         int x = solution.firstUniqChar("aadadaad");
        System.out.println(x);
    } 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int[] alpha = new int[26];

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (alpha[c-'a'] > 0){
                alpha[c-'a'] = -1;
            }else if (alpha[c-'a']==0){
                alpha[c-'a'] = i+1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : alpha) {
            if (i>0){
                min = Math.min(min,i);
            }
        }
        return min==Integer.MAX_VALUE?-1:min-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}