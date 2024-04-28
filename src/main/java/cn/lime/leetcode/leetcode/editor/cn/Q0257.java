//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1130 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q0257 {
    public static void main(String[] args) {
        Solution solution = new Q0257().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            iterate(root,"",paths);
            return paths;
        }

        public void iterate(TreeNode node, String path, List<String> paths) {
            if (node != null) {
                StringBuffer sb = new StringBuffer(path);
                sb.append(node.val);
                if (node.left == null && node.right == null) {
                    paths.add(sb.toString());
                }else {
                    sb.append("->");
                    iterate(node.left,sb.toString(),paths);
                    iterate(node.right,sb.toString(),paths);
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}