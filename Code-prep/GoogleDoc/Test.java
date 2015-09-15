
import java.lang.Math;
import java.util.*;
class Methods{

    char findNonRepeatedChar(String input){
	HashMap<Character,Integer> map=new HashMap<Character, Integer>();
	char[] temp=input.toCharArray();
	for(int i=0;i<temp.length;i++){
		if(map.containsKey(temp[i])){
			map.put(temp[i],map.get(temp[i])+1);
}else
	map.put(temp[i],1);
}
for(int i=0;i<temp.length;i++){
	if(map.get(temp[i])==1)
		return temp[i];
}
return '\0';
}


String reverseWords(String input){
    char[] src=input.toCharArray();
    char[] dest=new char[input.length()];
    char[] temp=new char[input.length()];
    int cnt=0;
    int current=src.length-1;
    for(int i=0;i<src.length;i++){
        if(src[i]!=' '){
            temp[cnt++]=src[i];
        }else{
            while(cnt>0){
                dest[current--]=temp[cnt-1];
                cnt--;
            }
            dest[current--]=' ';
        }
    }
    if(current>0){
        while(cnt>0){
                    dest[current--]=temp[cnt-1];
                    cnt--;
        }
    }
    return new String(dest);	
}

int stringToint(String input){
	char[] temp=input.toCharArray();
	int num=0;
	boolean neg=false;

	for(int i=temp.length-1;i>=0;i--){
		if(temp[i]=='-')
			neg=true;
		else{
			num+=(temp[i]-'0')*Math.pow(10,temp.length-i-1);
        }
    }

    if(neg)
        num*=-1;
	return num;
}

String intToString(int i){
	StringBuilder sb=new StringBuilder();
    boolean neg=false; 
	if (i<0)
		neg=true;

	while(Math.abs(i)>0){
		int mod=(Math.abs(i)%10)+'0';
        System.out.println(mod+" "+(int)'0');
		char temp=(char)mod;
        i=i/10;
        sb.append(temp);
    }
    if(neg)
        sb.append('-');
    return sb.reverse().toString();
}

int binarySearch(int[] input, int start, int end, int target){
	if(start>end)
		return -1;
	else{
		int mid=(start+end)/2;
		if(input[mid]==target)
			return mid;
		else{
			if(target<input[mid])
				return binarySearch(input, start,mid-1,target);
			else
				return binarySearch(input,mid+1, end, target);
            }
        }
    }

ArrayList<String> permute(String input){
    ArrayList <String> results=new ArrayList<String>();
    if(input.length()<=1){
        results.add(input);
        return results;
    }else{
        String c=input.substring(0,1);
        String rem=input.substring(1,input.length());
        ArrayList<String>temp=permute(rem);
        for(int i=0;i<temp.size();i++){
            String add_to=temp.get(i);
            for(int k=0;k<=add_to.length();k++){
                String result=add_to.substring(0,k)+c+add_to.substring(k,add_to.length());
                results.add(result);
            }
        }
        return results;
    }
}

void permuteR(String input, String rem){
	if(rem.length()<=0)
		return;
	else{
		for(int i=0;i<rem.length();i++){
            System.out.println(input+rem.substring(i,i+1));
            permuteR(input+rem.substring(i,i+1),rem.substring(i+1,rem.length()));
        }
		
}
}

}

class Test{

	public static void main(String[] args){
		Methods m=new Methods();
        int[] a={1,2,5,8,10};
        //System.out.println(m.binarySearch(a,0,a.length,1));
        
       // ArrayList <String> results=m.permute("PUNE");
      //  for(int i=0;i<results.size();i++){
       //     System.out.println(results.get(i));
       // }
       
       m.permuteR("","wxyz");
	}
}