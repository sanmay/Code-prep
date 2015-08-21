import java.util.*;

class Aaagmnrs{
    public String[] anagrams(String[] phrases){
    	HashMap<String, Integer> map=new HashMap<String, Integer> ();
        String[] results=new String[phrases.length];
        int cnt=0;
        for (int i=0;i<phrases.length;i++){
            char c[]=phrases[i].replaceAll("\\s+","").toLowerCase().toCharArray();
            Arrays.sort(c);
            String temp=new String(c);
			System.out.println("temp="+temp);
            if(!map.containsKey(temp)){
            	map.put(temp,1);
                results[cnt++]=phrases[i];
				System.out.println(phrases[i]);
            }
        }
        return results;
    }
}

class AMGTest{
	public static void main(String[] args){
		String[] phrases={ "Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };
		Aaagmnrs A=new Aaagmnrs();
		A.anagrams(phrases);
	}
}