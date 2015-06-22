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