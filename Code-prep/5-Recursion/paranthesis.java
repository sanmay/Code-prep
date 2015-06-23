
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