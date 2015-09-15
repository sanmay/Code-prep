import java.lang.Math;
class BitTest{
	
	static String getBinary(int a, int bits){
		if(bits==1){
			if(a==1)
				return "1";
			else
				return "0";
		}
		else{
			System.out.println(Math.pow(2,bits-1));
			if(a>=Math.pow(2,bits-1)){
				a=a-(int)Math.pow(2,bits-1);
				return "1"+getBinary(a,bits-1);
			}
			else{
				return "0"+getBinary(a,bits-1);
			}
		}
	}
	
	static boolean getBit(int n, int bit){
		return ((n>>bit)&1)==1;
	}
	
	static boolean isPalindrome(int n){
		
		int cnt=31;
		
		while(cnt>=0){
			if(getBit(n,cnt))
				System.out.print('1');
			else
				System.out.print('0');
			cnt--;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		
		isPalindrome(15);
		
	}
}