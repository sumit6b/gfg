package dp;

public class MatrixChainMultiplication {
	public static void printArr(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(j!=0){System.out.print(", ");}
				System.out.print(arr[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.print("\n");
	}
	public static int solveDP(int[] arr){
		int[][] dp = new int[arr.length-2][arr.length-2];
		for(int i=0;i<arr.length-2;i++){dp[0][i] = arr[i]*arr[i+1]*arr[i+2];}
		for(int i=1;i<arr.length-2;i++){
			for(int j=i;j<arr.length-2;j++){
				int a = dp[i-1][j-1] + arr[j-i]*arr[j+1]*arr[j+2];
				int b = dp[i-1][j] + arr[j-i]*arr[j-i+1]*arr[j+2];
				if(a<b){
					dp[i][j] = a;
				}else{
					dp[i][j] = b;
				}
			}
		}
		return dp[arr.length-3][arr.length-3];
	}
	public static void main(String[] args){
		int[] arr = {10, 20, 30};
		System.out.println(solveDP(arr));
	}
}
