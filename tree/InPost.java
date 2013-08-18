package tree;
/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
 */
public class InPost {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return recurse(inorder, 0, inorder.length-1, postorder, postorder.length-1);

	}
	private TreeNode recurse(int[] inorder, int l, int r, int[] postorder, int i){
		if (l > r || i < 0)
			return null;
		int x = 0;
		//find root it in-order traverse
		for (x = l; x<= r && inorder[x] != postorder[i]; x++){}

		TreeNode root = new TreeNode(postorder[i]);
		root.left = recurse(inorder, l, x-1,postorder, i-r+x-1);
		root.right = recurse(inorder, x+1, r, postorder, i-1);
		return root;
	}
}

/* Given preorder and inorder traversal of a tree, construct the binary tree.
 
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return recurse(inorder, 0, inorder.length-1, preorder, 0);

	}
	private TreeNode recurse(int[] inorder, int l, int r, int[] preorder, int i){
		if (l > r)
			return null;
		int x = 0;
		//find root it in-order traverse
		for (x = l; x<= r && inorder[x] != preorder[i]; x++){}

		TreeNode root = new TreeNode(preorder[i]);
		root.left = recurse(inorder, l, x-1,preorder, i+1);
		root.right = recurse(inorder, x+1, r, preorder, i+x-l+1);
		return root;
	}
 */

