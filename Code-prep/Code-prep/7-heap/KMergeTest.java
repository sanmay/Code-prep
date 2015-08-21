
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