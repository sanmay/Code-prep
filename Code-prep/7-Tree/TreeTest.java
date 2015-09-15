class Node{
	int data;
	int size;
	public Node left, right, parent;

	Node(int data){
		this.data=data;
		left=null;
		right=null;
		parent=null;
		size=0;
	}

}

class Tree{
	
	
	public Node root;
	
	Tree(){
		root=null;
	}
	
	void recurse(Node parent, Node temp){
		if (temp.data<=parent.data){
			if (parent.left==null){
				parent.left=temp;
				temp.parent=parent;
			}else{
				recurse(parent.left,temp);
			}
		}else{
			if (parent.right==null){
				parent.right=temp;
				temp.parent=parent;
			}else{
				recurse(parent.right,temp);
			}
		}
	}
	
	void insert(int data){
		Node temp=new Node(data);
		if (root==null){
			root=temp;
		}
		else{
			recurse(root,temp);
		}
	}
	
	void inorder(Node parent){
		if (parent==null)
			return;
		else{
			inorder(parent.left);
			System.out.println(parent.data+" "+parent.size);
			inorder(parent.right);
		}
	}

	void preorder(Node parent){
		if (parent==null)
			return;
		else{
			System.out.println(parent.data);
			preorder(parent.left);			
			preorder(parent.right);
		}
	}
	
	void postorder(Node parent){
		if (parent==null)
			return;
		else{
			postorder(parent.left);			
			postorder(parent.right);
			System.out.println(parent.data);
		}
	}	
	
	int min(Node temp){
		if (temp.left==null)
			return temp.data;
		else
			return min(temp.left);
	}
	
	int max(Node temp){
		if (temp.right==null)
			return temp.data;
		else
			return max(temp.right);
	}
	
	Node find(int data, Node temp){
		if (temp==null){
			return null;
		}
		else if (temp.data==data)
			return temp;
		else{
			if (data<temp.data)
				return find(data,temp.left);
			else	
				return find(data,temp.right);
		}
	}
	
	int predec(int data,Node root){
	Node temp=find(data,root);
	if (temp.left!=null)
		return max(temp.left);
	else{
		if(temp.parent.right==temp)
			return temp.parent.data;
		else{
			while(temp.parent.right!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
	
	int sucdec(int data,Node root){
	Node temp=find(data,root);
	if (temp.right!=null)
		return min(temp.right);
	else{
		if(temp.parent.left==temp)
			return temp.parent.data;
		else{
			while(temp.parent.left!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}

	Node floor(int data, Node temp){
		if (temp==null)
			return null;
		else{
			if(data==temp.data)
				return temp;
			else{
				if(data<temp.data)
					return floor(data,temp.left);
				else{
					Node t=floor(data,temp.right);
					if(t!=null) return t;
					else
						return temp;
				}
			}
		}
	}

	int cal_size(Node temp){
		if (temp==null)
			return 0;
		else
			temp.size=1+cal_size(temp.left)+cal_size(temp.right);
			return temp.size;
	}

	Node select(int rank, Node temp){
		int t_size;
		if(temp==null)
			return null;
		else{
			if(temp.left!=null){
				t_size=temp.left.size;
			}else{
				t_size=0;
			}
			if(rank==temp.size-t_size){
				return temp;
			}else{
				if(rank>t_size)
					return select(rank-t_size-1,temp.right);
				else
					return select(rank,temp.left);
			}
				
			
			}
	}
	
	Node inPlaceSucc(Node temp, int data){
		if (temp==null)
			return null;
		else{
			if(temp.data==data){
				if(temp.right!=null){
					Node suc=null;
					temp=temp.right;
					while(temp!=null){
						suc=temp;
						temp=temp.left;
					}
					return suc;
				}
				else{
					return null;
				}
			}else{
				if(data>temp.data)
					return inPlaceSucc(temp.right,data);
				else{
					Node suc=inPlaceSucc(temp.left,data);
					return suc!=null?suc:temp;
				}
			}
		}
	}
	
	int minHeight(Node temp){
		if(temp==null)
			return 0;
		else{
			int left=minHeight(temp.left);
			int right=minHeight(temp.right);
			return left<right?left+1:right+1;
		}

	}

	int maxHeight(Node temp){
		if(temp==null)
			return 0;
		else{
			int left=maxHeight(temp.left);
			int right=maxHeight(temp.right);
			return left>right?left+1:right+1;
		}
	}

	boolean isBalanced(Node temp){
		if (temp==null)
			return true;
		else{
			return maxHeight(temp)-minHeight(temp)<=1;
		}
	}
	
	
	
	
}


class TreeTest{

	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(7);
		T.insert(5);
		T.insert(6);
		T.insert(4);
		T.insert(10);
		T.insert(8);
		T.cal_size(T.root);
		System.out.println("Inorder");
		T.inorder(T.root);
		//Node suc=T.inPlaceSucc(T.root,5);
		System.out.println(T.isBalanced(T.root));
		
		
	}
}