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