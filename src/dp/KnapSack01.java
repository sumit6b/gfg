package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class KnapSack01 {
	public static int[] toIntArr(String[] arr){
		int[] ar = new int[arr.length];
		for(int i=0;i<arr.length;i++){ar[i]=Integer.parseInt(arr[i]);}
		return ar;
	}
	public static int knapSack(int[] weights, int[] values, int i, int W, int ans){
		if(i<values.length && weights[i]>W){
			return ans;
		}
		else if(i>=values.length || W<=0){
			return ans;
		}else{
			return Math.max(knapSack(weights, values, i+1, W-weights[i], ans + values[i]), 
					knapSack(weights, values, i+1, W, ans));
		}
	}
//	public static int knapSackDP(){
//		
//	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] values = toIntArr(br.readLine().split(" "));
		int[] weights = toIntArr(br.readLine().split(" "));
		int W = Integer.parseInt(br.readLine());
		System.out.println(knapSack(weights, values, 0, W,0));
//		System.out.println(knapSackDP());
	}
}
