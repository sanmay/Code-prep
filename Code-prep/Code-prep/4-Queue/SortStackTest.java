


class SortStackTest extends Stack{
	
	static void SortStack(Stack S){
		Stack r=new Stack();
		while(!S.isEmpty()){
			int temp=S.pop();
			while(!r.isEmpty()&&temp>r.peek())
				S.push(r.pop());
			r.push(temp);
			r.printStack();
			S.printStack();
		}
	}
	
	public static void main(String[] args){
		System.out.println("Sorting Stack");
		Stack S=new Stack();
		S.push(5);
		S.push(2);
		S.push(4);
		S.push(3);
		S.push(1);
		S.printStack();
		SortStack(S);
		
	}
}