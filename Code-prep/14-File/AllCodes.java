class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}


class LinkedList{
	Node head;
	
	public LinkedList(){
		head=null;
	}
	
	void add(int data){
		Node n=new Node(data);
		Node temp;
		temp=head;
		if (head==null){
			head=n;
		}
		else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
	void printList(){
		System.out.println("Printing LinkedList");
		Node temp;
		temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main (String args[]){
		System.out.println("Linked List Basic Program");
		LinkedList L=new LinkedList();
		L.add(5);
		L.add(3);
		L.add(2);
		L.printList();
		
	} 
}
% First Program


class BST{
	private Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key=key;
		}
	}
	
	
	Node put(int key, Node x){
		if (x==null){
			return Node(key);
		}else{
			if(key==x.key)
				return x;
			else if(key<x.key)
				x.left=put(key,x.left);
			else
				x.right=put(key,x.right);
		}
	}
	
	Node put(int key){
		return put(key,root);
	}

}

class ReadFile{

}

class ReadFileTest{
	public static void main(String [] args){
		System.out.println("This operation deals with basics of file handerling");
	}
}

import java.util.*;

class Node{
	int data;
	String val;
	
	Node(int data, String val){
		this.data=data;
		this.val=val;
		//System.out.println(val);
	}
	
	void print(){
		System.out.println("Data="+this.data+" val="+this.val);
	}
}

class HashTable{
	//datatypes
	//ArrayList table, table size, hashKey1, hashOffset
	Node HT[];
	int tableSize;
	int hashKey;
	int hashOffset;
	
	//constructor with HT size
	HashTable(int size, int hashKey, int hashOffset){
		HT=new Node[size];
		this.tableSize=size;
		this.hashKey=hashKey;
		this.hashOffset=hashOffset;
	}
	
	
	//depend on hashcode, size
	int getHashCode(String val){
		char s[]=val.toCharArray();
		int key=0;
		for(int i=0;i<s.length;i++)
			key+=s[i];
		return (hashKey*key)%tableSize;
	}
	
	//method to put key and val
	void put(int key, Node val){
		int loc=getHashCode(val.val);
		System.out.println(loc);
		while(HT[loc]!=null){
				loc=loc+hashOffset;
				if(loc>=tableSize)
					loc=loc-tableSize;
		}
		HT[loc]=val;		
	}
	
	//method to get key
	Node get(String val){
		int loc=getHashCode(val);
		//System.out.println(HT[loc].val+val);
		while(HT[loc]!=null && HT[loc].val!=val){
				loc=loc+hashOffset;
				System.out.println(loc);
				if(loc>=tableSize)
					loc=loc-tableSize;
		}
		return HT[loc];
	}
	
	//method to print hashtable
	void print(){
		System.out.println("Printing hashtable");
		for(int i=0;i<tableSize;i++){
			if(HT[i]!=null)
				HT[i].print();
		}
	}
}

class HashTableUtil{
	public static void main(String[] args){
		System.out.println("HashTable util");
		HashTable HT=new HashTable(20,31,5);
		HT.put(1,new Node(1,"Sanmay"));
		HT.print();
		HT.put(4,new Node(4,"akki"));
		HT.put(3,new Node(3,"raja"));
		HT.put(10,new Node(10,"chama"));
		HT.print();
		if(HT.get("Sanmay")!=null)
			HT.get("Sanmay").print();
		else
			System.out.println("Record does not exist");
	}

}


//Datastructure to hold information
class Node{
	String name;
	int marks;
	
	Node(String name, int marks){
		this.name=name;
		this.marks=marks;
	}
	
	void print(){
		System.out.println("Name="+name+" marks="+marks);
	}
}

//HT takes string as key and stores node as value 
//Implemented using linear probing 
class HTT{
//Private table to store HT data- array of data types
//Private variable to store table size
//primary hashcode
//secondary hashcode
Node [] table;
int tableSize;
int hashCode;
int hashOffset;

HTT(int size,int hashCode, int hashOffset){
	this.tableSize=size;
	this.hashCode=hashCode;
	this.hashOffset=hashOffset;
	table=new Node[tableSize];
}

int hashCode(String name){
	char s[]=name.toCharArray();
	int sum=0;
	for(int i=0;i<s.length;i++){
		sum+=s[i];
	}
	return sum*hashCode;
}
//Method to insert key value
void put(String name, Node temp){
	//corner case
	if (name==null)
		System.out.println("Error msg");
	else{
		//hashcode function ot get location in table mode by size
		int n=hashCode(name);
		n=n%tableSize;
		if(table[n]==null || table[n].name==name){
			table[n]=temp;
		}else{
			while(table[n]!=null){
				n=n+hashOffset;
				if (n>tableSize)
					n=tableSize-n;
			}
			table[n]=temp;
		}
	}

}

//method to get value

Node get(String key){
	if (key==null){
		System.out.println("Error msg");
		return null;
		}
	else{
		//hashcode function ot get location in table mode by size
		int n=hashCode(key);
		n=n%tableSize;
		while(table[n]!=null && table[n].name!=key){
			n=n+hashOffset;
			if (n>tableSize)
				n=tableSize-n;
		}
	return table[n];
}
}

void print(){
	System.out.println("New HashTable");
	for(int i=0;i<tableSize;i++){
		if(table[i]!=null){
			table[i].print();
		}
	}

}

}


class HT{
public static void main(String[] args){
		HTT hashTable=new HTT(20,31,5);
		hashTable.put("Sanmay",new Node("Sanmay",10));
		hashTable.print();
		hashTable.put("Akki",new Node("Akki",10));
		hashTable.print();
		hashTable.put("Sanmay",new Node("Sanmay",10));
		hashTable.print();
		hashTable.get("Akki").print();
	}
}
import java.lang.Math;
class BitTest{
	
	static String getBinary(int a, int bits){
		if(bits==1){
			if(a==1)
				return "1";
			else
				return "0";
		}
		else{
			System.out.println(Math.pow(2,bits-1));
			if(a>=Math.pow(2,bits-1)){
				a=a-(int)Math.pow(2,bits-1);
				return "1"+getBinary(a,bits-1);
			}
			else{
				return "0"+getBinary(a,bits-1);
			}
		}
	}
	
	static boolean getBit(int n, int bit){
		return ((n>>bit)&1)==1;
	}
	
	static boolean isPalindrome(int n){
		
		int cnt=31;
		
		while(cnt>=0){
			if(getBit(n,cnt))
				System.out.print('1');
			else
				System.out.print('0');
			cnt--;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		
		isPalindrome(15);
		
	}
}
import java.io.*;
import java.util.*;



class Files{
	String output="AllCodes.java";
	PrintWriter out;
	int cnt=0;
	Files() throws IOException{ 
		out=new PrintWriter(new BufferedWriter(new FileWriter(output)));
	}
	void ListFiles (String input) throws IOException{
		File f=new File(input);
		if(f.isFile()){
			if(f.getName().contains(".java") || f.getName().contains(".py")){
				System.out.println(f.getAbsolutePath());
				BufferedReader in=new BufferedReader(new FileReader(f.getAbsolutePath()));
				String s;
				while((s=in.readLine())!=null){
					cnt++;
					out.println(s);
				}
		}
		}else{
			String list[]=f.list();
			for(String s:list){
				ListFiles(input+'/'+s);
			}
		}
		
	}
	
}


class FileTest{
	
	
	public static void main(String[] args){
		Files f;
		try{
			f=new Files();
			f.ListFiles("/Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep");
			f.out.close();
			System.out.println(f.cnt);
		}catch(IOException e){
		System.err.println("Not able to open files");
		}
		
		
	}
}
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


class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}


class LinkedList{
	Node head;
	
	public LinkedList(){
		head=null;
	}
	
	void add(int data){
		Node n=new Node(data);
		Node temp;
		temp=head;
		if (head==null){
			head=n;
		}
		else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
	void printList(){
		System.out.println("Printing LinkedList");
		Node temp;
		temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	Node getHead(){
		return head;
	}
}

class LinkedListSum{

	 static LinkedList Sum(LinkedList L1, LinkedList L2){
		LinkedList Result=new LinkedList();
		int sum,carry=0;
		Node temp1=L1.getHead();
		Node temp2=L2.getHead();
		
		while(temp1!=null && temp2!=null){			
			int result=temp1.data+temp2.data+carry;
			sum=result%10;
			carry=result/10;
			Result.add(sum);
			temp1=temp1.next;
			temp2=temp2.next;			
		}
		if (temp1!=null){
			while(temp1!=null){			
				int result=temp1.data+carry;
				sum=result%10;
				carry=result/10;
				Result.add(sum);
				temp1=temp1.next;						
			} 
		}else{
			while(temp2!=null){			
				int result=temp2.data+carry;
				sum=result%10;
				carry=result/10;
				Result.add(sum);
				temp2=temp2.next;		
			}
		}
		if (carry>0){
			Result.add(carry);
		}
		return Result;
	}
		
		
	
	public static void main (String args[]){
			System.out.println("Linked List Basic Program");
			LinkedList L1=new LinkedList();
			L1.add(5);
			L1.add(3);
			L1.add(2);
			LinkedList L2=new LinkedList();
			L2.add(5);
			L2.add(1);
			
			L1.printList();
			L2.printList();
			LinkedList Result=Sum(L1,L2);
			Result.printList();
			
		} 

}

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


class StackMin extends Stack{
	
	Stack S=new Stack();
	void push(int data){
		
	}
	
	public static void main(String args[]){
		
	}
}


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
			return stack_array[--top];
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
		System.out.println("Done Printing");
	}
}
public class ABBADiv1{
    static boolean canObtainUtil(String initial, String target){
        System.out.println(initial+" "+target);
       // System.out.println("\n");
    	if(initial.length()>target.length())
            return false;
        else if(initial.compareTo(target)==0){
            System.out.println("true="+initial);
            return true;
            }
        else{
           	return canObtainUtil(initial+"A",target) || canObtainUtil(new StringBuilder(initial+"B").reverse().toString(),target);
            
        }
    }
    public static String canObtain(String initial, String target){
    	if(canObtainUtil(initial,target))
           return "POSSIBLE";
        else
            return "IMPOSSIBLE";
           
           
    }
	
	public static void main(String[] args){
		
		System.out.println(canObtain("A","BABA"));
	}
}


class FibTest{
	
	static int Fib(int n){
		if (n==0)
			return 0;
		else if (n==1)
			return 1;
		else
			return Fib(n-1)+Fib(n-2);
	}
	
	public static void main(String[] args){
		System.out.println(Fib(6));
	}
}

class money{
	
	static void getways(int amt,String ways, int lastC){
		if (amt<=0){
			System.out.println("Final="+ways);
			return;
		}
		else{
			if(amt>=25 && lastC>=25){
				getways(amt-25,ways+Integer.toString(25)+",",25);
			}
			if(amt>=10 && lastC>=10){
				getways(amt-10,ways+Integer.toString(10)+",",10);
			}
			if(amt>=5 && lastC>=5){
				getways(amt-5,ways+Integer.toString(5)+",",5);
			}
			if(amt>=1 && lastC>=1){
				getways(amt-1,ways+Integer.toString(1)+",",1);
			}
		}
		
	}
	
	public static void main(String []args){
		System.out.println("This shows ways to add up to money");
		String ways="";
		getways(10,ways,10);
	}
}
class Nsteps{

	static void Calculate_steps(int steps, String ans){
		if (steps<0)
			return;
		else if (steps<=0)
			System.out.println(ans);
		else{
			String temp=ans+" "+"1";
			Calculate_steps(steps-1,temp);
			temp=ans+" "+"2";
			Calculate_steps(steps-2,temp);
		}
	}

public static void main(String [] args){
	
	String ans="";
	Calculate_steps(4,ans);
}

}

import java.util.*;

class paranthesis{
	static int glob=0;
	static ArrayList <String> getCombo(String temp,int left, int right){
		glob=glob+1;
		
		ArrayList <String> results=new ArrayList<String>();
		ArrayList <String> tempresults;
		if (left==0 && right==0){
			System.out.println("Final="+temp);			
			results.add(temp);
			return results;
		}else{
						
			if (left>0){
				left=left-1;
				System.out.println("left");
				temp=temp+"(";
				System.out.println("left="+left+" right="+right);
				System.out.println(temp);
				tempresults=getCombo(temp,left,right);
				for (int i=0;i<tempresults.size();i++){
					results.add(tempresults.get(i));
				}
			}
			
			if (right>left){
				right=right-1;
				System.out.println("right");
				temp=temp+")";
				System.out.println("left="+left+" right="+right);
				System.out.println(temp);
				tempresults=getCombo(temp,left,right);
				for (int i=0;i<tempresults.size();i++){
					results.add(tempresults.get(i));
				}
			}
			
		}
		return results;
	}
	
	public static void main(String[] args){
		System.out.println("Recursive algorithm to print pair of paranthesis");
		ArrayList <String> results;
		String temp="";
		results=getCombo(temp,2,2);
		System.out.println(results);
		
	}
}





class Queens{
	
	static void print(int chessboard[][]){
		for (int w=0;w<chessboard.length;w++){
			System.out.println();
			for (int v=0;v<chessboard.length;v++){
				System.out.print(chessboard[w][v]);
			}
		}
	}
	
	static void getWays(int chessboard[][],int queens,String result){
		//String result="";
		if (queens==0){
			System.out.println("Final="+result);
			return;
		}
		else{
				for (int i=0;i<chessboard.length;i++){
				for (int j=0;j<chessboard.length;j++){
					if(queens==2){
						for (int w=0;w<chessboard.length;w++){
							for (int v=0;v<chessboard.length;v++){
								result="";
								chessboard[w][v]=0;
							}
						}
					}
					if(chessboard[i][j]==0){
						for (int y=0;y<chessboard.length;y++){
							chessboard[i][y]=1;
							chessboard[y][j]=1;
							if(i+y<3 && j+y<3)
								chessboard[i+y][j+y]=1;
							if(i-y>-1 && j-y>-1)
								chessboard[i-y][j-y]=1;
							if(i+y<3 && j-y>-1)
								chessboard[i+y][j-y]=1;
							if(i-y>-1 && j+y<3)
								chessboard[i-y][j+y]=1;
						}
						result=result+"("+Integer.toString(i)+" "+Integer.toString(j)+"),";
						//System.out.println("Intermediate="+result+"Queen="+queens);
						//print(chessboard);
						getWays(chessboard,queens-1,result);
							
					}
				}
			}
		
		}
		return;
	}
	
	public static void main(String[] args){
		int chessboard[][]=new int[3][3];
		int queens=2;
		System.out.println("Method gives ways to arrange queens so they wont kill each other :P");
		for (int i=0;i<chessboard.length;i++){
			for (int j=0;j<chessboard.length;j++){
				chessboard[i][j]=0;
			}
		}
		String result="";
		getWays(chessboard,queens,result);
	}
}
import java.util.ArrayList;

class StringPerm{
	
		
		static ArrayList <String> addChar(String input, String ch){
			ArrayList <String> results=new ArrayList <String>();
			
			for (int i=0;i<=input.length();i++){
				String temp=input.substring(0,i)+ch+input.substring(i,input.length());
				results.add(temp);
			}
			return results;
		}
		static ArrayList <String> getPerm(ArrayList <String> input){
			ArrayList <String> results=new ArrayList <String>();
			ArrayList <String> tempresults=new ArrayList <String>();
			ArrayList <String> finalresults=new ArrayList <String>();
			if (input.size()==1)
				return input;
			else{
				String tempChar=input.remove(0);
				System.out.println(input);
				results=getPerm(input);				
				for (int i=0;i<results.size();i++){
					System.out.println(tempChar);
					System.out.println(results.get(i));		
					tempresults=addChar(results.get(i),tempChar);
					for (int j=0;j<tempresults.size();j++)
						finalresults.add(tempresults.get(j));
					System.out.println(tempresults);
				}
			
			}
			return finalresults;
		}
	
	public static void main(String[] args){
		System.out.println("String Permutation");
		ArrayList <String> input=new ArrayList <String>();
		ArrayList <String> output=new ArrayList <String>();
		input.add("P");
		input.add("U");
		input.add("N");
		input.add("E");
		output=getPerm(input);
		System.out.println("Final");
		System.out.println(output);
	}
}

class FindElementTests{
	int idx=0;
	int getIndex(int[] input,int element, int start, int end){
		idx++;
		int middle=(start+end)/2;
		System.out.println("middle"+middle+" start="+start+" end="+end+" element="+element);
		if (idx>=10)
			return start;
		if (input[middle]==element)
			return middle;
		else{
			if (element<input[middle]){
				if (element>=input[start]){
					return getIndex(input,element, start, middle-1);
				}else{
					return getIndex(input,element, middle+1, end);
				}
			}else{
				if (element>input[end]){
					return getIndex(input,element, start, middle-1);
				}else{
					return getIndex(input,element, middle+1, end);
				}
			}
		}
	}
}

class FindElements{

	public static void main(String[] args){
		int [] input={6,7,8,9,10,1,2,3,4,5};
		FindElementTests F=new FindElementTests();
		System.out.println(F.getIndex(input,6,0,input.length-1));
	}

}
import java.util.*;

class MergeSortTest{

static ArrayList<Integer> MergeSort(ArrayList <Integer> input, int start, int end){
		ArrayList <Integer> output=new ArrayList <Integer> ();
		if(start==end){
			output.add(input.get(start));
			return output;
		}
		else{
			int middle=(start+end)/2;
			ArrayList <Integer> output1=MergeSort(input,start,middle);
			ArrayList <Integer> output2=MergeSort(input,middle+1,end);
			int idx1=0,idx2=0;
			while(idx1<output1.size() && idx2<output2.size()){
				if (output1.get(idx1)<output2.get(idx2))
					output.add(output1.get(idx1++));
				else{
					output.add(output2.get(idx2++));
				}
			}
			while(idx1<output1.size()){
				output.add(output1.get(idx1++));
			}
			while(idx2<output2.size()){
				output.add(output2.get(idx2++));
			}
		}
		return output;
	}

public static void main(String[] args){
		
		ArrayList <Integer> input=new ArrayList <Integer>();
		input.add(3);
		input.add(2);
		input.add(5);
		input.add(1);
		input.add(0);
		System.out.println(MergeSort(input,0,input.size()-1));

	}
}

class QuickSortTest{

	static void print(int input[]){
		System.out.println();
		for (int i=0;i<input.length;i++){
			System.out.print(input[i]);
		}
	}
	static void QuickSort(int input[],int start, int end){
		if (start>=end){
			return;
		}
		else{
			int pivot=start;
			System.out.println("pivot="+input[pivot]);
			int sw=start+1;
			int iter=start+1;
			int temp;
			
			for(int i=iter;i<=end;i++){
			//System.out.println("iter="+input[i]);
				if(input[i]<input[pivot]){
					temp=input[sw];
					input[sw]=input[i];
					input[i]=temp;
					sw++;
				}
				//System.out.println("afteriter="+input[i]);
				
			}
			temp=input[pivot];
			input[pivot]=input[sw-1];
			input[sw-1]=temp;
			print(input);
			System.out.println("start="+start+" end="+sw);
			QuickSort(input,start,sw-2);
			System.out.println("start2="+sw+" end2="+end);
			QuickSort(input,sw,end);
		}
		
		
	}
	public static void main (String[] args){
		int input[]={3,2,6,4,1,5,0};
		QuickSort(input,0,6);
		System.out.println(input[0]);
	} 
}


class Heap{
	int input[];
	int end;
	
	Heap(){
		input=new int[10];
		end=0;
	}
	
	void insert(int data){
		input[end]=data;
		int i=end;
		end++;
		while(input[i]<input[i/2]){
			int temp=input[i];
			input[i]=input[i/2];
			input[i/2]=temp;
			i=i/2;
		}
	}
	
	int ExtractMin(){
		int min=input[0];
		input[0]=input[end-1];
		end=end-1;
		int j=0;
		
		while(j*2+1<end){
			int flag=0;
			if (input[j]>input[j*2]){
				int temp=input[j];
				input[j]=input[j*2];
				input[j*2]=temp;
				j=j*2;
				flag=1;
			}else{
				int temp=input[j];
				input[j]=input[j*2+1];
				input[j*2+1]=temp;
				j=j*2+1;
				flag=1;
			}
			if (flag==0){
				break;
			}
			
		}
		return min;
	}
	
	void print(){
		System.out.println();
		System.out.println("Printing the heap");
		
		for (int i=0;i<end;i++){
			
			System.out.print("\t"+input[i]);
			
		}
	}
}

class HeapTest {
	public static void main(String[] args){
		
		System.out.println("This is heap test");
		Heap h=new Heap();
		h.insert(2);
		h.print();
		h.insert(1);
		h.print();
		h.insert(4);
		h.insert(5);
		h.insert(0);
		h.print();
		System.out.println("Min="+h.ExtractMin());
		h.print();
		System.out.println("Min="+h.ExtractMin());
		h.print();
	}
}

class Pair{
	public int data;
	public int idx;
	Pair(int data,int idx){
		this.data=data;
		this.idx=idx;
	}
}

class Heap{
	Pair input[];
	int end;
	
	Heap(){
		input=new Pair[10];
		end=0;
	}
	
	void insert(int data,int idx){
		
		Pair temp=new Pair(data,idx);
		input[end]=temp;
		int i=end;
		end++;
		while(input[i].data<input[i/2].data){
			temp=input[i];
			input[i]=input[i/2];
			input[i/2]=temp;
			i=i/2;
		}
	}
	
	/*void insert(int data){
		input[end]=data;
		int i=end;
		end++;
		while(input[i]<input[i/2]){
			int temp=input[i];
			input[i]=input[i/2];
			input[i/2]=temp;
			i=i/2;
		}
	}*/
	
	Pair Pop(){
		Pair min=input[0];
		input[0]=input[end-1];
		end=end-1;
		int j=0;
		
		while(j*2+1<end){
			int flag=0;
			if (input[j].data>input[j*2].data){
				Pair temp=input[j];
				input[j]=input[j*2];
				input[j*2]=temp;
				j=j*2;
				flag=1;
			}else{
				Pair temp=input[j];
				input[j]=input[j*2+1];
				input[j*2+1]=temp;
				j=j*2+1;
				flag=1;
			}
			if (flag==0){
				break;
			}
			
		}
		return min;
	}
	void print(){
		System.out.println();
		System.out.println("Printing the heap");
		
		for (int i=0;i<end;i++){
			
			System.out.print("\n"+input[i].data+"\t"+input[i].idx);
			
		}
	}
	
	boolean isEmpty(){
		if (end==0){
			return true;
		}
		return false;
	}
}


class KMergeTest {
	public static void main(String[] args){
		
		System.out.println("This is K-Merge using heap");
		int input[][]={{1,3,5,7},{0,2,6},{4,9,11}};
		int output[]=new int[10];
		
		//insert one elements from each array in min heap
		int idx[]=new int[3];
		Heap h=new Heap();
		
		for (int i=0;i<input.length;i++){
			h.insert(input[i][0],i);
			idx[i]=1;
		}
		
		int k=0;
		while(!h.isEmpty()){
			Pair temp=h.Pop();
			output[k++]=temp.data;
			System.out.println(output[k-1]);
			
			if(idx[temp.idx]<input[temp.idx].length){
				h.insert(input[temp.idx][idx[temp.idx]],temp.idx);
				idx[temp.idx]++;
			}
		}
		
			
	}
}

class BalanceTree{
	
	
	static int minHeight(Node parent){
		if (parent==null)
			return 0;
		else 
			if (minHeight(parent.left)<minHeight(parent.right))
				return 1+minHeight(parent.left);
			else
				return 1+minHeight(parent.right);
	}
	
	static int maxHeight(Node parent){
		if (parent==null)
			return 0;
		else 
			if (maxHeight(parent.left)>maxHeight(parent.right))
				return 1+maxHeight(parent.left);
			else
				return 1+maxHeight(parent.right);
	}
	
	static boolean isBalanced(Node root){
		System.out.println("max="+maxHeight(root));
		System.out.println("min="+minHeight(root));
		return maxHeight(root)-minHeight(root)<2;
	}
	
	public static void main(String[] args){
		
		System.out.println("This method outputs whether tree is balanced or not");
		
		Tree T= new Tree();
		T.insert(5);
		T.insert(3);
		T.insert(2);
		T.insert(1);
		T.insert(6);
		T.insert(7);
		System.out.println("Inorder");
		T.inorder(T.root);
		System.out.println(isBalanced(T.root));
		
	}
}

import java.util.*;

class Node{
		int data;
		public Node left, right, parent;
		
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			parent=null;
		}
		
}

class CommonAncester{
	
	
	static Node LCA(Node n, int a, int b){
		if(n==null)
			return null;
		else if (n.data==a || n.data==b){
			return n;
		}
		else{
			Node left=LCA(n.left,a,b);
			Node right=LCA(n.right,a,b);
			
			if(left!=null&&right!=null)
				return n;
			else{
				if(left!=null)
					return left;
				else
					return right;
			}
		}
		
	}
	
	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(3);
		T.insert(1);
		T.insert(2);
		T.insert(5);
		T.insert(6);
		T.insert(4);
		System.out.println("Inorder");
		T.inorder(T.root);
		
		CommonAncester CA=new CommonAncester();
		Node temp=CA.LCA(T.root,3,1);
		System.out.println("Ancestor="+temp.data);
	}
}




class Tree{
	
	
	public Node root;
	
	Tree(){
		root=null;
	}
	
	void recurse(Node parent, Node temp){
		if (temp.data<=parent.data){
			if (parent.left==null){
				parent.left=temp;
				temp.parent=parent;
			}else{
				recurse(parent.left,temp);
			}
		}else{
			if (parent.right==null){
				parent.right=temp;
				temp.parent=parent;
			}else{
				recurse(parent.right,temp);
			}
		}
	}
	
	void insert(int data){
		Node temp=new Node(data);
		if (root==null){
			root=temp;
		}
		else{
			recurse(root,temp);
		}
	}
	
	void inorder(Node parent){
		if (parent==null)
			return;
		else{
			inorder(parent.left);
			System.out.println(parent.data);
			inorder(parent.right);
		}
	}

	void preorder(Node parent){
		if (parent==null)
			return;
		else{
			System.out.println(parent.data);
			preorder(parent.left);			
			preorder(parent.right);
		}
	}
	
	void postorder(Node parent){
		if (parent==null)
			return;
		else{
			postorder(parent.left);			
			postorder(parent.right);
			System.out.println(parent.data);
		}
	}	
	
	int min(Node temp){
		if (temp.left==null)
			return temp.data;
		else
			return min(temp.left);
	}
	
	int max(Node temp){
		if (temp.right==null)
			return temp.data;
		else
			return max(temp.right);
	}
	
	Node find(int data, Node temp){
		if (temp==null){
			return null;
		}
		else if (temp.data==data)
			return temp;
		else{
			if (data<temp.data)
				return find(data,temp.left);
			else	
				return find(data,temp.right);
		}
	}
	
	int predec(int data,Node root){
	Node temp=find(data,root);
	if (temp.left!=null)
		return max(temp.left);
	else{
		if(temp.parent.right==temp)
			return temp.parent.data;
		else{
			while(temp.parent.right!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
	
	int sucdec(int data,Node root){
	Node temp=find(data,root);
	if (temp.right!=null)
		return min(temp.right);
	else{
		if(temp.parent.left==temp)
			return temp.parent.data;
		else{
			while(temp.parent.left!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
}




import java.util.*;

class Node{
		int data;
		public Node left, right, parent;
		
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			parent=null;
		}
		
	}


class Tree2LinkedList{
	ArrayList<LinkedList<Node>> convert2LL(Node root ){
		ArrayList <LinkedList<Node>> results= new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> list;
		int level=0;
		list = new LinkedList<Node>();
		list.add(root);
		results.add(list);
		
		while(true){
			list=results.get(level);
			LinkedList<Node> tempLL=new LinkedList<Node>();
			for (int i=0;i<list.size();i++){
				Node temp=list.get(i);
				System.out.println(temp.data);
				if(temp.left!=null)
					tempLL.add(temp.left);
				if (temp.right!=null)
					tempLL.add(temp.right);					
			}
			if (tempLL.size()>0){
				results.add(tempLL);
				level++;
			}
			else
				break;
		}
		
		return results;
	}
}


class Tree{
	
	
	public Node root;
	
	Tree(){
		root=null;
	}
	
	void recurse(Node parent, Node temp){
		if (temp.data<=parent.data){
			if (parent.left==null){
				parent.left=temp;
				temp.parent=parent;
			}else{
				recurse(parent.left,temp);
			}
		}else{
			if (parent.right==null){
				parent.right=temp;
				temp.parent=parent;
			}else{
				recurse(parent.right,temp);
			}
		}
	}
	
	void insert(int data){
		Node temp=new Node(data);
		if (root==null){
			root=temp;
		}
		else{
			recurse(root,temp);
		}
	}
	
	void inorder(Node parent){
		if (parent==null)
			return;
		else{
			inorder(parent.left);
			System.out.println(parent.data);
			inorder(parent.right);
		}
	}

	void preorder(Node parent){
		if (parent==null)
			return;
		else{
			System.out.println(parent.data);
			preorder(parent.left);			
			preorder(parent.right);
		}
	}
	
	void postorder(Node parent){
		if (parent==null)
			return;
		else{
			postorder(parent.left);			
			postorder(parent.right);
			System.out.println(parent.data);
		}
	}	
	
	int min(Node temp){
		if (temp.left==null)
			return temp.data;
		else
			return min(temp.left);
	}
	
	int max(Node temp){
		if (temp.right==null)
			return temp.data;
		else
			return max(temp.right);
	}
	
	Node find(int data, Node temp){
		if (temp==null){
			return null;
		}
		else if (temp.data==data)
			return temp;
		else{
			if (data<temp.data)
				return find(data,temp.left);
			else	
				return find(data,temp.right);
		}
	}
	
	int predec(int data,Node root){
	Node temp=find(data,root);
	if (temp.left!=null)
		return max(temp.left);
	else{
		if(temp.parent.right==temp)
			return temp.parent.data;
		else{
			while(temp.parent.right!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
	
	int sucdec(int data,Node root){
	Node temp=find(data,root);
	if (temp.right!=null)
		return min(temp.right);
	else{
		if(temp.parent.left==temp)
			return temp.parent.data;
		else{
			while(temp.parent.left!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
}


class TreeLinkedList{

	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(3);
		T.insert(1);
		T.insert(2);
		T.insert(5);
		T.insert(6);
		T.insert(4);
		System.out.println("Inorder");
		T.inorder(T.root);
		Tree2LinkedList TL=new Tree2LinkedList();
		ArrayList<LinkedList<Node>> results=TL.convert2LL(T.root );
		for(int i=0;i<results.size();i++){
			System.out.println("Level="+i);
			LinkedList<Node> temp= results.get(i);			
			for (int j=0;j<temp.size();j++){
				Node temp2=temp.get(j);
				System.out.print(temp2.data+"\t");				
			}
			System.out.println();
		}
		
	}
}
class Node{
	int data;
	int size;
	public Node left, right, parent;

	Node(int data){
		this.data=data;
		left=null;
		right=null;
		parent=null;
		size=0;
	}

}

class Tree{
	
	
	public Node root;
	
	Tree(){
		root=null;
	}
	
	void recurse(Node parent, Node temp){
		if (temp.data<=parent.data){
			if (parent.left==null){
				parent.left=temp;
				temp.parent=parent;
			}else{
				recurse(parent.left,temp);
			}
		}else{
			if (parent.right==null){
				parent.right=temp;
				temp.parent=parent;
			}else{
				recurse(parent.right,temp);
			}
		}
	}
	
	void insert(int data){
		Node temp=new Node(data);
		if (root==null){
			root=temp;
		}
		else{
			recurse(root,temp);
		}
	}
	
	void inorder(Node parent){
		if (parent==null)
			return;
		else{
			inorder(parent.left);
			System.out.println(parent.data+" "+parent.size);
			inorder(parent.right);
		}
	}

	void preorder(Node parent){
		if (parent==null)
			return;
		else{
			System.out.println(parent.data);
			preorder(parent.left);			
			preorder(parent.right);
		}
	}
	
	void postorder(Node parent){
		if (parent==null)
			return;
		else{
			postorder(parent.left);			
			postorder(parent.right);
			System.out.println(parent.data);
		}
	}	
	
	int min(Node temp){
		if (temp.left==null)
			return temp.data;
		else
			return min(temp.left);
	}
	
	int max(Node temp){
		if (temp.right==null)
			return temp.data;
		else
			return max(temp.right);
	}
	
	Node find(int data, Node temp){
		if (temp==null){
			return null;
		}
		else if (temp.data==data)
			return temp;
		else{
			if (data<temp.data)
				return find(data,temp.left);
			else	
				return find(data,temp.right);
		}
	}
	
	int predec(int data,Node root){
	Node temp=find(data,root);
	if (temp.left!=null)
		return max(temp.left);
	else{
		if(temp.parent.right==temp)
			return temp.parent.data;
		else{
			while(temp.parent.right!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
	
	int sucdec(int data,Node root){
	Node temp=find(data,root);
	if (temp.right!=null)
		return min(temp.right);
	else{
		if(temp.parent.left==temp)
			return temp.parent.data;
		else{
			while(temp.parent.left!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}

	Node floor(int data, Node temp){
		if (temp==null)
			return null;
		else{
			if(data==temp.data)
				return temp;
			else{
				if(data<temp.data)
					return floor(data,temp.left);
				else{
					Node t=floor(data,temp.right);
					if(t!=null) return t;
					else
						return temp;
				}
			}
		}
	}

	int cal_size(Node temp){
		if (temp==null)
			return 0;
		else
			temp.size=1+cal_size(temp.left)+cal_size(temp.right);
			return temp.size;
	}

	Node select(int rank, Node temp){
		int t_size;
		if(temp==null)
			return null;
		else{
			if(temp.left!=null){
				t_size=temp.left.size;
			}else{
				t_size=0;
			}
			if(rank==temp.size-t_size){
				return temp;
			}else{
				if(rank>t_size)
					return select(rank-t_size-1,temp.right);
				else
					return select(rank,temp.left);
			}
				
			
			}
	}
	
	Node inPlaceSucc(Node temp, int data){
		if (temp==null)
			return null;
		else{
			if(temp.data==data){
				if(temp.right!=null){
					Node suc=null;
					temp=temp.right;
					while(temp!=null){
						suc=temp;
						temp=temp.left;
					}
					return suc;
				}
				else{
					return null;
				}
			}else{
				if(data>temp.data)
					return inPlaceSucc(temp.right,data);
				else{
					Node suc=inPlaceSucc(temp.left,data);
					return suc!=null?suc:temp;
				}
			}
		}
	}
	
	int minHeight(Node temp){
		if(temp==null)
			return 0;
		else{
			int left=minHeight(temp.left);
			int right=minHeight(temp.right);
			return left<right?left+1:right+1;
		}

	}

	int maxHeight(Node temp){
		if(temp==null)
			return 0;
		else{
			int left=maxHeight(temp.left);
			int right=maxHeight(temp.right);
			return left>right?left+1:right+1;
		}
	}

	boolean isBalanced(Node temp){
		if (temp==null)
			return true;
		else{
			return maxHeight(temp)-minHeight(temp)<=1;
		}
	}
	
	
	
	
}


class TreeTest{

	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(7);
		T.insert(5);
		T.insert(6);
		T.insert(4);
		T.insert(10);
		T.insert(8);
		T.cal_size(T.root);
		System.out.println("Inorder");
		T.inorder(T.root);
		//Node suc=T.inPlaceSucc(T.root,5);
		System.out.println(T.isBalanced(T.root));
		
		
	}
}

import java.util.*;
 
class Node{
	public int data;
	public boolean visited;
	ArrayList <Node> edges;
	
	Node(int data){
		this.data=data;
		edges=new ArrayList<Node> ();
		visited=false;
	}
	
	void addEdge(Node temp){
		edges.add(temp);
	}
	
	ArrayList <Node> getEdges(){
		return edges;
	}
	
	void print(){
		System.out.println("Node="+data);
		for (int i=0;i<edges.size();i++){
			System.out.println(edges.get(i).data);
		}
		System.out.println("End of Node Data");
	}
}

class Graph{

	public ArrayList <Node> Vertices;
	
	
	Graph(){
		Vertices=new ArrayList <Node> ();
	}
	
	Node getNode(int data){
		for(int i=0;i<Vertices.size();i++){
			if (Vertices.get(i).data==data)
				return Vertices.get(i);
		}
		return null;
	}
	
	void insert(int data, int[] edges){
		Node vertex=getNode(data);
		if (vertex==null)
			vertex=new Node(data);
		Vertices.add(vertex);
		for (int i=0;i<edges.length;i++){
			Node temp=getNode(edges[i]);
			if (temp==null)
				temp=new Node(edges[i]);
			vertex.addEdge(temp);
		}
	}
	
	ArrayList <Node> getVertices(){
		return Vertices;
	}
	
	void print(){
		System.out.println("Printing Graph");
		for (int i=0;i<Vertices.size();i++){
			Node temp_node=Vertices.get(i);
			temp_node.print();
			//System.out.print(temp_node.data);
			//ArrayList <Node> temp_edges=temp_node.getEdges();
			//for (int j=0;j<temp_edges.size();j++){
			//	System.out.print("\t"+temp_edges.get(j).data);
			//}
			//System.out.println();
		}
		System.out.println("---------------");
	}

	void BFS(Graph G){
		System.out.println("BFS");
		Queue <Node> Q=new LinkedList<Node> ();
		ArrayList <Node> vertices=G.getVertices();
		Q.add(vertices.get(0));
		vertices.get(0).visited=true;
		
		while(Q.size()>0){
			//G.print();
			Node temp=Q.poll();
			System.out.println(temp.data);
			//temp.print();
			ArrayList <Node> edges=temp.getEdges();
			for(int i=0;i<edges.size();i++){
				Node temp2=getNode(edges.get(i).data);
				//temp2.print();
				 if(temp2.visited==false){
					 temp2.visited=true;
					 Q.add(temp2);
				 }
			}
			
		}
	}
	
	void DFS(Node n){
		System.out.println(n.data);
		ArrayList <Node> edges=n.getEdges();
		for(int i=0;i<edges.size();i++){
			Node temp=getNode(edges.get(i).data);
			if (temp.visited==false){
				temp.visited=true;
				DFS(temp);
			}
			
		}
		
	}
	
	boolean FindUndirectedCycle(Node n, Node parent){
		n.visited=true;
		ArrayList<Node> edges=n.getEdges();
		for(int i=0;i<edges.size();i++){
			Node temp=getNode(edges.get(i).data);
			if(temp.visited==true && temp.data!=parent.data)
				return false;
			else if(temp.visited!=true)
				return FindUndirectedCycle(temp,n);
		}
		return true;
	}
	
	boolean DFSUtil(Node n){
		ArrayList<Node> edges=n.getEdges();
		for(int i=0;i<edges.size();i++){
			Node temp=getNode(edges.get(i).data);
			if(temp.visited)
				return false;
			else
				return DFSUtil(temp);
		}
		return true;
	}
	
	boolean FindDirectCycle(){
		
		for(int i=0;i<Vertices.size();i++){
			Vertices.get(i).visited=true;
			if (!DFSUtil(Vertices.get(i)))
				return false;
			Vertices.get(i).visited=false;
		}
		return true;
	}
}

class GraphUtil{
	public static void main(String [] args){
		System.out.println("Graph and methods");
		Graph G=new Graph();
		G.insert(1,new int[]{3});
		G.insert(3,new int[]{});
		G.insert(5,new int[]{1});
		G.insert(7,new int[]{5,3});
		G.print();
		System.out.println(G.FindDirectCycle());
		
		
		
	}
	
}

import java.util.*;
//Student class to hold name and  marks

class Student{
	String name;
	ArrayList <Integer> marks;
	double average;
	
	Student(String name){
		this.name=name;
		marks=new ArrayList<Integer>();
		average=0;
	}
	
	void addmarks(int mark){
		marks.add(mark);
		average=0;
		for(int i=0;i<marks.size();i++){
			average+=marks.get(i);
		}
		//average=average/marks.size();
	}
	
	ArrayList<Integer> getmarks(){
		return marks;
	}
	
	double getAverage(){
		return average;
	}
	
	void print(){
		System.out.println("Name="+name);
		System.out.println("Average="+average);
		for(int i=0;i<marks.size();i++){
			System.out.println(marks.get(i));
		}
		
	}
	
}

class records{
	Student table[];
	Student highest;
	double highestScore;
	int size;
	int hash2;
	double avg;
	int added;
	
	records(int size){
		table=new Student[size];
		for(int i=0;i<size;i++){
			table[i]=null;
		}
		highestScore=0;
		this.size=size;
		hash2=7;
		avg=0;
		added=0;
	}
	
	int hash(String name, int _size){
		int sum=0;
		for(int i=0;i<name.length();i++){
			sum+=name.charAt(i);
		}
		return sum%_size;
	}
	
	
	
	int findRecord(String name){
		int hashval=hash(name,size);
		System.out.println("hashval="+hashval);
		if(table[hashval]==null)
			return hashval;
		else{
			if (table[hashval].name.equals(name))
				return hashval;
			else{
				int hashoffset=hash(name,hash2);
				int temp=hashval+hashoffset;
				while(true){
					if(table[temp]==null){
						return temp;
					}
						
					else{
						if(table[temp].name.equals(name))
							return temp;
						else{
						temp+=hashoffset;
						if(temp>size)
							temp=temp-size;
						}
					}
				}
			}
		}
	}
	
	void insert(String name, int score){
		int location=findRecord(name);
		System.out.println("Location="+location);
		if(table[location]==null){
			Student s=new Student(name);
			s.addmarks(score);
			table[location]=s;
			added++;
		}
		else{
			table[location].addmarks(score);
		}
		updateAverage();
	}
	
	void print(){
		for(int i=0;i<size;i++){
				{
				if(table[i]!=null){
					System.out.println("Records at i="+i);
					table[i].print();
				}
			}
		}
		System.out.println("Class avg="+avg);
		System.out.println("Topper="+highest.name);
	}
	
	void updateAverage(){
		avg=0;
		for(int i=0;i<size;i++){
			if(table[i]!=null){
				avg+=table[i].getAverage();
				if (table[i].getAverage()>highestScore){
					highestScore=table[i].getAverage();
					highest=table[i];
				}
			}
		}
		avg=avg/added;
	}
	
	
	
}
//Records class to hold records for students and highest, 10 highest 




class StudentRecords{
	
	public static void main(String args[]){
		System.out.println("Shows records for students");
		
		records R=new records(50);
		R.insert("jona",50);
		R.insert("sam",30);
		R.insert("anoj",35);
		R.insert("anoj",40);
		R.print();
	}
}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}


class LinkedList{
	Node head;
	
	public LinkedList(){
		head=null;
	}
	
	void add(int data){
		Node n=new Node(data);
		Node temp;
		temp=head;
		if (head==null){
			head=n;
		}
		else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
	void printList(){
		System.out.println("Printing LinkedList");
		Node temp;
		temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main (String args[]){
		System.out.println("Linked List Basic Program");
		LinkedList L=new LinkedList();
		L.add(5);
		L.add(3);
		L.add(2);
		L.printList();
		
	} 
}
% First Program


class BST{
	private Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key=key;
		}
	}
	
	
	Node put(int key, Node x){
		if (x==null){
			return Node(key);
		}else{
			if(key==x.key)
				return x;
			else if(key<x.key)
				x.left=put(key,x.left);
			else
				x.right=put(key,x.right);
		}
	}
	
	Node put(int key){
		return put(key,root);
	}

}

class ReadFile{

}

class ReadFileTest{
	public static void main(String [] args){
		System.out.println("This operation deals with basics of file handerling");
	}
}

import java.util.*;

class Node{
	int data;
	String val;
	
	Node(int data, String val){
		this.data=data;
		this.val=val;
		//System.out.println(val);
	}
	
	void print(){
		System.out.println("Data="+this.data+" val="+this.val);
	}
}

class HashTable{
	//datatypes
	//ArrayList table, table size, hashKey1, hashOffset
	Node HT[];
	int tableSize;
	int hashKey;
	int hashOffset;
	
	//constructor with HT size
	HashTable(int size, int hashKey, int hashOffset){
		HT=new Node[size];
		this.tableSize=size;
		this.hashKey=hashKey;
		this.hashOffset=hashOffset;
	}
	
	
	//depend on hashcode, size
	int getHashCode(String val){
		char s[]=val.toCharArray();
		int key=0;
		for(int i=0;i<s.length;i++)
			key+=s[i];
		return (hashKey*key)%tableSize;
	}
	
	//method to put key and val
	void put(int key, Node val){
		int loc=getHashCode(val.val);
		System.out.println(loc);
		while(HT[loc]!=null){
				loc=loc+hashOffset;
				if(loc>=tableSize)
					loc=loc-tableSize;
		}
		HT[loc]=val;		
	}
	
	//method to get key
	Node get(String val){
		int loc=getHashCode(val);
		//System.out.println(HT[loc].val+val);
		while(HT[loc]!=null && HT[loc].val!=val){
				loc=loc+hashOffset;
				System.out.println(loc);
				if(loc>=tableSize)
					loc=loc-tableSize;
		}
		return HT[loc];
	}
	
	//method to print hashtable
	void print(){
		System.out.println("Printing hashtable");
		for(int i=0;i<tableSize;i++){
			if(HT[i]!=null)
				HT[i].print();
		}
	}
}

class HashTableUtil{
	public static void main(String[] args){
		System.out.println("HashTable util");
		HashTable HT=new HashTable(20,31,5);
		HT.put(1,new Node(1,"Sanmay"));
		HT.print();
		HT.put(4,new Node(4,"akki"));
		HT.put(3,new Node(3,"raja"));
		HT.put(10,new Node(10,"chama"));
		HT.print();
		if(HT.get("Sanmay")!=null)
			HT.get("Sanmay").print();
		else
			System.out.println("Record does not exist");
	}

}


//Datastructure to hold information
class Node{
	String name;
	int marks;
	
	Node(String name, int marks){
		this.name=name;
		this.marks=marks;
	}
	
	void print(){
		System.out.println("Name="+name+" marks="+marks);
	}
}

//HT takes string as key and stores node as value 
//Implemented using linear probing 
class HTT{
//Private table to store HT data- array of data types
//Private variable to store table size
//primary hashcode
//secondary hashcode
Node [] table;
int tableSize;
int hashCode;
int hashOffset;

HTT(int size,int hashCode, int hashOffset){
	this.tableSize=size;
	this.hashCode=hashCode;
	this.hashOffset=hashOffset;
	table=new Node[tableSize];
}

int hashCode(String name){
	char s[]=name.toCharArray();
	int sum=0;
	for(int i=0;i<s.length;i++){
		sum+=s[i];
	}
	return sum*hashCode;
}
//Method to insert key value
void put(String name, Node temp){
	//corner case
	if (name==null)
		System.out.println("Error msg");
	else{
		//hashcode function ot get location in table mode by size
		int n=hashCode(name);
		n=n%tableSize;
		if(table[n]==null || table[n].name==name){
			table[n]=temp;
		}else{
			while(table[n]!=null){
				n=n+hashOffset;
				if (n>tableSize)
					n=tableSize-n;
			}
			table[n]=temp;
		}
	}

}

//method to get value

Node get(String key){
	if (key==null){
		System.out.println("Error msg");
		return null;
		}
	else{
		//hashcode function ot get location in table mode by size
		int n=hashCode(key);
		n=n%tableSize;
		while(table[n]!=null && table[n].name!=key){
			n=n+hashOffset;
			if (n>tableSize)
				n=tableSize-n;
		}
	return table[n];
}
}

void print(){
	System.out.println("New HashTable");
	for(int i=0;i<tableSize;i++){
		if(table[i]!=null){
			table[i].print();
		}
	}

}

}


class HT{
public static void main(String[] args){
		HTT hashTable=new HTT(20,31,5);
		hashTable.put("Sanmay",new Node("Sanmay",10));
		hashTable.print();
		hashTable.put("Akki",new Node("Akki",10));
		hashTable.print();
		hashTable.put("Sanmay",new Node("Sanmay",10));
		hashTable.print();
		hashTable.get("Akki").print();
	}
}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}


class LinkedList{
	Node head;
	
	public LinkedList(){
		head=null;
	}
	
	void add(int data){
		Node n=new Node(data);
		Node temp;
		temp=head;
		if (head==null){
			head=n;
		}
		else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
	void printList(){
		System.out.println("Printing LinkedList");
		Node temp;
		temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	Node getHead(){
		return head;
	}
}

class LinkedListSum{

	 static LinkedList Sum(LinkedList L1, LinkedList L2){
		LinkedList Result=new LinkedList();
		int sum,carry=0;
		Node temp1=L1.getHead();
		Node temp2=L2.getHead();
		
		while(temp1!=null && temp2!=null){			
			int result=temp1.data+temp2.data+carry;
			sum=result%10;
			carry=result/10;
			Result.add(sum);
			temp1=temp1.next;
			temp2=temp2.next;			
		}
		if (temp1!=null){
			while(temp1!=null){			
				int result=temp1.data+carry;
				sum=result%10;
				carry=result/10;
				Result.add(sum);
				temp1=temp1.next;						
			} 
		}else{
			while(temp2!=null){			
				int result=temp2.data+carry;
				sum=result%10;
				carry=result/10;
				Result.add(sum);
				temp2=temp2.next;		
			}
		}
		if (carry>0){
			Result.add(carry);
		}
		return Result;
	}
		
		
	
	public static void main (String args[]){
			System.out.println("Linked List Basic Program");
			LinkedList L1=new LinkedList();
			L1.add(5);
			L1.add(3);
			L1.add(2);
			LinkedList L2=new LinkedList();
			L2.add(5);
			L2.add(1);
			
			L1.printList();
			L2.printList();
			LinkedList Result=Sum(L1,L2);
			Result.printList();
			
		} 

}

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


class StackMin extends Stack{
	
	Stack S=new Stack();
	void push(int data){
		
	}
	
	public static void main(String args[]){
		
	}
}


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
			return stack_array[--top];
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
		System.out.println("Done Printing");
	}
}


class FibTest{
	
	static int Fib(int n){
		if (n==0)
			return 0;
		else if (n==1)
			return 1;
		else
			return Fib(n-1)+Fib(n-2);
	}
	
	public static void main(String[] args){
		System.out.println(Fib(6));
	}
}

class money{
	
	static void getways(int amt,String ways, int lastC){
		if (amt<=0){
			System.out.println("Final="+ways);
			return;
		}
		else{
			if(amt>=25 && lastC>=25){
				getways(amt-25,ways+Integer.toString(25)+",",25);
			}
			if(amt>=10 && lastC>=10){
				getways(amt-10,ways+Integer.toString(10)+",",10);
			}
			if(amt>=5 && lastC>=5){
				getways(amt-5,ways+Integer.toString(5)+",",5);
			}
			if(amt>=1 && lastC>=1){
				getways(amt-1,ways+Integer.toString(1)+",",1);
			}
		}
		
	}
	
	public static void main(String []args){
		System.out.println("This shows ways to add up to money");
		String ways="";
		getways(10,ways,10);
	}
}

import java.util.*;

class paranthesis{
	static int glob=0;
	static ArrayList <String> getCombo(String temp,int left, int right){
		glob=glob+1;
		
		ArrayList <String> results=new ArrayList<String>();
		ArrayList <String> tempresults;
		if (left==0 && right==0){
			System.out.println("Final="+temp);			
			results.add(temp);
			return results;
		}else{
						
			if (left>0){
				left=left-1;
				System.out.println("left");
				temp=temp+"(";
				System.out.println("left="+left+" right="+right);
				System.out.println(temp);
				tempresults=getCombo(temp,left,right);
				for (int i=0;i<tempresults.size();i++){
					results.add(tempresults.get(i));
				}
			}
			
			if (right>left){
				right=right-1;
				System.out.println("right");
				temp=temp+")";
				System.out.println("left="+left+" right="+right);
				System.out.println(temp);
				tempresults=getCombo(temp,left,right);
				for (int i=0;i<tempresults.size();i++){
					results.add(tempresults.get(i));
				}
			}
			
		}
		return results;
	}
	
	public static void main(String[] args){
		System.out.println("Recursive algorithm to print pair of paranthesis");
		ArrayList <String> results;
		String temp="";
		results=getCombo(temp,2,2);
		System.out.println(results);
		
	}
}





class Queens{
	
	static void print(int chessboard[][]){
		for (int w=0;w<chessboard.length;w++){
			System.out.println();
			for (int v=0;v<chessboard.length;v++){
				System.out.print(chessboard[w][v]);
			}
		}
	}
	
	static void getWays(int chessboard[][],int queens,String result){
		//String result="";
		if (queens==0){
			System.out.println("Final="+result);
			return;
		}
		else{
				for (int i=0;i<chessboard.length;i++){
				for (int j=0;j<chessboard.length;j++){
					if(queens==2){
						for (int w=0;w<chessboard.length;w++){
							for (int v=0;v<chessboard.length;v++){
								result="";
								chessboard[w][v]=0;
							}
						}
					}
					if(chessboard[i][j]==0){
						for (int y=0;y<chessboard.length;y++){
							chessboard[i][y]=1;
							chessboard[y][j]=1;
							if(i+y<3 && j+y<3)
								chessboard[i+y][j+y]=1;
							if(i-y>-1 && j-y>-1)
								chessboard[i-y][j-y]=1;
							if(i+y<3 && j-y>-1)
								chessboard[i+y][j-y]=1;
							if(i-y>-1 && j+y<3)
								chessboard[i-y][j+y]=1;
						}
						result=result+"("+Integer.toString(i)+" "+Integer.toString(j)+"),";
						//System.out.println("Intermediate="+result+"Queen="+queens);
						//print(chessboard);
						getWays(chessboard,queens-1,result);
							
					}
				}
			}
		
		}
		return;
	}
	
	public static void main(String[] args){
		int chessboard[][]=new int[3][3];
		int queens=2;
		System.out.println("Method gives ways to arrange queens so they wont kill each other :P");
		for (int i=0;i<chessboard.length;i++){
			for (int j=0;j<chessboard.length;j++){
				chessboard[i][j]=0;
			}
		}
		String result="";
		getWays(chessboard,queens,result);
	}
}
import java.util.ArrayList;

class StringPerm{
	
		
		static ArrayList <String> addChar(String input, String ch){
			ArrayList <String> results=new ArrayList <String>();
			
			for (int i=0;i<=input.length();i++){
				String temp=input.substring(0,i)+ch+input.substring(i,input.length());
				results.add(temp);
			}
			return results;
		}
		static ArrayList <String> getPerm(ArrayList <String> input){
			ArrayList <String> results=new ArrayList <String>();
			ArrayList <String> tempresults=new ArrayList <String>();
			ArrayList <String> finalresults=new ArrayList <String>();
			if (input.size()==1)
				return input;
			else{
				String tempChar=input.remove(0);
				System.out.println(input);
				results=getPerm(input);				
				for (int i=0;i<results.size();i++){
					System.out.println(tempChar);
					System.out.println(results.get(i));		
					tempresults=addChar(results.get(i),tempChar);
					for (int j=0;j<tempresults.size();j++)
						finalresults.add(tempresults.get(j));
					System.out.println(tempresults);
				}
			
			}
			return finalresults;
		}
	
	public static void main(String[] args){
		System.out.println("String Permutation");
		ArrayList <String> input=new ArrayList <String>();
		ArrayList <String> output=new ArrayList <String>();
		input.add("P");
		input.add("U");
		input.add("N");
		input.add("E");
		output=getPerm(input);
		System.out.println("Final");
		System.out.println(output);
	}
}

class FindElementTests{
	int idx=0;
	int getIndex(int[] input,int element, int start, int end){
		idx++;
		int middle=(start+end)/2;
		System.out.println("middle"+middle+" start="+start+" end="+end+" element="+element);
		if (idx>=10)
			return start;
		if (input[middle]==element)
			return middle;
		else{
			if (element<input[middle]){
				if (element>=input[start]){
					return getIndex(input,element, start, middle-1);
				}else{
					return getIndex(input,element, middle+1, end);
				}
			}else{
				if (element>input[end]){
					return getIndex(input,element, start, middle-1);
				}else{
					return getIndex(input,element, middle+1, end);
				}
			}
		}
	}
}

class FindElements{

	public static void main(String[] args){
		int [] input={6,7,8,9,10,1,2,3,4,5};
		FindElementTests F=new FindElementTests();
		System.out.println(F.getIndex(input,6,0,input.length-1));
	}

}
import java.util.*;

class MergeSortTest{

static ArrayList<Integer> MergeSort(ArrayList <Integer> input, int start, int end){
		ArrayList <Integer> output=new ArrayList <Integer> ();
		if(start==end){
			output.add(input.get(start));
			return output;
		}
		else{
			int middle=(start+end)/2;
			ArrayList <Integer> output1=MergeSort(input,start,middle);
			ArrayList <Integer> output2=MergeSort(input,middle+1,end);
			int idx1=0,idx2=0;
			while(idx1<output1.size() && idx2<output2.size()){
				if (output1.get(idx1)<output2.get(idx2))
					output.add(output1.get(idx1++));
				else{
					output.add(output2.get(idx2++));
				}
			}
			while(idx1<output1.size()){
				output.add(output1.get(idx1++));
			}
			while(idx2<output2.size()){
				output.add(output2.get(idx2++));
			}
		}
		return output;
	}

public static void main(String[] args){
		
		ArrayList <Integer> input=new ArrayList <Integer>();
		input.add(3);
		input.add(2);
		input.add(5);
		input.add(1);
		input.add(0);
		System.out.println(MergeSort(input,0,input.size()-1));

	}
}

class QuickSortTest{

	static void print(int input[]){
		System.out.println();
		for (int i=0;i<input.length;i++){
			System.out.print(input[i]);
		}
	}
	static void QuickSort(int input[],int start, int end){
		if (start>=end){
			return;
		}
		else{
			int pivot=start;
			System.out.println("pivot="+input[pivot]);
			int sw=start+1;
			int iter=start+1;
			int temp;
			
			for(int i=iter;i<=end;i++){
			//System.out.println("iter="+input[i]);
				if(input[i]<input[pivot]){
					temp=input[sw];
					input[sw]=input[i];
					input[i]=temp;
					sw++;
				}
				//System.out.println("afteriter="+input[i]);
				
			}
			temp=input[pivot];
			input[pivot]=input[sw-1];
			input[sw-1]=temp;
			print(input);
			System.out.println("start="+start+" end="+sw);
			QuickSort(input,start,sw-2);
			System.out.println("start2="+sw+" end2="+end);
			QuickSort(input,sw,end);
		}
		
		
	}
	public static void main (String[] args){
		int input[]={3,2,6,4,1,5,0};
		QuickSort(input,0,6);
		System.out.println(input[0]);
	} 
}


class Heap{
	int input[];
	int end;
	
	Heap(){
		input=new int[10];
		end=0;
	}
	
	void insert(int data){
		input[end]=data;
		int i=end;
		end++;
		while(input[i]<input[i/2]){
			int temp=input[i];
			input[i]=input[i/2];
			input[i/2]=temp;
			i=i/2;
		}
	}
	
	int ExtractMin(){
		int min=input[0];
		input[0]=input[end-1];
		end=end-1;
		int j=0;
		
		while(j*2+1<end){
			int flag=0;
			if (input[j]>input[j*2]){
				int temp=input[j];
				input[j]=input[j*2];
				input[j*2]=temp;
				j=j*2;
				flag=1;
			}else{
				int temp=input[j];
				input[j]=input[j*2+1];
				input[j*2+1]=temp;
				j=j*2+1;
				flag=1;
			}
			if (flag==0){
				break;
			}
			
		}
		return min;
	}
	
	void print(){
		System.out.println();
		System.out.println("Printing the heap");
		
		for (int i=0;i<end;i++){
			
			System.out.print("\t"+input[i]);
			
		}
	}
}

class HeapTest {
	public static void main(String[] args){
		
		System.out.println("This is heap test");
		Heap h=new Heap();
		h.insert(2);
		h.print();
		h.insert(1);
		h.print();
		h.insert(4);
		h.insert(5);
		h.insert(0);
		h.print();
		System.out.println("Min="+h.ExtractMin());
		h.print();
		System.out.println("Min="+h.ExtractMin());
		h.print();
	}
}


class InPlaceHeapSort{
	
	static void doInPlaceHeapSort(int[] a){
	//create max heap in place, start from end
	for(int i=a.length-1;i>=0;i--){
		
		if(2*i+2<a.length){
			if (a[i]<a[2*i+2] || a[i]<a[2*i+1]){
				if(a[2*i+2]>a[2*i+1]){
					int temp=a[2*i+2];
					a[2*i+2]=a[i];
					a[i]=temp;
				}else{
					int temp=a[2*i+1];
					a[2*i+1]=a[i];
					a[i]=temp;
				}
			}
		}
		else if(2*i+1<a.length){
			if(a[i]<a[2*i+1]){
				int temp=a[2*i+1];
				a[2*i+1]=a[i];
				a[i]=temp;
			}
		}
	}
	
	for(int i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
	}
	
	for(int cnt=a.length-1;cnt>=0;cnt--){
		System.out.println();
		System.out.println("cnt="+cnt+" a[cnt]="+a[cnt]+" a[0]="+a[0]);
		int temp2=a[0];
		a[0]=a[cnt];
		a[cnt]=temp2;
		System.out.println("a cnt="+cnt+" a[cnt]="+a[cnt]+" a[0]="+a[0]);
		int i=0;
		while(true){
			if(2*i+2<cnt){
				if (a[i]<a[2*i+2] || a[i]<a[2*i+1]){
					if(a[2*i+2]>a[2*i+1]){
						int temp=a[2*i+2];
						a[2*i+2]=a[i];
						a[i]=temp;
					}else{
						int temp=a[2*i+1];
						a[2*i+1]=a[i];
						a[i]=temp;
					}
				}else
					break;
			}
			else if(2*i+1<cnt){
				if(a[i]<a[2*i+1]){
					int temp=a[2*i+1];
					a[2*i+1]=a[i];
					a[i]=temp;
				}else
					break;
			}else
				break;
		}
	System.out.println();
	for(int k=0;k<a.length;k++){
		System.out.print(a[k]+" ");
	}
	}
	
	
}
	
	public static void main(String [] args){
		int[] input={5,3,1,2,10,12};
		doInPlaceHeapSort(input);
	}
}

class Pair{
	public int data;
	public int idx;
	Pair(int data,int idx){
		this.data=data;
		this.idx=idx;
	}
}

class Heap{
	Pair input[];
	int end;
	
	Heap(){
		input=new Pair[10];
		end=0;
	}
	
	void insert(int data,int idx){
		
		Pair temp=new Pair(data,idx);
		input[end]=temp;
		int i=end;
		end++;
		while(input[i].data<input[i/2].data){
			temp=input[i];
			input[i]=input[i/2];
			input[i/2]=temp;
			i=i/2;
		}
	}
	
	/*void insert(int data){
		input[end]=data;
		int i=end;
		end++;
		while(input[i]<input[i/2]){
			int temp=input[i];
			input[i]=input[i/2];
			input[i/2]=temp;
			i=i/2;
		}
	}*/
	
	Pair Pop(){
		Pair min=input[0];
		input[0]=input[end-1];
		end=end-1;
		int j=0;
		
		while(j*2+1<end){
			int flag=0;
			if (input[j].data>input[j*2].data){
				Pair temp=input[j];
				input[j]=input[j*2];
				input[j*2]=temp;
				j=j*2;
				flag=1;
			}else{
				Pair temp=input[j];
				input[j]=input[j*2+1];
				input[j*2+1]=temp;
				j=j*2+1;
				flag=1;
			}
			if (flag==0){
				break;
			}
			
		}
		return min;
	}
	void print(){
		System.out.println();
		System.out.println("Printing the heap");
		
		for (int i=0;i<end;i++){
			
			System.out.print("\n"+input[i].data+"\t"+input[i].idx);
			
		}
	}
	
	boolean isEmpty(){
		if (end==0){
			return true;
		}
		return false;
	}
}


class KMergeTest {
	public static void main(String[] args){
		
		System.out.println("This is K-Merge using heap");
		int input[][]={{1,3,5,7},{0,2,6},{4,9,11}};
		int output[]=new int[10];
		
		//insert one elements from each array in min heap
		int idx[]=new int[3];
		Heap h=new Heap();
		
		for (int i=0;i<input.length;i++){
			h.insert(input[i][0],i);
			idx[i]=1;
		}
		
		int k=0;
		while(!h.isEmpty()){
			Pair temp=h.Pop();
			output[k++]=temp.data;
			System.out.println(output[k-1]);
			
			if(idx[temp.idx]<input[temp.idx].length){
				h.insert(input[temp.idx][idx[temp.idx]],temp.idx);
				idx[temp.idx]++;
			}
		}
		
			
	}
}

import java.util.*;

class Median{
		PriorityQueue<Integer> max;
		PriorityQueue<Integer> min;
		Median(int size){
			max=new PriorityQueue<Integer>(size,new Comparator<Integer>(){public int compare (Integer o1, Integer o2){return o2-o1;}});
			Comparator <Integer> cmp=new Comparator<Integer>(){
				//@override
				public int compare(Integer o1, Integer o2){
					return o1-o2;
				}
			};
			min= new PriorityQueue<Integer>(size,cmp);
			
		}
	
	int get(int data){
		if(max.size()==0){
			max.add(data);
		}else if(data<max.peek()){
			max.add(data);
		}else{
			min.add(data);
		}
		
		if(max.size()>min.size()+1){
			min.add(max.poll());
		}else if(min.size()>max.size()){
			max.add(min.poll());
		}
		return max.peek();
	}
}


class PQTest{
	public static void main(String[] args){
		Median m=new Median(20);
		System.out.println(m.get(5));
		System.out.println(m.get(1));
		System.out.println(m.get(2));
		System.out.println(m.get(0));
		System.out.println(m.get(10));
		System.out.println(m.get(12));
		System.out.println(m.get(13));
	}

}

class BalanceTree{
	
	
	static int minHeight(Node parent){
		if (parent==null)
			return 0;
		else 
			if (minHeight(parent.left)<minHeight(parent.right))
				return 1+minHeight(parent.left);
			else
				return 1+minHeight(parent.right);
	}
	
	static int maxHeight(Node parent){
		if (parent==null)
			return 0;
		else 
			if (maxHeight(parent.left)>maxHeight(parent.right))
				return 1+maxHeight(parent.left);
			else
				return 1+maxHeight(parent.right);
	}
	
	static boolean isBalanced(Node root){
		System.out.println("max="+maxHeight(root));
		System.out.println("min="+minHeight(root));
		return maxHeight(root)-minHeight(root)<2;
	}
	
	public static void main(String[] args){
		
		System.out.println("This method outputs whether tree is balanced or not");
		
		Tree T= new Tree();
		T.insert(5);
		T.insert(3);
		T.insert(2);
		T.insert(1);
		T.insert(6);
		T.insert(7);
		System.out.println("Inorder");
		T.inorder(T.root);
		System.out.println(isBalanced(T.root));
		
	}
}

import java.util.*;

class Node{
		int data;
		public Node left, right, parent;
		
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			parent=null;
		}
		
}

class CommonAncester{
	
	
	static Node LCA(Node n, int a, int b){
		if(n==null)
			return null;
		else if (n.data==a || n.data==b){
			return n;
		}
		else{
			Node left=LCA(n.left,a,b);
			Node right=LCA(n.right,a,b);
			
			if(left!=null&&right!=null)
				return n;
			else{
				if(left!=null)
					return left;
				else
					return right;
			}
		}
		
	}
	
	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(3);
		T.insert(1);
		T.insert(2);
		T.insert(5);
		T.insert(6);
		T.insert(4);
		System.out.println("Inorder");
		T.inorder(T.root);
		
		CommonAncester CA=new CommonAncester();
		Node temp=CA.LCA(T.root,3,1);
		System.out.println("Ancestor="+temp.data);
	}
}




class Tree{
	
	
	public Node root;
	
	Tree(){
		root=null;
	}
	
	void recurse(Node parent, Node temp){
		if (temp.data<=parent.data){
			if (parent.left==null){
				parent.left=temp;
				temp.parent=parent;
			}else{
				recurse(parent.left,temp);
			}
		}else{
			if (parent.right==null){
				parent.right=temp;
				temp.parent=parent;
			}else{
				recurse(parent.right,temp);
			}
		}
	}
	
	void insert(int data){
		Node temp=new Node(data);
		if (root==null){
			root=temp;
		}
		else{
			recurse(root,temp);
		}
	}
	
	void inorder(Node parent){
		if (parent==null)
			return;
		else{
			inorder(parent.left);
			System.out.println(parent.data);
			inorder(parent.right);
		}
	}

	void preorder(Node parent){
		if (parent==null)
			return;
		else{
			System.out.println(parent.data);
			preorder(parent.left);			
			preorder(parent.right);
		}
	}
	
	void postorder(Node parent){
		if (parent==null)
			return;
		else{
			postorder(parent.left);			
			postorder(parent.right);
			System.out.println(parent.data);
		}
	}	
	
	int min(Node temp){
		if (temp.left==null)
			return temp.data;
		else
			return min(temp.left);
	}
	
	int max(Node temp){
		if (temp.right==null)
			return temp.data;
		else
			return max(temp.right);
	}
	
	Node find(int data, Node temp){
		if (temp==null){
			return null;
		}
		else if (temp.data==data)
			return temp;
		else{
			if (data<temp.data)
				return find(data,temp.left);
			else	
				return find(data,temp.right);
		}
	}
	
	int predec(int data,Node root){
	Node temp=find(data,root);
	if (temp.left!=null)
		return max(temp.left);
	else{
		if(temp.parent.right==temp)
			return temp.parent.data;
		else{
			while(temp.parent.right!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
	
	int sucdec(int data,Node root){
	Node temp=find(data,root);
	if (temp.right!=null)
		return min(temp.right);
	else{
		if(temp.parent.left==temp)
			return temp.parent.data;
		else{
			while(temp.parent.left!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
}




import java.util.*;

class Node{
		int data;
		public Node left, right, parent;
		
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			parent=null;
		}
		
	}


class Tree2LinkedList{
	ArrayList<LinkedList<Node>> convert2LL(Node root ){
		ArrayList <LinkedList<Node>> results= new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> list;
		int level=0;
		list = new LinkedList<Node>();
		list.add(root);
		results.add(list);
		
		while(true){
			list=results.get(level);
			LinkedList<Node> tempLL=new LinkedList<Node>();
			for (int i=0;i<list.size();i++){
				Node temp=list.get(i);
				System.out.println(temp.data);
				if(temp.left!=null)
					tempLL.add(temp.left);
				if (temp.right!=null)
					tempLL.add(temp.right);					
			}
			if (tempLL.size()>0){
				results.add(tempLL);
				level++;
			}
			else
				break;
		}
		
		return results;
	}
}


class Tree{
	
	
	public Node root;
	
	Tree(){
		root=null;
	}
	
	void recurse(Node parent, Node temp){
		if (temp.data<=parent.data){
			if (parent.left==null){
				parent.left=temp;
				temp.parent=parent;
			}else{
				recurse(parent.left,temp);
			}
		}else{
			if (parent.right==null){
				parent.right=temp;
				temp.parent=parent;
			}else{
				recurse(parent.right,temp);
			}
		}
	}
	
	void insert(int data){
		Node temp=new Node(data);
		if (root==null){
			root=temp;
		}
		else{
			recurse(root,temp);
		}
	}
	
	void inorder(Node parent){
		if (parent==null)
			return;
		else{
			inorder(parent.left);
			System.out.println(parent.data);
			inorder(parent.right);
		}
	}

	void preorder(Node parent){
		if (parent==null)
			return;
		else{
			System.out.println(parent.data);
			preorder(parent.left);			
			preorder(parent.right);
		}
	}
	
	void postorder(Node parent){
		if (parent==null)
			return;
		else{
			postorder(parent.left);			
			postorder(parent.right);
			System.out.println(parent.data);
		}
	}	
	
	int min(Node temp){
		if (temp.left==null)
			return temp.data;
		else
			return min(temp.left);
	}
	
	int max(Node temp){
		if (temp.right==null)
			return temp.data;
		else
			return max(temp.right);
	}
	
	Node find(int data, Node temp){
		if (temp==null){
			return null;
		}
		else if (temp.data==data)
			return temp;
		else{
			if (data<temp.data)
				return find(data,temp.left);
			else	
				return find(data,temp.right);
		}
	}
	
	int predec(int data,Node root){
	Node temp=find(data,root);
	if (temp.left!=null)
		return max(temp.left);
	else{
		if(temp.parent.right==temp)
			return temp.parent.data;
		else{
			while(temp.parent.right!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
	
	int sucdec(int data,Node root){
	Node temp=find(data,root);
	if (temp.right!=null)
		return min(temp.right);
	else{
		if(temp.parent.left==temp)
			return temp.parent.data;
		else{
			while(temp.parent.left!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
}


class TreeLinkedList{

	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(3);
		T.insert(1);
		T.insert(2);
		T.insert(5);
		T.insert(6);
		T.insert(4);
		System.out.println("Inorder");
		T.inorder(T.root);
		Tree2LinkedList TL=new Tree2LinkedList();
		ArrayList<LinkedList<Node>> results=TL.convert2LL(T.root );
		for(int i=0;i<results.size();i++){
			System.out.println("Level="+i);
			LinkedList<Node> temp= results.get(i);			
			for (int j=0;j<temp.size();j++){
				Node temp2=temp.get(j);
				System.out.print(temp2.data+"\t");				
			}
			System.out.println();
		}
		
	}
}


class Tree{
	class Node{
		int data;
		int size;
		public Node left, right, parent;
	
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			parent=null;
			size=0;
		}
	
	}
	
	public Node root;
	
	Tree(){
		root=null;
	}
	
	void recurse(Node parent, Node temp){
		if (temp.data<=parent.data){
			if (parent.left==null){
				parent.left=temp;
				temp.parent=parent;
			}else{
				recurse(parent.left,temp);
			}
		}else{
			if (parent.right==null){
				parent.right=temp;
				temp.parent=parent;
			}else{
				recurse(parent.right,temp);
			}
		}
	}
	
	void insert(int data){
		Node temp=new Node(data);
		if (root==null){
			root=temp;
		}
		else{
			recurse(root,temp);
		}
	}
	
	void inorder(Node parent){
		if (parent==null)
			return;
		else{
			inorder(parent.left);
			System.out.println(parent.data+" "+parent.size);
			inorder(parent.right);
		}
	}

	void preorder(Node parent){
		if (parent==null)
			return;
		else{
			System.out.println(parent.data);
			preorder(parent.left);			
			preorder(parent.right);
		}
	}
	
	void postorder(Node parent){
		if (parent==null)
			return;
		else{
			postorder(parent.left);			
			postorder(parent.right);
			System.out.println(parent.data);
		}
	}	
	
	int min(Node temp){
		if (temp.left==null)
			return temp.data;
		else
			return min(temp.left);
	}
	
	int max(Node temp){
		if (temp.right==null)
			return temp.data;
		else
			return max(temp.right);
	}
	
	Node find(int data, Node temp){
		if (temp==null){
			return null;
		}
		else if (temp.data==data)
			return temp;
		else{
			if (data<temp.data)
				return find(data,temp.left);
			else	
				return find(data,temp.right);
		}
	}
	
	int predec(int data,Node root){
	Node temp=find(data,root);
	if (temp.left!=null)
		return max(temp.left);
	else{
		if(temp.parent.right==temp)
			return temp.parent.data;
		else{
			while(temp.parent.right!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}
	
	int sucdec(int data,Node root){
	Node temp=find(data,root);
	if (temp.right!=null)
		return min(temp.right);
	else{
		if(temp.parent.left==temp)
			return temp.parent.data;
		else{
			while(temp.parent.left!=temp){
				temp=temp.parent;
				if(temp.parent==null)
					return -1;
			}
			return temp.parent.data;
		}
	}
	}

	Node floor(int data, Node temp){
		if (temp==null)
			return null;
		else{
			if(data==temp.data)
				return temp;
			else{
				if(data<temp.data)
					return floor(data,temp.left);
				else{
					Node t=floor(data,temp.right);
					if(t!=null) return t;
					else
						return temp;
				}
			}
		}
	}

	int cal_size(Node temp){
		if (temp==null)
			return 0;
		else
			temp.size=1+cal_size(temp.left)+cal_size(temp.right);
			return temp.size;
	}

	Node select(int rank, Node temp){
		int t_size;
		if(temp==null)
			return null;
		else{
			if(temp.left!=null){
				t_size=temp.left.size;
			}else{
				t_size=0;
			}
			if(rank==temp.size-t_size){
				return temp;
			}else{
				if(rank>t_size)
					return select(rank-t_size-1,temp.right);
				else
					return select(rank,temp.left);
			}
				
			
			}
	}
}


class TreeTest{

	public static void main(String[] args){
		System.out.println("This class tests all functions of tree");
		Tree T=new Tree();
		T.insert(7);
		T.insert(5);
		T.insert(9);
		T.insert(6);
		T.insert(4);
		T.insert(10);
		T.insert(8);
		T.cal_size(T.root);
		System.out.println("Inorder");
		T.inorder(T.root);
		System.out.println("Rank="+T.select(1,T.root).data);
		
	}
}
import java.util.*;

class Vertex{
    ArrayList<Integer> edges;
    int marked;
    
    Vertex(){
        edges=new ArrayList<Integer>();
        marked=0;
    }
    
    void addEdge(int ref){
        edges.add(ref);
    }
    
    ArrayList<Integer> getEdges(){
        return edges;
    }
    
    void print(int vertex){
        System.out.println("Vertex id="+vertex+" marked="+marked);
        for(int i=0;i<edges.size();i++)
            System.out.print("\t"+edges.get(i));
        System.out.println();
    }
    
    void mark(){
        marked=1;
    }
}

class Edge{
    int v1,v2,w;
    
    Edge(int v1, int v2, int w){
        this.v1=v1;
        this.v2=v2;
        this.w=w;
    }
    
    void print(){
        System.out.println("Edge: V1="+v1+" V2="+v2+" W="+w);
    }
    
    int getWeight(){
        return w;
    }
}
class GraphManager{
    Vertex[] vertices;
    Edge[] edges;
    int cnt;
    
    GraphManager(int vertices, int edges){
        this.vertices=new Vertex[vertices];
        this.edges=new Edge[edges];
        cnt=0;
    }
    
    void insert(int v1, int v2, int w){
        if(vertices[v1]==null){
            Vertex temp=new Vertex();
            vertices[v1]=temp;
        }
        
        if(vertices[v2]==null){
            Vertex temp=new Vertex();
            vertices[v2]=temp;
        }
            
        edges[cnt]=new Edge(v1,v2,w);
        vertices[v1].addEdge(cnt);
        vertices[v2].addEdge(cnt);
        cnt++;
    }
    
    void print(){
        System.out.println("Printing Vertices");
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]!=null)
                vertices[i].print(i);
        }
        
        System.out.println("Printing Edges");
        for(int i=0;i<cnt;i++){
           edges[i].print();
        }
    }

    void MST(){
        System.out.println("MST");
        Comparator <Edge> cmp=new Comparator<Edge>(){
            public int compare(Edge E1, Edge E2){
                return E1.w-E2.w;
            }
        };
        
        PriorityQueue <Edge> pq=new PriorityQueue<Edge>(11,cmp);
        Vertex temp=vertices[1];
        vertices[1].mark();
        for(int i=0;i<temp.getEdges().size();i++){
            pq.add(edges[temp.getEdges().get(i)]);
            edges[temp.getEdges().get(i)].print();
        }
        
        while(pq.size()>0){
            Edge e=pq.poll();
            e.print();
            if(vertices[e.v1].marked==0 || vertices[e.v2].marked==0){
                System.out.print("In MST");
                e.print();
                int idx;
                if(vertices[e.v1].marked==0)
                    idx=e.v1;
                else
                    idx=e.v2;
                    
                for(int i=0;i<vertices[idx].getEdges().size();i++){
                    pq.add(edges[vertices[idx].getEdges().get(i)]);
                }
                vertices[idx].mark();
            }
            
        }
    }
}

class GraphTest{

    public static void main(String[] args){
        GraphManager G=new GraphManager(5,10);
        G.insert(1,3,1);
        G.insert(1,2,2);
        G.insert(2,3,5);
        G.print();
        G.MST();
    }
}

import java.util.*;
 
class Node{
	public int data;
	public boolean visited;
	ArrayList <Node> edges;
	
	Node(int data){
		this.data=data;
		edges=new ArrayList<Node> ();
		visited=false;
	}
	
	void addEdge(Node temp){
		edges.add(temp);
	}
	
	ArrayList <Node> getEdges(){
		return edges;
	}
	
	void print(){
		System.out.println("Node="+data);
		for (int i=0;i<edges.size();i++){
			System.out.println(edges.get(i).data);
		}
		System.out.println("End of Node Data");
	}
}

class Graph{

	ArrayList <Node> Vertices;
	
	
	Graph(){
		Vertices=new ArrayList <Node> ();
	}
	
	Node getNode(int data){
		for(int i=0;i<Vertices.size();i++){
			if (Vertices.get(i).data==data)
				return Vertices.get(i);
		}
		return null;
	}
	
	void insert(int data, int[] edges){
		Node vertex=getNode(data);
		if (vertex==null)
			vertex=new Node(data);
		Vertices.add(vertex);
		for (int i=0;i<edges.length;i++){
			Node temp=getNode(edges[i]);
			if (temp==null)
				temp=new Node(edges[i]);
			vertex.addEdge(temp);
		}
	}
	
	ArrayList <Node> getVertices(){
		return Vertices;
	}
	
	void print(){
		System.out.println("Printing Graph");
		for (int i=0;i<Vertices.size();i++){
			Node temp_node=Vertices.get(i);
			temp_node.print();
			//System.out.print(temp_node.data);
			//ArrayList <Node> temp_edges=temp_node.getEdges();
			//for (int j=0;j<temp_edges.size();j++){
			//	System.out.print("\t"+temp_edges.get(j).data);
			//}
			//System.out.println();
		}
		System.out.println("---------------");
	}

	void BFS(Graph G){
		System.out.println("BFS");
		Queue <Node> Q=new LinkedList<Node> ();
		ArrayList <Node> vertices=G.getVertices();
		Q.add(vertices.get(0));
		vertices.get(0).visited=true;
		
		while(Q.size()>0){
			//G.print();
			Node temp=Q.poll();
			System.out.println(temp.data);
			//temp.print();
			ArrayList <Node> edges=temp.getEdges();
			for(int i=0;i<edges.size();i++){
				Node temp2=getNode(edges.get(i).data);
				//temp2.print();
				 if(temp2.visited==false){
					 temp2.visited=true;
					 Q.add(temp2);
				 }
			}
			
		}
	}
}

class GraphUtil{
	public static void main(String [] args){
		System.out.println("Graph and methods");
		Graph G=new Graph();
		G.insert(1,new int[]{3,5});
		G.insert(3,new int[]{1,7});
		G.insert(5,new int[]{1,7});
		G.insert(7,new int[]{3,5});
		//G.print();
		G.BFS(G);
		
	}
	
}
class Node{
	int data;
	Node next;
	Node(int data){
	this.data=data;
	next=null;
}
void print(){
	System.out.println(data);
}
}

class LinkedList{
	Node head;
	Node tail;

	LinkedList(){
		head=null;
		tail=null;
}

boolean insertAfter(Node n, Node temp){
	if (n==null){
		Node temp2=head;
		head=temp;
		head.next=temp2;
		if(tail==null)
			tail=temp;
	return true;
	}else{
		Node temp2=head;
		while(temp2!=null){
			if(temp2.data==n.data){
				Node temp3=temp2.next;
				temp2.next=temp;
				temp.next=temp3;
				if(temp2==tail)
					tail=temp;
				return true;
			}
			temp2=temp2.next;
		}
}
	return false;
}

boolean remove(Node n){
	Node temp=head;
	Node prev=null;
while(temp!=null){
	if(temp.data==n.data){
if(temp==head)
	head=temp.next;
if(temp==tail)
	tail=prev;
	if(prev!=null){
	prev.next=temp.next;
	}
temp.next=null;
return true;
}
prev=temp;
temp=temp.next;

}
return false;
}

void print(){
	Node temp=head;
	System.out.println("Head="+head.data);
	System.out.println("Tail="+tail.data);
	while(temp!=null){
		temp.print();
		temp=temp.next;
	}
}
}
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

class Test{

	public static void main(String[] args){
		LinkedList LL=new LinkedList();
		Node n1=new Node(1);
		LL.insertAfter(null,n1);
		Node n2=new Node(2);
		LL.insertAfter(null,n2);
		LL.print();
		LL.remove(n1);
		LL.print();
	}
}
import java.util.*;

class Aaagmnrs{
    public String[] anagrams(String[] phrases){
    	HashMap<String, Integer> map=new HashMap<String, Integer> ();
        String[] results=new String[phrases.length];
        int cnt=0;
        for (int i=0;i<phrases.length;i++){
            char c[]=phrases[i].replaceAll("\\s+","").toLowerCase().toCharArray();
            Arrays.sort(c);
            String temp=new String(c);
			System.out.println("temp="+temp);
            if(!map.containsKey(temp)){
            	map.put(temp,1);
                results[cnt++]=phrases[i];
				System.out.println(phrases[i]);
            }
        }
        return results;
    }
}

class AMGTest{
	public static void main(String[] args){
		String[] phrases={ "Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };
		Aaagmnrs A=new Aaagmnrs();
		A.anagrams(phrases);
	}
}
import sys


a=[5,4,6,9,2,10]
SUM=12
i=0
j=0
_sum=0
while(j<len(a)+1):
	print _sum
	if(_sum<SUM):
		_sum+=a[j]
		j+=1
	elif(_sum>SUM):
		_sum-=a[i]
		i+=1
	else:
		print i, j-1
		break;

import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	void print(){
		System.out.println(data);
	}
}

class BST{
	Node root;
	
	BST(){
		root=null;
	}
	
	Node insertR(Node temp,int data){
		if (temp==null){
			return new Node(data);
		}else{
			if (data<temp.data)
				temp.left=insertR(temp.left,data);
			else
				temp.right=insertR(temp.right,data);
			return temp;
		}
	}
	
	void insertL(Node root,int data){
		Node temp=root;
		while(true){
			if(data<temp.data){
				if(temp.left==null){
					temp.left=new Node(data);
					break;
				}
				else
					temp=temp.left;
			}
			else{
			if(temp.right==null){
				temp.right=new Node(data);
				break;
			}
			else
				temp=temp.right;
		}
		}
	}
	
	void inorder(Node temp){
		if(temp==null)
			return;
		else{
			inorder(temp.left);
			System.out.println(temp.data);
			inorder(temp.right);
		}	
	}
	
	void preorder(Node temp){
		if(temp==null)
			return;
		else{
			System.out.println(temp.data);
			preorder(temp.left);
			preorder(temp.right);
		}	
	}
	
	void postorder(Node temp){
		if(temp==null)
			return;
		else{
			postorder(temp.left);
			postorder(temp.right);
			System.out.println(temp.data);
		}	
	}
	
	void preorderI(Node root){
		Stack<Node> S=new Stack<Node>();
		S.push(root);
		while(S.size()>0){
			Node temp=S.pop();
			System.out.println(temp.data);
			if(temp.right!=null)
				S.push(temp.right);
			if(temp.left!=null)
				S.push(temp.left);
		}
	}
	
	void inorderI(Node root){
		Node temp=root;
		Stack <Node> S=new Stack<Node>();
		//S.push(temp);
		do{	
			if(temp!=null){
				//System.out.println(temp.data);
				S.push(temp);
				temp=temp.left;
			}
			else if(!S.isEmpty()){
				temp=S.pop();
				System.out.println(temp.data);
				temp=temp.right;
			}else
				break;
		}while(true);
	}
	
	void postorderI(Node root){
		Node temp=root;
		Stack<Node> S=new Stack<Node>();
		S.push(temp);
		while(!S.isEmpty()){
			if(temp==null)
				temp=S.pop();
			
			if(temp.right!=null){
				S.push(temp.right);
				S.push(temp);
			}else{
				S.push(temp);
			}
			temp=temp.left;
					
		}
	}
	
	Node findMin(Node temp){
		if(temp.left==null)
			return temp;
		else
			return findMin(temp.left);
	}

	Node inorderSucc(Node root, Node n){
		if(n.right!=null){
			return findMin(n.right);
		}
		else{
			Node suc=null;
			while(root!=null){
			
				if(n.data<root.data){
					suc=root;
					root=root.left;
				}else if(n.data>root.data){
					root=root.right;
				}else
					break;
			}
		return suc;
		}
	}
	
	
}
import java.util.*;

class HM{
	
	char firstNonRepeatedChar(char[] input){
		
		HashMap <Character, Integer> map=new HashMap<Character, Integer>();
		
		for(int i=0;i<input.length;i++){
			if(map.containsKey(input[i])){
				map.put(input[i],map.get(input[i])+1);
			}else{
				map.put(input[i],1);
			}
		}
		for(int i=0;i<input.length;i++){
			if(map.get(input[i])==1)
				return input[i];
		}
		
		return '\0';
		
	}
	
	class Student{
		String name;
		String test_id;
		double marks;
	}
	
	HashMap<String, Double> getAvg( ArrayList<Student>data){
		HashMap <String, Double> results=new HashMap<String, Double>();
		
		HashMap <String, HashMap<String, Double>> map=new HashMap <String, HashMap<String, Double>>();
		HashMap<String, Double> tests;
		
		Iterator<Student> itr=data.iterator();
		while(itr.hasNext()){
			Student temp=itr.next();
			
			if(map.containsKey(temp.name)){
				tests=map.get(temp.name);
				if(tests.containsKey(temp.test_id)){
					if(tests.get(temp.test_id)<temp.marks){
						tests.put(temp.test_id,temp.marks);
					}
				}else{
					tests.put(temp.test_id,temp.marks);
				}
			}else{
				 tests=new  HashMap<String, Double>();
				 tests.put(temp.test_id,temp.marks);
				 map.put(temp.name,tests);
			}
			
		}
		
		Comparator <Double> cmp=new Comparator<Double>(){
			public int compare(Double x, Double y){
				if(y<x) return -1;
				else if(y>x) return 1;
				return 0;
			}
		};
		int k=10;
		PriorityQueue <Double> pq=new PriorityQueue<Double>();
		for(String s:map.keySet()){
			tests=map.get(s);
			for(String id:tests.keySet()){
				if(pq.size()>k){
					pq.remove();
				}
				pq.add(tests.get(id));
			}
			while(pq.size()>0){
				pq.remove();
			}
		}
		
		return results;
		
		
	}
		
		
	
}


class HashMapTest{
	
	public static void main(String[] args){
		
		HM hm=new HM();
		
		String in="aabbccde";
		
		System.out.println(hm.firstNonRepeatedChar(in.toCharArray()));
		
	}
}

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

class TreeTest{
	
	public static void main(String [] args){
		BST B=new BST();
		B.root=new Node(10);
		B.insertL(B.root,5);
		B.insertL(B.root,11);
		B.insertL(B.root,1);
		B.inorderI(B.root);
		System.out.println(B.inorderSucc(B.root,B.root).data);
;	}
	
}
import os


class Node(object):
    data=0.0
    Next=None
    
    def __init__(self,data):
        self.data=data
        self.next=None
        
    def printNode(self):
        print self.data
    
    
class LinkedList(object):
    '''This class provides insertion in linkedlist'''
    head=None
    
    def insert(self,data):
        temp=Node(data)
        if self.head==None:
            self.head=temp
        else:
            cur=self.head
            while cur.Next!=None:
                cur=cur.Next
            cur.Next=temp
            
    def printLL(self):
        cur=self.head
        while cur!=None:
            cur.printNode()
            cur=cur.Next
            
if __name__=="__main__":
    LL=LinkedList()
    LL.insert(2)
    LL.insert(3)
    LL.printLL()
    print "Yes"
�
��Uc           @   sx   d  d l  Z  d e f d �  �  YZ d e f d �  �  YZ e d k rt e �  Z e j d � e j d � e j �  n  d S(	   i����Nt   Nodec           B   s&   e  Z d  Z d Z d �  Z d �  Z RS(   g        c         C   s   | |  _  d  |  _ d  S(   N(   t   datat   Nonet   next(   t   selfR   (    (    sV   /Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep/Python/1-LinkedList/LinkedList.pyt   __init__   s    	c         C   s   |  j  GHd  S(   N(   R   (   R   (    (    sV   /Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep/Python/1-LinkedList/LinkedList.pyt	   printNode   s    N(   t   __name__t
   __module__R   R   t   NextR   R   (    (    (    sV   /Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep/Python/1-LinkedList/LinkedList.pyR       s   	t
   LinkedListc           B   s&   e  Z d  Z d Z d �  Z d �  Z RS(   s+   This class provides insertion in linkedlistc         C   s\   t  | � } |  j d  k r' | |  _ n1 |  j } x | j d  k rN | j } q3 W| | _ d  S(   N(   R    t   headR   R	   (   R   R   t   tempt   cur(    (    sV   /Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep/Python/1-LinkedList/LinkedList.pyt   insert   s    	
c         C   s3   |  j  } x# | d  k r. | j �  | j } q Wd  S(   N(   R   R   R   R	   (   R   R
   (    (    sV   /Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep/Python/1-LinkedList/LinkedList.pyt   printLL   s    	
N(   R   R   t   __doc__R   R   R   R   (    (    (    sV   /Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep/Python/1-LinkedList/LinkedList.pyR
      s   	
t   __main__i   i   (   t   ost   objectR    R
   R   t   LLR   R   (    (    (    sV   /Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep/Python/1-LinkedList/LinkedList.pyt   <module>   s   	


from LinkedList import LinkedList



def printMiddle(head):
    slow=head
    fast=head
    print slow.Next
    
    while fast!=None and fast.Next!=None and fast.Next.Next!=None:
        fast=fast.Next.Next
        slow=slow.Next
    
    return slow.data
    
if __name__=="__main__":
    l=LinkedList()
    l.insert(1)
    l.insert(2)
    l.insert(3)
    l.insert(4)
    l.insert(5)
    l.insert(6)
    l.printLL()
    print printMiddle(l.head)

import random


def test_fun(name,**args):
    print name.count('a')
    print args


class myclass(object):
    a=0
    b=0
    
    def __init__(self,a=0,b=0):
        self.a=a
        self.b=b
   #def __eq__(self,other):
    #    if self.a==other.a:
     #       return True
      #  else:
       #     return False
    
    def __str__(self):
        return str(self.a)
    
    def printme(self):
        print self.a,self.b
        
    @staticmethod
    def stat_method():
        print "this is static method"

class c_class(myclass):
    
    def __init__(self,a=0,b=0,c=0):
        super(c_class,self).__init__(a,b)
        
if __name__=="__main__":
    
    my_dict={}
    for i in xrange(1,100,2):
        num=random.randint(1,10)
        print num
        if my_dict.has_key(num):
            my_dict[num]=my_dict[num]+1
        else:
            my_dict[num]=1;
    
    for key in my_dict.keys():
        print my_dict[key]
    
    print my_dict
    
    
    
    
import java.util.*;

class Aaagmnrs{
    public String[] anagrams(String[] phrases){
    	HashMap<String, Integer> map=new HashMap<String, Integer> ();
        String[] results=new String[phrases.length];
        int cnt=0;
        for (int i=0;i<phrases.length;i++){
            char c[]=phrases[i].replaceAll("\\s+","").toLowerCase().toCharArray();
            Arrays.sort(c);
            String temp=new String(c);
			System.out.println("temp="+temp);
            if(!map.containsKey(temp)){
            	map.put(temp,1);
                results[cnt++]=phrases[i];
				System.out.println(phrases[i]);
            }
        }
        return results;
    }
}

class AMGTest{
	public static void main(String[] args){
		String[] phrases={ "Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };
		Aaagmnrs A=new Aaagmnrs();
		A.anagrams(phrases);
	}
}
import sys


a=[5,4,6,9,2,10]
SUM=12
i=0
j=0
_sum=0
while(j<len(a)+1):
	print _sum
	if(_sum<SUM):
		_sum+=a[j]
		j+=1
	elif(_sum>SUM):
		_sum-=a[i]
		i+=1
	else:
		print i, j-1
		break;
