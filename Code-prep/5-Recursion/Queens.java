




class Queens{
	
	static void print(int chessboard[][]){
		for (int w=0;w<chessboard.length;w++){
			System.out.println();
			for (int v=0;v<chessboard.length;v++){
				System.out.print(chessboard[w][v]);
			}
		}
	}
	
	static void getWays(int chessboard[][],int queens,String result){
		//String result="";
		if (queens==0){
			System.out.println("Final="+result);
			return;
		}
		else{
				for (int i=0;i<chessboard.length;i++){
				for (int j=0;j<chessboard.length;j++){
					if(queens==2){
						for (int w=0;w<chessboard.length;w++){
							for (int v=0;v<chessboard.length;v++){
								result="";
								chessboard[w][v]=0;
							}
						}
					}
					if(chessboard[i][j]==0){
						for (int y=0;y<chessboard.length;y++){
							chessboard[i][y]=1;
							chessboard[y][j]=1;
							if(i+y<3 && j+y<3)
								chessboard[i+y][j+y]=1;
							if(i-y>-1 && j-y>-1)
								chessboard[i-y][j-y]=1;
							if(i+y<3 && j-y>-1)
								chessboard[i+y][j-y]=1;
							if(i-y>-1 && j+y<3)
								chessboard[i-y][j+y]=1;
						}
						result=result+"("+Integer.toString(i)+" "+Integer.toString(j)+"),";
						//System.out.println("Intermediate="+result+"Queen="+queens);
						//print(chessboard);
						getWays(chessboard,queens-1,result);
							
					}
				}
			}
		
		}
		return;
	}
	
	public static void main(String[] args){
		int chessboard[][]=new int[3][3];
		int queens=2;
		System.out.println("Method gives ways to arrange queens so they wont kill each other :P");
		for (int i=0;i<chessboard.length;i++){
			for (int j=0;j<chessboard.length;j++){
				chessboard[i][j]=0;
			}
		}
		String result="";
		getWays(chessboard,queens,result);
	}
}