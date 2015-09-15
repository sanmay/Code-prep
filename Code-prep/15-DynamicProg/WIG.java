
class WIG{
	 
	int max(int a, int b){
		return a>b?a:b;
	}	
	int findMax(int[] input){
		int []a=new int[input.length];
		
		a[0]=input[0];
		
		for(int i=1;i<input.length;i++){
			
			int cur;
			if(i-2>=0)
				cur=a[i-2]+input[i];
			else
				cur=input[i];
			a[i]=max(cur,a[i-1]);
		}
		return a[input.length-1];
	}
	
	int min(int a, int b){
		return a<b?a:b;
	}
	void print(int[][]input){
		for (int i=0;i<input.length;i++){
			System.out.println();
			for(int k=0;k<input[0].length;k++){
				System.out.print(input[i][k]+"\t");
			}
			System.out.println();
		}
	}
	int changeCoin(int[] input, int sum){
		int a[][]=new int[sum+1][input.length+1];
		
		for(int k=0;k<sum+1;k++){
			a[k][0]=Integer.MAX_VALUE;
		}
		for(int k=0;k<input.length+1;k++){
			a[0][k]=0;
		}
		for(int k=1;k<=input.length;k++){
			for(int i=1;i<=sum;i++){
				int cur;
				if(i-input[k-1]>=0)
					cur=1+a[i-input[k-1]][k];
				else
					cur=Integer.MAX_VALUE;
				a[i][k]=min(a[i][k-1],cur);
			}
		}
		print(a);
		return a[sum][input.length];
	}
	
	
}

class LinkedListSP{
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int data){
			this.data=data;
			next=null;
			prev=null;
		}
		
		void print(){
			System.out.println("data="+data+" prev="+prev+" next="+next);
		}
	}
	
	Node head;
	Node tail;

	LinkedListSP(){
		head=null;
		tail=null;
	}

	void insert(int data){
		while(tail!=null && data<tail.data){
			Node prev=tail;
			tail=tail.next;
			prev.next=null;
		}
		Node n=new Node(data);
		if(tail==null)
			head=n;
		n.next=tail;
		if(tail!=null)
			tail.prev=n;
		tail=n;

	
	}

	int get(){
		if(head==null)
			return -1;
		else{
			Node temp=head;
			head=head.prev;
			if(head!=null)
				head.next=null;
			else
				tail=null;
			temp.prev=null;
			return temp.data;
		}
	}
	
	void print(){
		Node temp=head;
		while(temp!=null){
			temp.print();
			temp=temp.prev;
		}
	}
}


