
class money{
	
	static void getways(int amt,String ways, int lastC){
		if (amt<=0){
			System.out.println("Final="+ways);
			return;
		}
		else{
			if(amt>=25 && lastC>=25){
				getways(amt-25,ways+Integer.toString(25)+",",25);
			}
			if(amt>=10 && lastC>=10){
				getways(amt-10,ways+Integer.toString(10)+",",10);
			}
			if(amt>=5 && lastC>=5){
				getways(amt-5,ways+Integer.toString(5)+",",5);
			}
			if(amt>=1 && lastC>=1){
				getways(amt-1,ways+Integer.toString(1)+",",1);
			}
		}
		
	}
	
	public static void main(String []args){
		System.out.println("This shows ways to add up to money");
		String ways="";
		getways(10,ways,10);
	}
}