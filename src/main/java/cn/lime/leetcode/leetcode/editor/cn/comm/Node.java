package cn.lime.leetcode.leetcode.editor.cn.comm;

import java.util.List;

/**
 * @ClassName: Node
 * @Description: TODO
 * @Author: Lime
 * @Date: 2024/4/30 13:46
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
