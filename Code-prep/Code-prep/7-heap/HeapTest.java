

class Heap{
	int input[];
	int end;
	
	Heap(){
		input=new int[10];
		end=0;
	}
	
	void insert(int data){
		input[end]=data;
		int i=end;
		end++;
		while(input[i]<input[i/2]){
			int temp=input[i];
			input[i]=input[i/2];
			input[i/2]=temp;
			i=i/2;
		}
	}
	
	int ExtractMin(){
		int min=input[0];
		input[0]=input[end-1];
		end=end-1;
		int j=0;
		
		while(j*2+1<end){
			int flag=0;
			if (input[j]>input[j*2]){
				int temp=input[j];
				input[j]=input[j*2];
				input[j*2]=temp;
				j=j*2;
				flag=1;
			}else{
				int temp=input[j];
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
			
			System.out.print("\t"+input[i]);
			
		}
	}
}

class HeapTest {
	public static void main(String[] args){
		
		System.out.println("This is heap test");
		Heap h=new Heap();
		h.insert(2);
		h.print();
		h.insert(1);
		h.print();
		h.insert(4);
		h.insert(5);
		h.insert(0);
		h.print();
		System.out.println("Min="+h.ExtractMin());
		h.print();
		System.out.println("Min="+h.ExtractMin());
		h.print();
	}
}