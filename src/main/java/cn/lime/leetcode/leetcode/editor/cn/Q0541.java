//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 592 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0541 {
    public static void main(String[] args) {
        Solution solution = new Q0541().new Solution();
        solution.reverseStr("abcdefg", 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            return null;
        }

        public String reverseStrViolent(String s, int k) {
            StringBuilder tmp = new StringBuilder();
            StringBuilder res = new StringBuilder();
            List<String> splitList = new ArrayList<>();
            char[] cArr = s.toCharArray();
            for (int i = 0; i < cArr.length; i++) {

                tmp.append(cArr[i]);
                if (i % (2 * k) == ((2 * k) - 1)) {
                    splitList.add(tmp.toString());
                    tmp = new StringBuilder();
                }
                if (i == cArr.length - 1 && tmp.length() != 0) {
                    splitList.add(tmp.toString());

                }
            }

            for (int i = 0; i < splitList.size(); i++) {
                char[] cs = splitList.get(i).toCharArray();
                if (i != splitList.size() - 1) {

                    for (int j = k - 1; j >= 0; j--) {
                        res.append(cs[j]);
                    }
                    for (int j = k; j < 2 * k; j++) {
                        res.append(cs[j]);
                    }
                } else {
                    if (cs.length < k) {
                        for (int j = cs.length - 1; j >= 0; j--) {
                            res.append(cs[j]);
                        }
                    } else {
                        for (int j = k - 1; j >= 0; j--) {
                            res.append(cs[j]);
                        }
                        for (int j = k; j < cs.length; j++) {
                            res.append(cs[j]);
                        }
                    }
                }
            }

            return res.toString();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}