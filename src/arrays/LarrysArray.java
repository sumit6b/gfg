package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LarrysArray {
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print("\n");
	}
	public static void rotate(int[] arr, int i, int j){
		int temp = arr[i];
		for(int k=i+1;k<=j;k++){arr[k-1]=arr[k];}
		arr[j]=temp;
	}
	public static boolean compareArr(int[] a, int[] b){
		boolean ans=true;
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]){
				ans=false;
				break;
			}
		}
		return ans;
	}
	public static int[] decSort(int[] arr){
		Arrays.sort(arr);
		int[] ans = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			ans[i]=arr[arr.length-i-1];
		}
		return ans;
	}
	public static void main(String[]  args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String x = br.readLine();
			String[] inp = br.readLine().split(" ");
			int[] ini = new int[inp.length];
			for(int j=0;j<inp.length;j++){ini[j] = Integer.parseInt(inp[j]);} 
			for(int i=0;i<=inp.length-3;i++){
				for(int j=0;j<=inp.length-3-i;j++){
					int[] triplet = {ini[j], ini[j+1], ini[j+2]};
					Arrays.sort(triplet);
					while(ini[j+2]!=triplet[2]){rotate(ini, j, j+2);}
				}
			}
			int[] decArray = {ini[0], ini[1], ini[2]};
			int[] firstArray = {ini[0], ini[1], ini[2]};

			decArray = decSort(decArray);
			boolean ansb=false;
			for(int i=0;i<3;i++){
				if(compareArr(decArray, firstArray)){
					ansb=true;
					break;
				}else{
					rotate(firstArray,0,2);
				}
			}
			System.out.println(ansb?"NO":"YES");
		}
	}
}
