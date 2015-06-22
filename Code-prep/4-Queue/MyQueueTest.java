
class MyQueue extends Stack{
	Stack S1,S2;
	MyQueue(){
		S1=new Stack();
		S2=new Stack();
	}
	
	void Q(int data){
		
		S1.push(data);
	}
	
	int dQ(){
		System.out.println("Dq");
		if (S2.isEmpty()){
			while (!S1.isEmpty()){
				int temp=S1.pop();
				System.out.println("Temp="+temp);
				S2.push(temp);
			}
		}
		return S2.pop();
	}
	void print(){
		System.out.println("S1=");
		S1.printStack();
		System.out.println("S2=");
		S2.printStack();
	}
}



class MyQueueTest{
	
	public static void main(String args[]){
		System.out.println("MyQueue Implementation");
		MyQueue M=new MyQueue();
		M.Q(5);
		M.print();
		M.Q(3);
		M.Q(1);
		M.print();
		System.out.println(M.dQ());
		M.print();
		System.out.println(M.dQ());
		M.Q(6);
		System.out.println(M.dQ());
		System.out.println(M.dQ());
		
	}
}