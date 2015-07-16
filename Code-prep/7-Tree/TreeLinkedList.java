
import java.util.*;

class Node{
		int data;
		public Node left, right, parent;
		
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			parent=null;
		}
		
	}


class Tree2LinkedList{
	ArrayList<LinkedList<Node>> convert2LL(Node root ){
		ArrayList <LinkedList<Node>> results= new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> list;
		int level=0;
		list = new LinkedList<Node>();
		list.add(root);
		results.add(list);
		
		while(true){
			list=results.get(level);
			LinkedList<Node> tempLL=new LinkedList<Node>();
			for (int i=0;i<list.size();i++){
				Node temp=list.get(i);
				System.out.println(temp.data);
				if(temp.left!=null)
					tempLL.add(temp.left);
				if (temp.right!=null)
					tempLL.add(temp.right);					
			}
			if (tempLL.size()>0){
				results.add(tempLL);
				level++;
			}
			else
				break;
		}
		
		return results;
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
			System.out.println(parent.data);
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
}


class TreeLinkedList{

	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(3);
		T.insert(1);
		T.insert(2);
		T.insert(5);
		T.insert(6);
		T.insert(4);
		System.out.println("Inorder");
		T.inorder(T.root);
		Tree2LinkedList TL=new Tree2LinkedList();
		ArrayList<LinkedList<Node>> results=TL.convert2LL(T.root );
		for(int i=0;i<results.size();i++){
			System.out.println("Level="+i);
			LinkedList<Node> temp= results.get(i);			
			for (int j=0;j<temp.size();j++){
				Node temp2=temp.get(j);
				System.out.print(temp2.data+"\t");				
			}
			System.out.println();
		}
		
	}
}