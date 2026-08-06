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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return sum;
        helper(root,"");
        return sum;
    }
    private void helper(TreeNode root,String str){
        if(root==null){
            return;
        }
        if(root.left == null && root.right==null){
            sum=sum+Integer.parseInt(str + String.valueOf(root.val));
            return;
        }
        String cur = str + String.valueOf(root.val);
        helper(root.left,cur);
        helper(root.right,cur);
        return;
    }
}