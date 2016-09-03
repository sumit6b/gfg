package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinChange {
	private static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	private static int solve(int[] d, int N, int i){
		if(i==d.length){return 0;}
		if(N==0){return 1;}
		if(N<0){return 0;}
		return solve(d, N-d[i], i) + solve(d, N, i+1);
	}
	private static int solveDP(int[] d, int N){
		int dp[][] = new int[N+1][d.length];
		for(int j=0;j<d.length;j++){dp[0][j]=1;}
		for(int i=1;i<N+1;i++){
			for(int j=0;j<d.length;j++){
				int x = i - d[j]>=0? dp[i-d[j]][j] : 0;
				int y = j>=1?dp[i][j-1]:0;
				dp[i][j]=x+y;
			}
		}
		return dp[N][d.length-1];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		int[] denominations = new int[M];
		String[] ini = br.readLine().split(" ");
		for(int i=0;i<ini.length;i++){denominations[i] = Integer.parseInt(ini[i]);}
//		System.out.println(solve(denominations, N, 0));
		System.out.println(solveDP(denominations, N));
	}
}
