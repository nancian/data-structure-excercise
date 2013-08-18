package tree;

public class visibleNodes {
	private class Tree {
		public Tree(int X, Tree L, Tree R){
			x = X;
			l = L;
			r = R;
		}
		public int x;
		public Tree l;
		public Tree r;
	}

	//need to use Tree in another separate class
	public void main(String[] arg){
		Tree t = new Tree(5, new Tree(3, new Tree(20,null, null), new Tree(21, null, null)), new Tree(10, new Tree(1, null, null),null));
		System.out.println(numOfvisibleNodes(t));
	}
	public int numOfvisibleNodes(Tree t){
		if(t != null)
			return visible(t, Integer.MIN_VALUE);
		else
			return 0;
	}
	public int visible(Tree root, int max){
		int v = 0;
		System.out.println(root.x +" "+ max);
		if (root.x >= max){
			max = root.x;

			v = 1;
		}
		if (root.l != null){
			v += visible(root.l, max);
		}
		if (root.r != null){
			v += visible(root.r, max);
		}
		return v;

	}





}
