package dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestCommonSubsequence{
	public static int lcs(String a, String b, int i, int j, int ans){
		if(i<0 || j<0){
			return ans;
		}
		if(a.charAt(i)==b.charAt(j)){
			return lcs(a,b,i-1,j-1, ++ans);
		}else{
			return Math.max(lcs(a,b,i-1,j,ans), lcs(a,b,i,j-1,ans));
		}
	}
	public static int lcsDP(String a, String b){
		int[][] arr= new int[a.length()][b.length()];
		arr[0][0] = a.charAt(0)==b.charAt(0)?1:0;
		for(int j=1;j<b.length();j++){
			arr[0][j] = a.charAt(0)==b.charAt(j)?1:arr[0][j-1];
		}
		for(int i=1;i<a.length();i++){
			arr[i][0] = a.charAt(i)==b.charAt(0)?1:arr[i-1][0];
		}
		for(int i=1;i<a.length();i++){
			for(int j=1;j<b.length();j++){
				arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
				if(a.charAt(i)==b.charAt(j)){
					arr[i][j]=arr[i-1][j-1]+1;
				}
			}
		}
		return arr[a.length()-1][b.length()-1];
	}
	public static ArrayList<Integer> lcsHackerRank(int[] a, int[] b){
		
		ArrayList<ArrayList<ArrayList<Integer>>> arr = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<Integer> sequence,sequence1,sequence2;
		ArrayList<ArrayList<Integer>> row;
		for(int i=0;i<a.length;i++){
			row = new ArrayList<ArrayList<Integer>>();
			for(int j=0;j<b.length;j++){
				sequence = new ArrayList<Integer>(); 
				row.add(sequence);
			}
			arr.add(row);
		}
		if(a[0]==b[0]){
			arr.get(0).get(0).add(a[0]);
		}
		for(int j=1;j<b.length;j++){
			if(a[0]==b[j]){
				arr.get(0).get(j).add(b[j]);
			}else{
				sequence = arr.get(0).get(j-1);
				arr.get(0).set(j, (ArrayList<Integer>) sequence.clone());
			}
		}
		for(int i=1;i<a.length;i++){
			if(a[i]==b[0]){
				arr.get(i).get(0).add(a[i]);
			}else{
				sequence = arr.get(i-1).get(0);
				arr.get(i).set(i, (ArrayList<Integer>) sequence.clone());
			}
		}
		for(int i=1;i<a.length;i++){
			for(int j=1;j<b.length;j++){
				sequence1 = arr.get(i-1).get(j);
				sequence2 = arr.get(i).get(j-1);
				arr.get(i).set(j, sequence1.size()>sequence2.size()? sequence1: sequence2);
				if(a[i]==b[j]){
					sequence = arr.get(i-1).get(j-1);
					sequence = (ArrayList<Integer>) sequence.clone();
					sequence.add(a[i]);
					arr.get(i).set(j, sequence);
				}
			}
		}
		return arr.get(a.length-1).get(b.length-1);
	}
	public static void print(ArrayList<Integer> lis){
		for(int i=0;i<lis.size();i++){
			if(i!=0){System.out.print(' ');}
			System.out.print(lis.get(i));
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		for(int t=0;t<T;t++){
//			String x = br.readLine();
//			String a = br.readLine();
//			String b = br.readLine();
//			System.out.println(lcs(a,b,a.length()-1, b.length()-1, 0));
//			System.out.println(lcsDP(a,b));
//		}
		//For hackerrank
		String x = br.readLine();
		String[] inp = br.readLine().split(" ");
		int[] a = new int[inp.length];
		for(int i=0;i<inp.length;i++){a[i]=Integer.parseInt(inp[i]);}
		inp = br.readLine().split(" ");
		int[] b = new int[inp.length];
		for(int i=0;i<inp.length;i++){b[i]=Integer.parseInt(inp[i]);}
		print((lcsHackerRank(a,b)));
	}
}
