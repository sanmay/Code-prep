
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