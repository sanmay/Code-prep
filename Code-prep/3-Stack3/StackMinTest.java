

class StackMin extends Stack{
	
	Stack S=new Stack();
	Stack min=new Stack();
	void push(int data){
		S.push(data);
		if (min.isEmpty()){
			min.push(data);
		}
		else if(data<min.peek()){
			min.push(data);
		}
	}
	
	int pop(){
		int temp=S.pop();
		if (temp==min.peek())
			min.pop();
		return temp;
	}
	
	int min(){
		System.out.println("Min is=");
		return min.peek();
	}
	void print(){
		System.out.println("Normal Stack");
		S.printStack();
		System.out.println("Min Stack");
		min.printStack();
	}
	
	
}

class StackMinTest{
	
	public static void main(String args[]){
		StackMin S=new StackMin();
		S.push(5);
		System.out.println(S.min());
		S.print();
		S.push(4);
		System.out.println(S.min());
		S.push(6);
		System.out.println(S.min());
		S.push(1);
		System.out.println(S.min());
		S.pop();
		System.out.println(S.min());
		S.print();
		
	}
}