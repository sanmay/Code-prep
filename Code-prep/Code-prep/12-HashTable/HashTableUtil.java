
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