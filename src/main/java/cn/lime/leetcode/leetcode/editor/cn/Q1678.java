//请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解
//析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字
//符串。 
//
// 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。 
//
// 
//
// 示例 1： 
//
// 输入：command = "G()(al)"
//输出："Goal"
//解释：Goal 解析器解释命令的步骤如下所示：
//G -> G
//() -> o
//(al) -> al
//最后连接得到的结果是 "Goal"
// 
//
// 示例 2： 
//
// 输入：command = "G()()()()(al)"
//输出："Gooooal"
// 
//
// 示例 3： 
//
// 输入：command = "(al)G(al)()()G"
//输出："alGalooG"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= command.length <= 100 
// command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成 
// 
//
// Related Topics 字符串 👍 94 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.Stack;

public class Q1678 {
    public static void main(String[] args) {
        Solution solution = new Q1678().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String interpret(String command) {
            StringBuilder newCommand = new StringBuilder();
            StringBuilder subBuilder = new StringBuilder();
            for (char c : command.toCharArray()) {
                if (c=='G'){
                    newCommand.append("G");
                }
                else {
                    subBuilder.append(c);
                    if (c==')'){
                        if (subBuilder.length()==2){
                            newCommand.append('o');
                        }else {
                            newCommand.append(subBuilder.toString().substring(1,subBuilder.length()-1));
                        }
                        subBuilder = new StringBuilder();
                    }
                }
            }
            return newCommand.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}