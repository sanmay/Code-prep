
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	void print(){
		System.out.println(data);
	}
}

class BST{
	Node root;
	
	BST(){
		root=null;
	}
	
	Node insertR(Node temp,int data){
		if (temp==null){
			return new Node(data);
		}else{
			if (data<temp.data)
				temp.left=insertR(temp.left,data);
			else
				temp.right=insertR(temp.right,data);
			return temp;
		}
	}
	
	void insertL(Node root,int data){
		Node temp=root;
		while(true){
			if(data<temp.data){
				if(temp.left==null){
					temp.left=new Node(data);
					break;
				}
				else
					temp=temp.left;
			}
			else{
			if(temp.right==null){
				temp.right=new Node(data);
				break;
			}
			else
				temp=temp.right;
		}
		}
	}
	
	void inorder(Node temp){
		if(temp==null)
			return;
		else{
			inorder(temp.left);
			System.out.println(temp.data);
			inorder(temp.right);
		}	
	}
	
	void preorder(Node temp){
		if(temp==null)
			return;
		else{
			System.out.println(temp.data);
			preorder(temp.left);
			preorder(temp.right);
		}	
	}
	
	void postorder(Node temp){
		if(temp==null)
			return;
		else{
			postorder(temp.left);
			postorder(temp.right);
			System.out.println(temp.data);
		}	
	}
	
	void preorderI(Node root){
		Stack<Node> S=new Stack<Node>();
		S.push(root);
		while(S.size()>0){
			Node temp=S.pop();
			System.out.println(temp.data);
			if(temp.right!=null)
				S.push(temp.right);
			if(temp.left!=null)
				S.push(temp.left);
		}
	}
	
	void inorderI(Node root){
		Node temp=root;
		Stack <Node> S=new Stack<Node>();
		//S.push(temp);
		do{	
			if(temp!=null){
				//System.out.println(temp.data);
				S.push(temp);
				temp=temp.left;
			}
			else if(!S.isEmpty()){
				temp=S.pop();
				System.out.println(temp.data);
				temp=temp.right;
			}else
				break;
		}while(true);
	}
	
	void postorderI(Node root){
		Node temp=root;
		Stack<Node> S=new Stack<Node>();
		S.push(temp);
		while(!S.isEmpty()){
			if(temp==null)
				temp=S.pop();
			
			if(temp.right!=null){
				S.push(temp.right);
				S.push(temp);
			}else{
				S.push(temp);
			}
			temp=temp.left;
					
		}
	}
	
	Node findMin(Node temp){
		if(temp.left==null)
			return temp;
		else
			return findMin(temp.left);
	}

	Node inorderSucc(Node root, Node n){
		if(n.right!=null){
			return findMin(n.right);
		}
		else{
			Node suc=null;
			while(root!=null){
			
				if(n.data<root.data){
					suc=root;
					root=root.left;
				}else if(n.data>root.data){
					root=root.right;
				}else
					break;
			}
		return suc;
		}
	}
	
	
}