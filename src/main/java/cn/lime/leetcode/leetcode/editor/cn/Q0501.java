//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 748 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Q0501 {
    public static void main(String[] args) {
        Solution solution = new Q0501().new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        a.right=b;
        b.left=c;

        solution.findMode(a);
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

        public int[] findMode(TreeNode root) {

            Map<Integer, Integer> cntMap = new HashMap<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.poll();
                    if (node!=null){
                        cntMap.put(node.val,cntMap.getOrDefault(node.val,0)+1);
                        if (node.left!=null) {
                            queue.offer(node.left);
                        }
                        if (node.right!=null) {
                            queue.offer(node.right);
                        }
                    }
                }

            }

            List<Integer> timeList = cntMap.values().stream().toList().stream().sorted().toList();
            int maxTime = timeList.get(timeList.size()-1);
            List<Integer> res = new ArrayList<>();

            for (Map.Entry<Integer,Integer> entry : cntMap.entrySet()){
                if (entry.getValue()==maxTime){
                    res.add(entry.getKey());
                }
            }
            int[] r = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                r[i] = res.get(i);
            }
            return r;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}