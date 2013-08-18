package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
/**
 * tree method: minDepth, maxDepth, levelOrder, flatten, isSymmetric, isBalanced
 */

public class Tree {
	public class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
		
	}
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		public TreeLinkNode(int x) { val = x; }
	}
	/*
	 * ---------------------------------------Minimum Depth of Binary Tree--------------------------------------------
	 * Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null || root.right == null)
			return Math.max(minDepth(root.left), minDepth(root.right))+1;
		else
			return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}
	public int maxDepth(TreeNode root) {

		if (root ==  null)
			return 0;
		else
			return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
	/*--------------------------------------in-order traversal---------------------------------------
	 * 
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		//push until left most node
		while (node!= null){
			stack.push(node);
			node = node.left;
		}
		
		while (!stack.isEmpty()){
			
			node = stack.pop();
			list.add(node.val);
			//push until left most node of its right tree
			if (node.right != null){
				TreeNode rnode = node.right;
				while (rnode != null){
					stack.push(rnode);
					rnode = rnode.left;
				}
			}
		
		}
		return list;
	}
	/*---------------------------------------level order traversal---------------------------------------
	 * Given a binary tree, return the level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level).
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		if (root != null){
			queue.add(root);
			while(!queue.isEmpty()){
				ArrayList<Integer> level = new ArrayList<Integer>();
				ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
				for(int i = 0; i < queue.size(); i++){

					if (queue.get(i).left != null)
						temp.add(queue.get(i).left);
					if (queue.get(i).right != null)
						temp.add(queue.get(i).right);
					level.add(queue.get(i).val);

				}
				queue = temp;
				list.add(level);
			} 
		}
		return list;
	}
	/*---------------------------------------next pointer---------------------------------------
	 * Populate each next pointer to point to its next right node. 
	 * If there is no next right node, the next pointer should be set to NULL.
	 */
	public void connect(TreeLinkNode root) {
		
		LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		//edge case!!
		if (root != null)
			queue.add(root);
		while (!queue.isEmpty()){
			//could use a for loop to simplify
			LinkedList<TreeLinkNode> level = new LinkedList<TreeLinkNode>();
			TreeLinkNode node = queue.removeFirst();
			node.next = null;
			if (node.left != null)
				level.add(node.left);
			if (node.right != null)
				level.add(node.right);
			while (!queue.isEmpty()){

				TreeLinkNode next = queue.removeFirst();
				node.next = next;
				node = next;
				//set to null first
				node.next = null;
				if (node.left != null)
					level.add(node.left);
				if (node.right != null)
					level.add(node.right);

			}
			queue = level;
		}
	}
	/*
	 * another solution: constant space
	 */
	 public void connect2(TreeLinkNode root) {
	        //constant space!
	        
	        while(root != null){
	            TreeLinkNode pnode = root;
	            //initiate cnode
	            TreeLinkNode cnode = pnode.left;
	            root = root.left;
	            
	            while( pnode!= null && cnode != null){
	                
	                cnode.next = pnode.right;
	                if (pnode.next != null){
	                    pnode.right.next = pnode.next.left;
	                }
	                pnode = pnode.next;
	                if (pnode != null)
	                    cnode = pnode.left;                 
	            }
	        }
	    }
	 /*
	  * ----------------------------next pointer for non-perfect tree------------------------
	  * What if the given tree could be any binary tree? But not perfect tree.
	  */
	 
     public void connectNP(TreeLinkNode root) {
         //constant space! 
         while(root != null){
             TreeLinkNode pnode = root;
             //initiate cnode as first non-null child, pnode as its parent node
             TreeLinkNode cnode = pnode.left;
             while(cnode == null){
                 cnode = pnode.right;
                 if (cnode == null){
                     if ((pnode = pnode.next) == null)
                         break;
                     else
                         cnode = pnode.left;
                 }
             }
             if (cnode == null)
                 return;
             root = cnode;
             
             while (pnode!= null){
                 //cnode could be a right child!!
                 if (pnode.right != null && pnode.right != cnode){
                     cnode.next = pnode.right;
                     cnode = cnode.next;
                 }
                 if (pnode.next != null && pnode.next.left != null){
                     cnode.next = pnode.next.left;
                     cnode = cnode.next;
                 }
                 pnode = pnode.next;
                                 
             }
         }
     }
	/*---------------------------------------flatten tree---------------------------------------
	 * Given a binary tree, flatten it to a tree as if a linked list in-place.
	 */
	public void flatten(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); 
		if (root != null)
			stack.add(root);//add to end of list
		while (!stack.isEmpty()){
			TreeNode node = stack.getLast();
			stack.removeLast();
			if (node.right != null)
				stack.add(node.right);
			if (node.left != null){
				stack.add(node.left);

			}
			node.left = null;
			if (!stack.isEmpty())
				node.right = stack.getLast();
		}
	}
	/*---------------------------------------isSymmetric---------------------------------------
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 */
	public boolean isSymmetric(TreeNode root) {
		//in-order traverse
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (root != null){
			TreeNode node = root;
			while (node != null){
				stack.add(node);
				node = node.left;
			}
		}
		while (!stack.isEmpty()){
			TreeNode node = stack.getLast();
			stack.removeLast();
			list.add(node);
			if (node.right != null){
				stack.add(node.right);
				TreeNode noder = node.right;
				//important
				while (noder.left != null){
					stack.add(noder.left);
					noder = noder.left;
				}
			}

		}
		for (int i = 0; i < list.size()/2; i++){
			//should be val!!!
			if (list.get(i).val != list.get(list.size()-1-i).val)
				return false;
		}
		return true;

	}
	/*
	 * another solution for isSymmetric(in-place)
	 */
	public boolean isSymmetric2(TreeNode root) {

		if(root==null) return true;
		return isSymmetric(root.left,root.right);
	}

	public boolean isSymmetric(TreeNode a, TreeNode b){
		if(a==null) return b==null;
		if(b==null) return false;

		if(a.val!=b.val) return false;

		if(!isSymmetric(a.left,b.right)) return false;
		if(!isSymmetric(a.right,b.left)) return false;

		return true;
	}
	/*
	 * iterative solution for isSymmetric
	 * using broad-first iteration 
	 */
	public boolean isSymmetric3(TreeNode root) {
		if(root == null) return true;
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		LinkedList<TreeNode> r = new LinkedList<TreeNode>();
		l.add(root.left);
		r.add(root.right);
		while(!l.isEmpty() && !r.isEmpty()) {
			TreeNode temp1 = l.poll();
			TreeNode temp2 = r.poll();
			if(temp1 == null && temp2 != null || temp1 != null && temp2 == null)
				return false;
			if(temp1 != null) {
				if(temp1.val != temp2.val) {
					return false;
				}
				l.add(temp1.left);
				l.add(temp1.right);
				r.add(temp2.right);
				r.add(temp2.left);
			}

		}
		return true;
	}
	/*---------------------------------------isSame---------------------------------------
	 * Given two binary trees, write a function to check if they are equal or not.
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null) return q == null;
		if (q == null) return false;

		if (p.val != q.val) return false;

		if (!isSameTree(p.left, q.left) || !isSameTree(p.right,q.right))
			return false;

		return true;
	}

	/*---------------------------------------is balanced---------------------------------------
	 * Given a binary tree, determine if it is height-balanced.
	 * O(n*log(n))
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		else if (Math.abs(height(root.left)-height(root.right)) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

	private int height(TreeNode root){
		if (root == null)
			return 0;
		else
			return Math.max(height(root.left),height(root.right))+1;
	}

	/*
	 * another solution : O(n)
	 */
	public boolean isBalanced2(TreeNode root) {
		return height2(root) != -1;

	}

	private int height2(TreeNode root){
		if (root == null)
			return 0;
		int l = height(root.left);
		if (l == -1)
			return -1;
		int r = height(root.right);
		if( r == -1 || Math.abs(l-r) > 1)
			return -1;
		else
			return Math.max(l,r)+1;
	}
	/*---------------------------------------List to tree---------------------------------------
	 * Given an list where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	public TreeNode sortedListToBST(ListNode head) {
		int len = 0;
		ListNode node = head;
		while(node != null){
			node = node.next;
			len++;
		}
		return recurse(head, 0, len-1);

	}
	private TreeNode recurse(ListNode head, int left, int right){
		if (head == null || left > right)
			return null;
		int mid = (right - left)/2;
		//counts from left to midNode
		ListNode midNode = findNode(head, mid);
		TreeNode node = new TreeNode(midNode.val);
		//left+mid is the real midNode index
		node.left = recurse(head,left,left+mid-1);
		node.right = recurse(midNode.next, left+mid+1, right);
		return node;

	}
	private ListNode findNode(ListNode head, int index){
		for (int i = 0; i < index; i++){
			head = head.next;
		}
		return head;
	}
	/*---------------------------------------array to tree---------------------------------------
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	public TreeNode sortedArrayToBST(int[] num) {
		return recurse(num, 0, num.length-1);

	}
	private TreeNode recurse(int[] num, int low, int high){
		if (low > high)
			return null;
		int mid = low + (high - low)/2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = recurse(num, low, mid-1);
		node.right = recurse(num, mid+1, high);
		return node;
	}
	/*
	 * -------------------------------unique binary search tree-------------------------------
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	 * solution: 
	 * If root is i.th node,then the left subtree stores i - 1 values (1, ... , i - 1) --> T(i-1)
	 * the right subtree stores n - i values (i + 1, ... , n) -- > T(n-i)
	 * when root is i, number of trees: T(i-1)*T(n-i)
	 * Total number of trees T(n): sum of T(i-1)*T(n-i) in which i is 1 to n
	 * This is also know as Catalan number
	 * 
	 */
	public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        for(int i = 1; i < n + 1; ++i)
        	//calculate T(i): sum of T(j-1)*T(i-j)
            for (int j = 1; j <= i; ++j)
                num[i] += num[j-1]*num[i-j];  
        return num[n];
    }
	
}

