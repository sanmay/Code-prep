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
	
	Node getHead(){
		return head;
	}
}

class LinkedListSum{

	 static LinkedList Sum(LinkedList L1, LinkedList L2){
		LinkedList Result=new LinkedList();
		int sum,carry=0;
		Node temp1=L1.getHead();
		Node temp2=L2.getHead();
		
		while(temp1!=null && temp2!=null){			
			int result=temp1.data+temp2.data+carry;
			sum=result%10;
			carry=result/10;
			Result.add(sum);
			temp1=temp1.next;
			temp2=temp2.next;			
		}
		if (temp1!=null){
			while(temp1!=null){			
				int result=temp1.data+carry;
				sum=result%10;
				carry=result/10;
				Result.add(sum);
				temp1=temp1.next;						
			} 
		}else{
			while(temp2!=null){			
				int result=temp2.data+carry;
				sum=result%10;
				carry=result/10;
				Result.add(sum);
				temp2=temp2.next;		
			}
		}
		if (carry>0){
			Result.add(carry);
		}
		return Result;
	}
		
		
	
	public static void main (String args[]){
			System.out.println("Linked List Basic Program");
			LinkedList L1=new LinkedList();
			L1.add(5);
			L1.add(3);
			L1.add(2);
			LinkedList L2=new LinkedList();
			L2.add(5);
			L2.add(1);
			
			L1.printList();
			L2.printList();
			LinkedList Result=Sum(L1,L2);
			Result.printList();
			
		} 

}