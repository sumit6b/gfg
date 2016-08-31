package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EditDistance {
	public static int solve(String a, String b, int i, int j){
		if(i==a.length()){
			return b.length()-j;
		}
		if(j==b.length()){
			return a.length()-i;
		}
		if(a.charAt(i)==b.charAt(j)){
			return solve(a, b, i+1, j+1);
		}else{
			int localAns = Integer.MAX_VALUE;
			//replacing:
			localAns = Math.min(localAns, solve(a, b, i+1, j+1));
			//Deletion:
			localAns = Math.min(localAns, solve(a, b, i+1, j));
			//Insertion
			localAns = Math.min(localAns, solve(a, b, i, j+1));
			return localAns+1;
			
		}
	}
	
	
	public static int solveDP(String a, String b){
		int [][] dp = new int[a.length()+1][b.length()+1];
		for(int i=0;i<=a.length();i++){
			for(int j=0;j<=b.length();j++){
				if(i==0){
					dp[i][j]=j;
				}else if(j==0){
					dp[i][j]=i;
				}else if(a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
				}
				
			}
		}
		return dp[a.length()][b.length()];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//for GFG
//		int T = Integer.parseInt(br.readLine());
//		for(int t=0;t<T;t++){
//			String x = br.readLine();
//			String[] str = br.readLine().split(" ");
//			String a = str[0];
//			String b = str[1];
////			System.out.println(solve(a,b,0,0,0));
//			System.out.println(solveDP(a, b));
//		}
		//For Hackerrank
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String a=br.readLine();
			String b=br.readLine();
//			System.out.println(solve(a, b,0,0));
			System.out.println(solveDP(a, b));
		}
	}
}

//1
//84 87
//lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoq hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcaceh
