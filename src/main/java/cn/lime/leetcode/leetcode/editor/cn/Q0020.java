//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4321 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import io.micrometer.common.util.StringUtils;

import java.util.Stack;

public class Q0020 {
    public static void main(String[] args) {
        Solution solution = new Q0020().new Solution();
        System.out.println(solution.isValid("()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.toCharArray().length; i++) {
                if ((s.charAt(i) == ')'||s.charAt(i) == ']'||s.charAt(i) == '}') && stack.isEmpty()){
                    return false;
                }
                if (s.charAt(i) == ')' ){
                    if (stack.pop() != '('){
                        return false;
                    }
                }
                else if (s.charAt(i) == ']'){
                    if (stack.pop() != '['){
                        return false;
                    }
                }
                else if (s.charAt(i) == '}'){
                    if (stack.pop() != '{'){
                        return false;
                    }
                }else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}