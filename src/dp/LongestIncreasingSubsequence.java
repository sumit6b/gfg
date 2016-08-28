package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static int lis(int arr[], int l[], int i, int ans){
		if(i>l.length-1){
			return ans;
		}
		int currentMax = Integer.MIN_VALUE;
		for(int k=0;k<i;k++){
			currentMax = arr[k] < arr[i] ? l[k] > currentMax ? l[k] : currentMax : currentMax;
		}
		l[i] = currentMax>0 ? currentMax+1: 1;
		ans = ans>l[i] ? ans : l[i];
		return lis(arr, l, i+1, ans);
	}
	
	private static int largestFittingIndex(ArrayList<Integer> ls, int elementValue){
		int sm=-1, lr=ls.size()-1;
		while(lr-sm>1){
			int m = sm + (lr-sm)/2;
			if(ls.get(m)>=elementValue){lr=m;}
			else{sm=m;}
		}
		return lr;
	}
	
	public static int lisnlogn(int[] arr){
		int ans=0;
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ls.add(arr[0]);
		for(int i=1;i<arr.length;i++){
				if(arr[i]<ls.get(0)){
					ls.set(0, arr[i]);
				}else if(arr[i]>ls.get(ls.size()-1)){
					ls.add(arr[i]);
				}else{
					ls.set(largestFittingIndex(ls, arr[i]), arr[i]);
				}
		}
		return ls.size();
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] ini = new int[T];
		for(int t=0;t<T;t++){ini[t]=Integer.parseInt(br.readLine());}
		int[] l = new int[T];
		l[0]=1;
//		System.out.println(lis(ini,l,1,0));
		System.out.println(lisnlogn(ini));
	}
}

