

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
