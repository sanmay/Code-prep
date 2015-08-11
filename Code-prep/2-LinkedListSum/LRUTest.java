
import java.util.*;

class Node{
	Node prev,next;
	int data;
	
	Node(int data){
		this.data=data;
		this.prev=null;
		this.next=null;
	}
	
	void print(){
		System.out.print(" "+data);
	}
}

//Doubly Linked list with prev and next pointer
class DLL{
	Node head;
	Node rear;
	int size;
	int init_rear=0;
	
	DLL(){
		head=null;
		rear=null;
		size=0;
	}
	
	Node insert(int data){
		Node temp=new Node(data);
		if(head!=null){
			temp.next=head;
			head.prev=temp;
			
			if(init_rear==0){
					rear=head;
					init_rear=1;
			}
			System.out.println("Insert::Rear="+rear.data+" "+rear.next+" "+rear.prev);
			
		}
		head=temp;
		size++;
		return head;
	}
	
	void delete(){
		if (rear==null)
			System.out.println("Empty List");
		else{
			Node temp=rear;
			System.out.println("Rear="+rear.data+" "+rear.next+" "+rear.prev);
			rear=rear.prev;
			rear.next=null;
			temp.prev=null;
			temp=null;
			size--;
		}
	}
	
	Node getRear(){
		return rear;
	}
	
	void bringItFront(Node temp){
		if(temp.prev!=null)
			temp.prev.next=temp.next;
		if(temp.next!=null){
			temp.next.prev=temp.prev;
			}
		if(temp==rear)
			rear=rear.prev;
		
		temp.next=head;
		temp.prev=null;
		head.prev=temp;
		head=temp;
	}
	
	void print(){
		System.out.println("Size="+size);
		Node temp=head;
		while(temp!=null){
			temp.print();
			temp=temp.next;
		}
	}
	
	int getSize(){
		return size;
	}
}

class LRU{
	int LRU_Size;
	DLL dll;
	HashMap <Integer,Node> map;
	
	LRU(int size){
		LRU_Size=size;
		dll=new DLL();
		map=new HashMap <Integer,Node>();
	}
	
	void insert(int page){
		System.out.println(map.containsKey(page));
		if(map.containsKey(page)){
			Node temp=map.get(page);
			dll.bringItFront(temp);
			
		}else{
			if(dll.getSize()+1>LRU_Size){
				map.remove(dll.getRear().data);
				dll.delete();
			}
			Node temp=dll.insert(page);
			map.put(page,temp);
		}
	}
	
	void print(){
		dll.print();
	}
	

}

class LRUTest{
	public static void main(String[] args){
		LRU lru=new LRU(3);
		lru.insert(1);
		lru.insert(2);
		lru.insert(3);
		lru.insert(1);
		lru.print();
		lru.insert(4);
		lru.insert(1);
		lru.print();
	}
}