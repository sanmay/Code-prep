class DPTest{
	
	static boolean closedExpression(char[] input){
		int cnt=0;
		for(int i=0;i<input.length;i++){
			if(input[i]=='(')
				cnt++;
			else if(input[i]==')'){
				if(cnt==0)
					return false;
				else
					cnt--;
			}
		}
		return cnt==0;
	}
	
	public static void main(String[] args){
		WIG w=new WIG();
		String input="";
		
		LinkedListSP lsp=new LinkedListSP();
			lsp.insert(1);
			lsp.insert(5);
			lsp.insert(2);
			lsp.print();
			System.out.println(lsp.get());
			System.out.println(lsp.get());
			lsp.print();
			lsp.insert(10);
			lsp.insert(15);
			System.out.println(lsp.get());
			lsp.print();
			lsp.insert(1);
			lsp.print();
			System.out.println(lsp.get());
		}
	
		
}