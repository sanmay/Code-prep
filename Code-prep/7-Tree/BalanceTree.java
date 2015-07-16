
class BalanceTree{
	
	
	static int minHeight(Node parent){
		if (parent==null)
			return 0;
		else 
			if (minHeight(parent.left)<minHeight(parent.right))
				return 1+minHeight(parent.left);
			else
				return 1+minHeight(parent.right);
	}
	
	static int maxHeight(Node parent){
		if (parent==null)
			return 0;
		else 
			if (maxHeight(parent.left)>maxHeight(parent.right))
				return 1+maxHeight(parent.left);
			else
				return 1+maxHeight(parent.right);
	}
	
	static boolean isBalanced(Node root){
		System.out.println("max="+maxHeight(root));
		System.out.println("min="+minHeight(root));
		return maxHeight(root)-minHeight(root)<2;
	}
	
	public static void main(String[] args){
		
		System.out.println("This method outputs whether tree is balanced or not");
		
		Tree T= new Tree();
		T.insert(5);
		T.insert(3);
		T.insert(2);
		T.insert(1);
		T.insert(6);
		T.insert(7);
		System.out.println("Inorder");
		T.inorder(T.root);
		System.out.println(isBalanced(T.root));
		
	}
}