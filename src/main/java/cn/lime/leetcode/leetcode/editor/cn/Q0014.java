//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3111 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0014 {
    public static void main(String[] args) {
        Solution solution = new Q0014().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder prefixBuilder = new StringBuilder();
            int pos = 0;
            while (true){
                Character tmp = null;
                boolean breakFlag = false;
                for (String str : strs) {
                    if (pos>=str.length()){
                        breakFlag = true;
                        break;
                    }
                    if (tmp == null){
                        tmp = str.charAt(pos);
                    }else {
                        if (tmp != str.charAt(pos)) {
                            breakFlag = true;
                            break;
                        }
                    }
                }
                if (breakFlag){
                    break;
                }
                prefixBuilder.append(tmp);
                pos++;
            }

            return prefixBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}