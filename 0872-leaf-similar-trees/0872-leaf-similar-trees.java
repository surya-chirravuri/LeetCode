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
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;    
    } 
    
    private void getLeafs(TreeNode root, ArrayList<Integer> leaf) {
        if(root == null) {
            return;
        }
        getLeafs(root.left, leaf);
        if(isLeaf(root)) {
            leaf.add(root.val);
        }
        getLeafs(root.right, leaf);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();
        
        getLeafs(root1, leaf1);
        getLeafs(root2, leaf2);
        if(leaf1.size() != leaf2.size()) {
            return false;
        }
        for(int i = 0; i < leaf1.size(); i++) {
            if(leaf1.get(i) != leaf2.get(i)) return false;
        }
        return true;
    }
}