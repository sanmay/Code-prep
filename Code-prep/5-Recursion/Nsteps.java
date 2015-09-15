class Nsteps{

	static void Calculate_steps(int steps, String ans){
		if (steps<0)
			return;
		else if (steps<=0)
			System.out.println(ans);
		else{
			String temp=ans+" "+"1";
			Calculate_steps(steps-1,temp);
			temp=ans+" "+"2";
			Calculate_steps(steps-2,temp);
		}
	}

public static void main(String [] args){
	
	String ans="";
	Calculate_steps(4,ans);
}

}