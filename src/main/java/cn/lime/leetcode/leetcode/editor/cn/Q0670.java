//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 432 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0670 {
    public static void main(String[] args) {
        Solution solution = new Q0670().new Solution();
        solution.maximumSwap(99901);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            return method1(num);
        }

        private int method2(int num){
            char[] charArr = String.valueOf(num).toCharArray();
            char max = charArr[charArr.length - 1];
            int maxPosition = charArr.length - 1;
            int maxPositionFirst = charArr.length-1;
            // 找到最大数
            for (int i = charArr.length - 1; i >= 0; i--) {
                if (charArr[i]>max){
                    maxPosition = i;
                    max = charArr[i];
                }
                if (charArr[i]>=max){
                    maxPositionFirst =  i;
                    max = charArr[i];
                }
            }

            if (maxPositionFirst == 0){
                if (charArr.length==1) {
                    return num;
                }else {
                    int after = (int) (num % Math.pow(10,charArr.length-1));
                    after = maximumSwap(after);
                    return (num - (int) (num % Math.pow(10,charArr.length-1))) + after;
                }
            }
            int targetPosition = 0;
            for (int i = 0; i < maxPosition; i++) {
                if (charArr[i]<charArr[maxPosition]){
                    targetPosition = i;
                    break;
                }
            }
            char tmp = charArr[maxPosition];
            charArr[maxPosition] = charArr[targetPosition];
            charArr[targetPosition] = tmp;

            return Integer.parseInt(new String(charArr));
        }


        private int method1(int num){
            //转化为字符数组
            char[] chars = String.valueOf(num).toCharArray();
            int n = chars.length;
            int max = n - 1;
            int candidateMin = 0, candidateMax = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                //找到更大的元素
                if (chars[i] > chars[max]) {
                    max = i;
                } else if (chars[i] < chars[max]) {
                    candidateMin = i;
                    candidateMax = max;
                }
            }
            //找到一组交换的候选min max 并且min < max && chars[min] < chars[max]
            if (candidateMin < candidateMax && chars[candidateMin] < chars[candidateMax]) {
                char temp = chars[candidateMin];
                chars[candidateMin] = chars[candidateMax];
                chars[candidateMax] = temp;
                return Integer.parseInt(new String(chars));
            }
            return num;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}