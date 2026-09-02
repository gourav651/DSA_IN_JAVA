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
        HashMap<Integer, Integer> map = new HashMap<>();
        int postIndex;

        public TreeNode buildTree(int[] inorder, int[] postorder){
            postIndex=postorder.length-1;
            for(int i=0;i<inorder.length;i++){
                map.put(inorder[i], i);
            }
             return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) {     //if the child not build i.e., left > right
            return null;
        }

        int rootValue = postorder[postIndex--]; //find the root value
        TreeNode root = new TreeNode(rootValue); //store the root value in root

        int index = map.get(rootValue); // store the root value index

        root.right = build(postorder, index+1, right); 
        root.left = build(postorder, left, index-1); 
        return root;
    }
}