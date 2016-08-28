package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimumNumberOfJumpsNeededToReachEnd {
	public static int mnjntr(int[] arr, int i){
		int localAns = Integer.MAX_VALUE;
		if(arr[i]>=arr.length-i-1){
			return 1;
		}
		for(int j=1;j<=arr[i];j++){
			localAns = Math.min(localAns, mnjntr(arr, i+j));
		}
		return localAns+1;
	}
	public static void main(String[] args) throws Exception{
		int[] arr = {1,3,5,8,9,2,6,7,6,8,9};
//		int[] arr = {1,1,0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String x = br.readLine();
			String[] inp = br.readLine().split(" ");
			int[] ini = new int[inp.length];
			for(int i=0;i<inp.length;i++){ini[i]=Integer.parseInt(inp[i]);}
			System.out.println(mnjntr(ini,0));
		}
		
	}
}
