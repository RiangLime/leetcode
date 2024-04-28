//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 829 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0415 {
    public static void main(String[] args) {
        Solution solution = new Q0415().new Solution();

        System.out.println(solution.addStrings("11","123"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int ptr1 = num1.length() - 1, ptr2 = num2.length() - 1;
            boolean flag = false;
            while (ptr1 >= 0 || ptr2 >= 0) {
                int n1 = ptr1 >= 0 ? num1.charAt(ptr1)-'0' : 0;
                int n2 = ptr2 >= 0 ? num2.charAt(ptr2)-'0' : 0;
                int sum = n1 + n2 + (flag?1:0);
                flag = sum>=10;
                sb.append(sum%10);

                ptr1--;
                ptr2--;
            }
            if (flag){
                sb.append("1");
            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}