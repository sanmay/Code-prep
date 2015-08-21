
class Test{

	public static void main(String[] args){
		LinkedList LL=new LinkedList();
		Node n1=new Node(1);
		LL.insertAfter(null,n1);
		Node n2=new Node(2);
		LL.insertAfter(null,n2);
		LL.print();
		LL.remove(n1);
		LL.print();
	}
}