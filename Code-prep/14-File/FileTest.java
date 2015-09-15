import java.io.*;
import java.util.*;



class Files{
	String output="AllCodes.java";
	PrintWriter out;
	int cnt=0;
	Files() throws IOException{ 
		out=new PrintWriter(new BufferedWriter(new FileWriter(output)));
	}
	void ListFiles (String input) throws IOException{
		File f=new File(input);
		if(f.isFile()){
			if(f.getName().contains(".java")){
				System.out.println(f.getAbsolutePath());
				BufferedReader in=new BufferedReader(new FileReader(f.getAbsolutePath()));
				String s;
				while((s=in.readLine())!=null){
					cnt++;
					out.println(s);
				}
		}
		}else{
			String list[]=f.list();
			for(String s:list){
				ListFiles(input+'/'+s);
			}
		}
		
	}
	
}


class FileTest{
	
	
	public static void main(String[] args){
		Files f;
		try{
			f=new Files();
			f.ListFiles("/Users/sanmaypatil/Desktop/Codes/Code-prep/Code-prep");
			f.out.close();
			System.out.println(f.cnt);
		}catch(IOException e){
		System.err.println("Not able to open files");
		}
		
		
	}
}