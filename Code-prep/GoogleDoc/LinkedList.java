class Node{
	int data;
	Node next;
	Node(int data){
	this.data=data;
	next=null;
}
void print(){
	System.out.println(data);
}
}

class LinkedList{
	Node head;
	Node tail;

	LinkedList(){
		head=null;
		tail=null;
}

boolean insertAfter(Node n, Node temp){
	if (n==null){
		Node temp2=head;
		head=temp;
		head.next=temp2;
		if(tail==null)
			tail=temp;
	return true;
	}else{
		Node temp2=head;
		while(temp2!=null){
			if(temp2.data==n.data){
				Node temp3=temp2.next;
				temp2.next=temp;
				temp.next=temp3;
				if(temp2==tail)
					tail=temp;
				return true;
			}
			temp2=temp2.next;
		}
}
	return false;
}

boolean remove(Node n){
	Node temp=head;
	Node prev=null;
while(temp!=null){
	if(temp.data==n.data){
if(temp==head)
	head=temp.next;
if(temp==tail)
	tail=prev;
	if(prev!=null){
	prev.next=temp.next;
	}
temp.next=null;
return true;
}
prev=temp;
temp=temp.next;

}
return false;
}

void print(){
	Node temp=head;
	System.out.println("Head="+head.data);
	System.out.println("Tail="+tail.data);
	while(temp!=null){
		temp.print();
		temp=temp.next;
	}
}
}
