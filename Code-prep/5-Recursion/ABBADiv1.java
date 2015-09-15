public class ABBADiv1{
    static boolean canObtainUtil(String initial, String target){
        System.out.println(initial+" "+target);
       // System.out.println("\n");
    	if(initial.length()>target.length())
            return false;
        else if(initial.compareTo(target)==0){
            System.out.println("true="+initial);
            return true;
            }
        else{
           	return canObtainUtil(initial+"A",target) || canObtainUtil(new StringBuilder(initial+"B").reverse().toString(),target);
            
        }
    }
    public static String canObtain(String initial, String target){
    	if(canObtainUtil(initial,target))
           return "POSSIBLE";
        else
            return "IMPOSSIBLE";
           
           
    }
	
	public static void main(String[] args){
		
		System.out.println(canObtain("A","BABA"));
	}
}