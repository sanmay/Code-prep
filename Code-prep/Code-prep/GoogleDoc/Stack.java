//Stack using linked list
// Methods- void push(int data), int pop() //optional print()
//Members- Node head, int size; Auxiliary ds- node 

class Node{
	int data;
	Node next;
	Node (int data){
	this.data=data;
	this.next=null;
}
void print(){
	System.out.println(data);
}
}

class Stack{
	int size;
	Node head;

	Stack(){
	this.head=null;
	size=0;
}

void push (int data){
	Node temp=head;
	head=new Node(data);
	head.next=temp;
	size++;
}

Node pop(){
	if(head==null){
	System.out.println("Empty Stack");
	return null;
}else{
	Node temp=head;
	head=head.next;
size--;
	return temp;
}
}

void print(){
	Node temp=head;
	while(temp!=null){
	temp.print();
	temp=temp.next;
}
}
}
