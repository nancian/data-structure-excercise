package tree;

public class isBSTrecover {
	public void recover(TreeNode root) {
		recurse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private TreeNode recurse(TreeNode root, int min, int max){
		if (root == null)
			return null;
		//BST cannot contain dups
		TreeNode left = recurse(root.left,min,root.val);
		TreeNode right = recurse(root.right,root.val,max);
		if (left != null && right != null)
			swap(left, right);
		else if (left != null)
			return left;
		if (root.val <= min || root.val >= max)
			return root;
		return null;
	}
	private void swap(TreeNode a, TreeNode b){
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}
}
