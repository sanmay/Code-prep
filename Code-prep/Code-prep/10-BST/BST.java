

class BST{
	private Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key=key;
		}
	}
	
	
	Node put(int key, Node x){
		if (x==null){
			return Node(key);
		}else{
			if(key==x.key)
				return x;
			else if(key<x.key)
				x.left=put(key,x.left);
			else
				x.right=put(key,x.right);
		}
	}
	
	Node put(int key){
		return put(key,root);
	}

}