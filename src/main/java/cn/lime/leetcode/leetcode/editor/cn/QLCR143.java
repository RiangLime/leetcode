//给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。 注意，空树 不会是以 
//tree1 的某个节点为根的子树具有 相同的结构和节点值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//
// 
//输入：tree1 = [1,7,5], tree2 = [6,1]
//输出：false
//解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
//输出：true
//解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。 
//
// 
//
// 提示： 
//
// 0 <= 节点个数 <= 10000 
//
// Related Topics 树 深度优先搜索 二叉树 👍 805 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.TreeNode;

// TODO: 2024/1/26

public class QLCR143 {
    public static void main(String[] args) {
        Solution solution = new QLCR143().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) &&
                    (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        boolean recur(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return recur(A.left, B.left) && recur(A.right, B.right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}