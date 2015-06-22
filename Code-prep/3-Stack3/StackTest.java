

class StackTest extends Stack{
	
	public static void main(String args[]){
		System.out.println("This is stack test");
		Stack S=new Stack ();
		S.push(5);
		S.push(3);
		S.push(2);
		S.printStack();
		S.pop();
		S.printStack();
		S.push(1);
		S.printStack();
	}
}