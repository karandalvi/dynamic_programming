import java.util.Scanner;

public class LongestCommonSubsequence {
	
	public static void main (String args[]) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Sequence 1: ");
		String seq1 = s.next();
		
		System.out.println("Enter Sequence 2: ");
		String seq2 = s.next();
		
		s.close();
		
		System.out.println("Sequence 1: " + seq1 + "\nSequence 2: " + seq2);
		
		int maxLength = LCS(seq1, seq2);
		System.out.println("Length of longest common subsequence is " + maxLength);
	}
	
	public static int LCS(String seq1, String seq2) {
		
		String[][] str = new String[seq1.length()+1][seq2.length()+1];
		int[][] dp = new int[seq1.length()+1][seq2.length()+1];
		char[] str1 = new char[seq1.length()+1];
		char[] str2 = new char[seq2.length()+1];
		str1[0] = 'a';
		str2[0] = 'a';
		
		for(int i=0; i<seq1.length();i++)
			str1[i+1] = seq1.charAt(i);
		
		for(int i=0; i<seq2.length();i++)
			str2[i+1] = seq2.charAt(i);
		
		for(int i=0; i<=seq1.length(); i++) {
			for(int j=0; j<=seq2.length(); j++) {
				dp[i][j] = 0;
				str[i][j] = "";
			}
		}
		
		for(int i=1; i<=seq1.length(); i++) {
			for(int j=1; j<=seq2.length(); j++) {
				if (str1[i] == str2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					str[i][j] = str[i-1][j-1] + str1[i];
				}
					else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
						if(dp[i-1][j] > dp[i][j-1])
							str[i][j] = str[i-1][j];
						else
							str[i][j] = str[i][j-1];
					}
				}
			
			}
		System.out.println("The longest common subsequence is " + str[seq1.length()][seq2.length()]);
		return dp[seq1.length()][seq2.length()];
		}
		
			
	}
