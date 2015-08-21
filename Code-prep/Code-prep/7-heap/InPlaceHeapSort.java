

class InPlaceHeapSort{
	
	static void doInPlaceHeapSort(int[] a){
	//create max heap in place, start from end
	for(int i=a.length-1;i>=0;i--){
		
		if(2*i+2<a.length){
			if (a[i]<a[2*i+2] || a[i]<a[2*i+1]){
				if(a[2*i+2]>a[2*i+1]){
					int temp=a[2*i+2];
					a[2*i+2]=a[i];
					a[i]=temp;
				}else{
					int temp=a[2*i+1];
					a[2*i+1]=a[i];
					a[i]=temp;
				}
			}
		}
		else if(2*i+1<a.length){
			if(a[i]<a[2*i+1]){
				int temp=a[2*i+1];
				a[2*i+1]=a[i];
				a[i]=temp;
			}
		}
	}
	
	for(int i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
	}
	
	for(int cnt=a.length-1;cnt>=0;cnt--){
		System.out.println();
		System.out.println("cnt="+cnt+" a[cnt]="+a[cnt]+" a[0]="+a[0]);
		int temp2=a[0];
		a[0]=a[cnt];
		a[cnt]=temp2;
		System.out.println("a cnt="+cnt+" a[cnt]="+a[cnt]+" a[0]="+a[0]);
		int i=0;
		while(true){
			if(2*i+2<cnt){
				if (a[i]<a[2*i+2] || a[i]<a[2*i+1]){
					if(a[2*i+2]>a[2*i+1]){
						int temp=a[2*i+2];
						a[2*i+2]=a[i];
						a[i]=temp;
					}else{
						int temp=a[2*i+1];
						a[2*i+1]=a[i];
						a[i]=temp;
					}
				}else
					break;
			}
			else if(2*i+1<cnt){
				if(a[i]<a[2*i+1]){
					int temp=a[2*i+1];
					a[2*i+1]=a[i];
					a[i]=temp;
				}else
					break;
			}else
				break;
		}
	System.out.println();
	for(int k=0;k<a.length;k++){
		System.out.print(a[k]+" ");
	}
	}
	
	
}
	
	public static void main(String [] args){
		int[] input={5,3,1,2,10,12};
		doInPlaceHeapSort(input);
	}
}