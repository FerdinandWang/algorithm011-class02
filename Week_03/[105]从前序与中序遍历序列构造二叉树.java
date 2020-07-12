//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 560 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static Map<Integer, Integer> map = new HashMap<>();
    static int [] preorder, inorder;

    public TreeNode buildTree(int[] _preorder, int[] _inorder) {
        preorder = _preorder;
        inorder = _inorder;
        //赋值<值, 索引>
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * dfs
     * @param pl 前序遍历左边界
     * @param pr 前序遍历右边界
     * @param il 中序遍历左边界
     * @param ir 中序遍历右边界
     * @return
     */
    static TreeNode dfs(int pl, int pr, int il, int ir){
        if(pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int k = map.get(root.val);
        //左子树的下标范围
        TreeNode left = dfs(pl + 1, pl + k - il, il, k - 1);
        //右子树的下标范围
        TreeNode right = dfs(pl + k - il + 1, pr, k + 1 , ir);
        root.left = left;
        root.right = right;
        return root;
    }
}
//runtime:2 ms
//memory:39.9 MB

//leetcode submit region end(Prohibit modification and deletion)
