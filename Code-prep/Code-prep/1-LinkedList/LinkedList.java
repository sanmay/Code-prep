class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}


class LinkedList{
	Node head;
	
	public LinkedList(){
		head=null;
	}
	
	void add(int data){
		Node n=new Node(data);
		Node temp;
		temp=head;
		if (head==null){
			head=n;
		}
		else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
	void printList(){
		System.out.println("Printing LinkedList");
		Node temp;
		temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main (String args[]){
		System.out.println("Linked List Basic Program");
		LinkedList L=new LinkedList();
		L.add(5);
		L.add(3);
		L.add(2);
		L.printList();
		
	} 
}