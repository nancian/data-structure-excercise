package tree;

public class isBST {
	public boolean isValidBST(TreeNode root) {
		return recurse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean recurse(TreeNode root, int min, int max){
		if (root == null)
			return true;
		//BST cannot contain dups
		if (root.val <= min || root.val >= max)
			return false;
		return recurse(root.left,min,root.val) && recurse(root.right,root.val,max);
	}
	
	
}
