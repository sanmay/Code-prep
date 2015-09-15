
import java.util.*;

class MethodsH{
	
	
	int checkParity(int num){
		int cnt=0;
		int mask=1;
		while(num>0){
			cnt=cnt^(num&1);
			num=num>>1;
		}
		return cnt;
	}
	
	
	int swapBit(int num){
		return ((num&0xAAAAAAAA)>>1) | ((num&0x55555555)<<1);
	}
	
	int reverseBit(int num){
		int one=1;
		int zero=0;
		int result=0;
		while(num>0){
			result<<=1;
			if((num&1)==1){
				result|=one;
				//result<<=1;
			}else{
				result|=zero;
				//result<<=1;
			}
			num>>=1;
		}
		return result;
	}
	
	ArrayList<Integer> getPrimes(int n){
		ArrayList<Integer> primes=new ArrayList<Integer> ();
		boolean[] notPrime=new boolean[n+1];
		//notPrime[0]=true;
		//notPrime[1]=true;
		for(int i=2;i<=n;i++){
			if(!notPrime[i]){
				primes.add(i);
				int sum=i;
				while(sum<=n){
					notPrime[sum]=true;
					sum+=i;
				}
			
			}
		}
		return primes;
	}
	
	boolean uniqueChars(String input){
		boolean[] flags=new boolean[26];
	
		input=input.toLowerCase();
		char [] temp=input.toCharArray();
		for(int i=0;i<temp.length;i++){
			if(!flags[temp[i]-'a'])
				flags[temp[i]-'a']=true;
			else
				return false;
		}
		return true;
	}
	
	String reverse(String input){
		int left=0;
		int right=input.length()-1;
		char []temp=input.toCharArray();

		while(left<right){
			//System.out.println(temp[left]+" "+temp[right]);
			char c=temp[left];
			temp[left]=temp[right];
			temp[right]=c;
			//System.out.println("After swap="+temp[left]+" "+temp[right]);
			left++;
			right--;
		}
		return new String(temp);
	}
	
	void reverseString(char[] strArray,int left, int right){
		while(left<right){
			char temp=strArray[left];
			strArray[left]=strArray[right];
			strArray[right]=temp;
			left++;
			right--;
		}
	}


	String reverseWords(String input){
		char [] strArray=input.toCharArray();
		int left=0;
		int right=strArray.length-1;
		reverseString(strArray,left,right);

		for(int i=0;i<strArray.length;i++){
			if(strArray[i]==' '){
				right=i-1;
				reverseString(strArray,left,right);
				left=i+1;
			}
		}
	return new String(strArray);
	}
	
	String removeDuplicates(String input){
		char []temp=input.toCharArray();
	

		for(int k=0;k<temp.length;k++){
			char c=temp[k];
			int cur=k+1;
			for(int i=k+1;i<temp.length;i++){
				if(temp[i]!=c){
					temp[cur]=temp[i];
					temp[i]='\0';
					cur++;
				}
			}
		}
		return new String(temp);
	}
	
	void quickSort(char[] temp,int start,int end){
		if(start>=end)
			return;
		char pivot=temp[start];
		int current=start+1;
		for(int i=start+1;i<=end;i++){
			if(temp[i]<pivot){
				char temp2=temp[i];
				temp[i]=temp[current];
				temp[current]=temp2;
				current++;
			}
		}
		char temp2=temp[start];
		temp[start]=temp[current-1];
		temp[current-1]=temp2;
		quickSort(temp,start,current-2);
		quickSort(temp,current,end);
	}
	
	boolean areAnagrams(String one, String two){
		char[] oneArr=one.toCharArray();
		char[] twoArr=two.toCharArray();
		
		quickSort(oneArr,0,oneArr.length-1);
		quickSort(twoArr,0,twoArr.length-1);
		
		one=new String(oneArr);
		two=new String(twoArr);
		return one.compareTo(two)==0;
	}
	
	void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			System.out.println();
			for(int k=0;k<matrix[0].length;k++){
				System.out.print("\t"+matrix[i][k]);
			}
		}
		System.out.println();
	}
	
	void Rotate(int [][]matrix){
		
		int n=matrix[0].length-1;
		
		for(int i=0;i<=n;i++){
			for(int j=i;j<n-i;j++){
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-j][i];
				matrix[n-j][i]=matrix[n-i][n-j];
				matrix[n-i][n-j]=matrix[j][n-i];
				matrix[j][n-i]=temp;
			}
		}
	}
	
	void printStack(Stack <Integer> S){
		System.out.println();
		Iterator <Integer> itr=S.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	Stack<Integer> sort(Stack <Integer> S){
		System.out.println("Here");
		
		Stack<Integer> Aux=new Stack<Integer> ();
		if(!S.isEmpty())
			Aux.push(S.pop());
		printStack(Aux);
		while(!S.isEmpty()){
			int temp=S.pop();
			while(!Aux.isEmpty() && temp<Aux.peek()){
				S.push(Aux.pop());
			}
			Aux.push(temp);
		}
		return Aux;
	}
	
	
	
	void printCombinations(String result, int left, int right) {
		if(left==0 && right==0)
			System.out.println(result);
		else{
			if(left>0)
				printCombinations(result+"(",left-1,right);
			if(right>left)
				printCombinations(result+")",left,right-1);
		}
	
	
	
	}
	
	int ways2=0;
	int makeChange(String result, int ways3, int sum, int lastCoin){
		if(sum==0){
			System.out.println(result);
			ways2++;
			return 1;
		}
		else if ( sum<0)
			return 0;
		else{
			int ways=0;
			if (sum>=25 && lastCoin>=25)
				ways+=makeChange(result+" 25",ways, sum-25,25);
			if(sum>=10 && lastCoin>=10)
				ways+=makeChange(result+" 10",ways,sum-10,10);
			if(sum>=5 && lastCoin>=5)
				ways+=makeChange(result+" 5",ways, sum-5,5);
			if(sum>=1 && lastCoin>=1)
				ways+=makeChange(result+" 1",ways, sum-1,1);
			return ways;
		}
	} 
	
	void makeCombo(String result, String input, int index){
			System.out.println(result);
			if(index==input.length())
				return;
			else{
				for(int i=index;i<input.length();i++){
					makeCombo(result+input.substring(i,i+1),input,i+1);
				}
			}
	}
	
	String[] getCombo(char c){
		String[] nums;
		switch(c){
			case '0':
				nums=new String[]{"+"};
				break;
			case '2':
				nums=new String[]{"a","b","c"};
				break;
			case '3':
				nums=new String[]{"d","e","f"};
				break;
			case '4':
				nums=new String[]{"g","h","i"};
				break;
			case '5':
				nums=new String[]{"j","k","l"};
				break;
			case '6':
				nums=new String[]{"m","n","o"};
				break;
			case '7':
				nums=new String[]{"p","q","r","s"};
				break;
			case '8':
				nums=new String[]{"t","u","v"};
				break;
			case '9':
				nums=new String[]{"w","x","y","z"};
				break;
			case '1':
				nums=new String[]{""};
				break;
			default:
				nums=new String[]{""};
		}
		return nums;
		
	}
	
	int printTeleCodes(String num, String results){
		//System.out.println(num);
		if(num.length()==0){
			System.out.println(results);
			return 1;
		}
		else{
			//for(int i=0;i<num.length();i++){
				char c=num.charAt(0);
				String[] combo=getCombo(c);
				int ways=0;
				for(int k=0;k<combo.length;k++){
					//System.out.println("SubString="+num.substring(i+1,num.length()));
					ways+=printTeleCodes(num.substring(1,num.length()),results+combo[k]);
				}
				//}
				return ways;
		}
		
	}
	
	void printBoard(int[][] board){
		
		for(int i=0;i<board.length;i++){
			System.out.println();
			for(int k=0;k<board[0].length;k++){
				System.out.print(board[i][k]);
			}
		}
		System.out.println();
	}
	
	boolean check(int[][] board,int row, int col){
		
		for(int i=0;i<row;i++){
			if(board[i][col]==1)
				return false;
		}
		for(int k=0;k<col;k++){
			if(board[row][k]==1)
				return false;
		}
		for(int i=1;i<board.length;i++){
			if(row-i>=0 && col+i<board.length)
				if(board[row-i][col+i]==1)
					return false;
		}
		
		for(int i=1;i<board.length;i++){
			if(row-i>=0 && col-i>=0)
				if(board[row-i][col-i]==1)
					return false;
		}
		return true;
	}
	
	void queens(int[][] board, int queens, int row){
		//System.out.println("Queens="+queens);
		//printBoard(board);
		if(queens>4){
			return;
		}
		else if(queens==4)
			printBoard(board);
		else{
			for(int i=row+1;i<board.length;i++){
				for(int k=0;k<board[0].length;k++){
					board[i][k]=1;
					//System.out.println("For i="+i+" k="+k+" check="+check(board,i,k));
					if(check(board,i,k))
						queens(board,queens+1,i);
					//System.exit(0);
					board[i][k]=0;
				}
			}
			
		}
	}
	
	
	public class StackWithMin extends Stack<Integer>{
		
		Stack <Integer> s2;
		
		StackWithMin(){
			s2=new Stack<Integer>();
		}
		
		public int min(){
			if(s2.isEmpty()){
				return Integer.MAX_VALUE;
			}else{
				return s2.peek();
			}
		}
		
		public void push(int data){
			if(data<min())
				s2.push(data);
			super.push(data);
		}
		
		public Integer pop(){
			int temp=super.pop();
			if(temp==min())
				s2.pop();
			return temp;
				
		}
		
	}
	
	
	String getChar(String input){
		
		if (input==null)
			return null;
		int num=Integer.parseInt(input);
		if(num>26 || num<=0)
			return null;
		else{
			int temp=num+(int)'a'-1;
			char temp_c=(char)temp;
			return Character.toString(temp_c);
		}
	}
	
	void printNumToStringCombo(String input, String result){
		
		if(input.length()==0){
			System.out.println(result);
		}else{
			for(int i=1;i<=input.length();i++){
				String cur=input.substring(0,i);
				String rem=input.substring(i,input.length());
				String res=getChar(cur);
				//System.out.println("cur="+cur+" res="+res);
				if(res!=null)
					printNumToStringCombo(rem,result+res);
				
			}
		}
	}
	
	static int num=0;
	void testStatic(){
		//int num=0;
		System.out.println(num);
		num++;
	}
}


class Median{
	Comparator <Integer> min_cmp, max_cmp;
	PriorityQueue <Integer> min_pq, max_pq;

	Median(){
		min_cmp=new Comparator <Integer>(){
			public int compare(Integer x, Integer y){
				return x-y;
			}
		};

		max_cmp=new Comparator <Integer>(){
			public int compare (Integer x, Integer y){
				return y-x;
			}
		};
		min_pq=new PriorityQueue<Integer>(min_cmp);
		max_pq=new PriorityQueue<Integer>(max_cmp);
	
	}
	int getMedian(int num){
		if(max_pq.size()==0)
			max_pq.add(num);
		else{
			if(num<max_pq.peek())
				max_pq.add(num);
			else
				min_pq.add(num);
		}

		if(max_pq.size()>min_pq.size()+1)
			min_pq.add(max_pq.remove());
		else if(min_pq.size()>max_pq.size())
			max_pq.add(min_pq.remove());

		return max_pq.peek();
	}
	
}




class MethodsTest{
	
	public static void main(String[] args){
		
		
		MethodsH m=new MethodsH();
		m.testStatic();
		m.testStatic();
		
	}
}