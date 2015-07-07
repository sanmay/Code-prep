
class FindElementTests{
	int idx=0;
	int getIndex(int[] input,int element, int start, int end){
		idx++;
		int middle=(start+end)/2;
		System.out.println("middle"+middle+" start="+start+" end="+end+" element="+element);
		if (idx>=10)
			return start;
		if (input[middle]==element)
			return middle;
		else{
			if (element<input[middle]){
				if (element>=input[start]){
					return getIndex(input,element, start, middle-1);
				}else{
					return getIndex(input,element, middle+1, end);
				}
			}else{
				if (element>input[end]){
					return getIndex(input,element, start, middle-1);
				}else{
					return getIndex(input,element, middle+1, end);
				}
			}
		}
	}
}

class FindElements{

	public static void main(String[] args){
		int [] input={6,7,8,9,10,1,2,3,4,5};
		FindElementTests F=new FindElementTests();
		System.out.println(F.getIndex(input,6,0,input.length-1));
	}

}