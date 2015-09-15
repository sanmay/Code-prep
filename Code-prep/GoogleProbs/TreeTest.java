
class TreeTest{
	
	public static void main(String [] args){
		BST B=new BST();
		B.root=new Node(10);
		B.insertL(B.root,5);
		B.insertL(B.root,11);
		B.insertL(B.root,1);
		B.inorderI(B.root);
		System.out.println(B.inorderSucc(B.root,B.root).data);
;	}
	
}