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