import java.util.Scanner;
import java.util.Arrays;

public class WineSelection {
	
	static int[] rates = new int[] {15, 3, 5, 1, 4};
	static int[][] dp = new int[5][5];
	static int n = 5;
	public static void main (String[] args) {		
		for (int[] row: dp)
			Arrays.fill(row, -1);
		
		System.out.println(maxProfit(0, n-1));		
	}
	
	public static int maxProfit(int b, int e) {

		if (b > e)
			return 0;
					
		if (dp[b][e] != -1) 
			return dp[b][e];
		
		return 
		dp[b][e] = Math.max(rates[b] * (n-(e-b)) + maxProfit(b+1, e), rates[e] * (n-(e-b)) + maxProfit(b, e-1));
	
	}	
	
}