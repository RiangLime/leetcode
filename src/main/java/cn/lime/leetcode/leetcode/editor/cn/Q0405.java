//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
//
// 注意: 
//
// 
// 十六进制中所有字母(a-f)都必须是小写。 
// 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
// 给定的数确保在32位有符号整数范围内。 
// 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。 
// 
//
// 示例 1： 
//
// 
//输入:
//26
//
//输出:
//"1a"
// 
//
// 示例 2： 
//
// 
//输入:
//-1
//
//输出:
//"ffffffff"
// 
//
// Related Topics 位运算 数学 👍 303 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0405 {
    public static void main(String[] args) {
        Solution solution = new Q0405().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHex(int num) {
            long numLong = num;
            if (numLong ==0 ){
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            if (numLong<0){
                numLong = (long)Math.pow(2,32)+numLong;
            }

            while (numLong!=0){
                long u = numLong % 16;
                char c = (char)(u + '0');
                if (u >= 10) c = (char)(u - 10 + 'a');
                sb.append(c);
                numLong /= 16;
            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}