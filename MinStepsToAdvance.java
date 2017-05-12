import java.util.Arrays;

public class MinStepsToAdvance {

	static int[] game = new int[] {5, 3, 1, 2, 3, 1, 3, 6, 3, 4, 5, 1, 2, 2, 2, 5};
	static int n = game.length;
	static int[] dp = new int[n];
	
	public static void main (String[] args) {
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[n-1] = 0;
		System.out.println("Can Reach? " + canReachEnd(game, n));
		System.out.println("Min Steps: " + minSteps(0));
	}
	
	public static boolean canReachEnd(int[] game, int n) {
		int furthestReachSoFar = 0, lastlndex = n - 1;
		for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex; ++i) {
			furthestReachSoFar = Math.max(furthestReachSoFar , i + game[i]);
		}
		return furthestReachSoFar >= lastlndex;
	}
	
	public static int minSteps(int i) {
		
		if (canReachEnd(game, n)) {
			String s = "";
			if (i == dp.length-1) 
				return 0;
			
			if (dp[i]!=Integer.MAX_VALUE)
				return dp[i];
			
			if (game[i]==0)
				 return dp[i] = Integer.MAX_VALUE;
			

			for (int j=1; j<=game[i] && (i+j)<n; j++) {
				dp[i] = Math.min(dp[i], 1 + Math.min(Integer.MAX_VALUE-1, minSteps(i+j)));
			}

			return dp[i];
		}
		else
			return -1;
	}
}