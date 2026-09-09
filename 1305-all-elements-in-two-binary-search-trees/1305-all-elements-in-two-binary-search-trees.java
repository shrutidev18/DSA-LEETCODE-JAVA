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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a1 = new ArrayList<>();
        in(root1,a1);
        List<Integer> a2 = new ArrayList<>();
        in(root2,a2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;       
        while (i < a1.size() && j < a2.size()) {
            if (a1.get(i) <= a2.get(j)) {
                res.add(a1.get(i++));
            } else {
                res.add(a2.get(j++));
            }
        }
        while (i < a1.size()) {
            res.add(a1.get(i++));
        }
        while (j < a2.size()) {
            res.add(a2.get(j++));
        }
        
        return res;

    }
    void in(TreeNode root,List<Integer> arr){
        if(root==null) return;
        if(root.left==null && root.right==null){
            arr.add(root.val);
            return;
        }
        in(root.left,arr);
        arr.add(root.val);
        in(root.right,arr);
        return;
    }
}