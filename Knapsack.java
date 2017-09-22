import java.util.Scanner;

public class Knapsack {

	public static void main (String args[]) {
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of items: ");
		int n = s.nextInt();
		
		Item[] itemList = new Item[n];
		int weight, value;
		int[] weights = new int[n+1];
		int[] values = new int[n+1];
		weights[0] = 0;
		values[0] = 0;
		
		for (int i=0; i<n; i++) {
			System.out.println("Enter weight for element " + (i+1) + ": ");
			weight = s.nextInt();
			weights[i+1] = weight;
			System.out.println("Enter value for element " + (i+1) + ": ");
			value = s.nextInt();
			values[i+1] = value;
			itemList[i] = new Item(weight, value);
		}
		
		System.out.println("Enter the maximum weight capacity of your bag: ");
		int capacity = s.nextInt();
		
		int solution = findMax(itemList, weights, values, capacity, n);
		System.out.println("You can hold items of " + solution + " value at max.");
			
	}
	
	public static int findMax(Item[] list, int[] weights, int[] values, int capacity, int n) {
		
		int[][] dp = new int[n+1][capacity+1];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<=capacity; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i=1; i<=n; i++) {
			for (int j=0; j<=capacity; j++) {
				
				if (j == 0)
					dp[i][j] = 0;
				else {
					if (weights[i] <= j) {
						dp[i][j] = Math.max((values[i] + dp[i-1][j-weights[i]]), dp[i-1][j]);
					}
					else {
							dp[i][j] = dp[i-1][j];
						}
					}
					
				}
			}
		return dp[n][capacity];	
		}
		
		
	}

class Item {

	int weight;
	int value;

	public Item (int w, int v) {
		weight = w;
		value = v;
	}
}
