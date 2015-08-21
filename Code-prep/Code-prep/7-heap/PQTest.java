
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