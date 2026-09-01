/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();    //to store the inorder array elements

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);     //store the inorder arr elements into the map
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {     //if the child not build i.e., left > right
            return null;
        }

        int rootValue = preorder[preIndex++]; //find the root value
        TreeNode root = new TreeNode(rootValue); //store the root value in root

        int index = map.get(rootValue); // store the root value index

        root.left = build(preorder, left, index - 1); //recursive process to do the same process for the left child
        root.right = build(preorder, index + 1, right); // recursive process to do the same process for the right child
        return root;
    }
}