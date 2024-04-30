//给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1527 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q0543 {
    public static void main(String[] args) {
        Solution solution = new Q0543().new Solution();
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

        private int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null)
                return -1; // 下面 +1 后，对于叶子节点就刚好是 0
            int lLen = dfs(node.left) + 1; // 左子树最大链长+1
            int rLen = dfs(node.right) + 1; // 右子树最大链长+1
            ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
            return Math.max(lLen, rLen); // 当前子树最大链长
        }


        public int diameterOfBinaryTree1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 0;
            }
            if (root.left == null) {
                return getTreeDepth(root.right);
            }
            if (root.right == null) {
                return getTreeDepth(root.left);
            }
            int left = getTreeDepth(root.left);
            int right= getTreeDepth(root.right);
            System.out.println("left:"+left +"-right:"+right);
            return left+right;
        }

        private int getTreeDepth(TreeNode root) {
            int depth = 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}