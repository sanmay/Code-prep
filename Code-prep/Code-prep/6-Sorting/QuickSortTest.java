
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