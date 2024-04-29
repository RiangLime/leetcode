//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
//
// Related Topics 数组 哈希表 字符串 👍 259 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0500 {
    public static void main(String[] args) {
        Solution solution = new Q0500().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            List<String> res = new ArrayList<>();
            for (String word : words) {
                int tmp = getHash(word.charAt(0));
                boolean flag = true;
                for (char c : word.toCharArray()) {
                    if (getHash(c)!=tmp){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    res.add(word);
                }
            }
            return res.toArray(new String[0]);
        }

        private int getHash(char c){
            switch (String.valueOf(c).toLowerCase()){
                case "q":return 1;
                case "w":return 1;
                case "e":return 1;
                case "r":return 1;
                case "t":return 1;
                case "y":return 1;
                case "u":return 1;
                case "i":return 1;
                case "o":return 1;
                case "p":return 1;

                case "a":return 2;
                case "s":return 2;
                case "d":return 2;
                case "f":return 2;
                case "g":return 2;
                case "h":return 2;
                case "j":return 2;
                case "k":return 2;
                case "l":return 2;

                case "z":return 3;
                case "x":return 3;
                case "c":return 3;
                case "v":return 3;
                case "b":return 3;
                case "n":return 3;
                case "m":return 3;

                default:return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}