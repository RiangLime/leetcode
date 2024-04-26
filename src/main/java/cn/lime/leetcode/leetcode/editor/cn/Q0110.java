//给定一个二叉树，判断它是否是 平衡二叉树 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1503 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.TreeNode;

public class Q0110 {
    public static void main(String[] args) {
        Solution solution = new Q0110().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            if (root == null){
                return true;
            }
            return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
        }


        public int getHeight(TreeNode node){
            if (node == null){
                return 0;
            }
            return Math.max(getHeight(node.left),getHeight(node.right))+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}