package dp;

public class MinCostPath {
	
	public static int solve(int[][] arr, int m, int n){
		int localMin = Integer.MIN_VALUE;
		if(m>1){
			arr[m][n] = Math.min(localMin, solve(arr, m-1, n));
		}
		if(n>1){
			arr[m][n] = Math.min(localMin, solve(arr, m, n-1));
		}
		if(m>1 && n>1){
			arr[m][n] = solve(arr, m-1, n-1);
		}
		return arr[m][n];
	}
	public static void printArray(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(j!=0){System.out.print(", ");}
				System.out.print(arr[i][j]);
			}
			System.out.print('\n');
		}
	}
	public static int solveDP(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				
				if(i>0 || j>0){
					if(i==0){
						arr[i][j]+=arr[i][j-1];
					}else if(j==0){
						arr[i][j]+=arr[i-1][j];
					}else{
						arr[i][j] += Math.min(arr[i-1][j-1], Math.min(arr[i][j-1], arr[i-1][j]));	
					}
				}
			}
		}
		return arr[arr.length-1][arr[0].length-1];
	}
	public static void main(String[] args){
		int arr[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
//		System.out.println(solve(arr, arr.length-1, arr[0].length-1));
		System.out.println(solveDP(arr));
	} 
}
