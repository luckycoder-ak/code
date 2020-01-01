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
    public static int ans=0;
    public static void dfs(TreeNode root, int sum) {
        if(root==null) return;
        sum+=root.val;
        if(root.left==null && root.right == null) {
            ans+=sum;
        } else {
            dfs(root.left, sum*10);
            dfs(root.right, sum*10);
        }
        return;
    }
    public int sumNumbers(TreeNode root) {
        ans=0;
        dfs(root, 0);
        return ans;        
    }
}