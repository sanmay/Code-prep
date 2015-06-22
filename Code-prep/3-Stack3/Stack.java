



class Stack{
	
	int top;
	int stack_array[];
	Stack(){
		stack_array=new int[10];
		top=0;
	}
	
	void push(int data){
		stack_array[top++]=data;
	}
	
	int pop(){
		if (!isEmpty())
			return stack_array[top--];
		return -1;
	}
	int peek(){
		return stack_array[top-1];
	}
	boolean isEmpty(){
		if (top==0)
			return true;
		return false;
	}
	
	void printStack(){
		System.out.println("Printing Stack");
		for(int i=0;i<top;i++){
			System.out.println(stack_array[i]);
		}
	}
}