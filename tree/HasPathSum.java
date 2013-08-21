package tree;
/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 */
public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		//root node is null
		if (root == null)
			return false;
		//leaf
		if (root.left == null && root.right == null){
			if (root.val == sum)
				return true;
			else
				return false;
		}
		//not leaf
		if(hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val))
			return true;
		return false;

	}
}
