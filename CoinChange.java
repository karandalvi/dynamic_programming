import java.util.Scanner;

public class CoinChange {
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the number of coin denominations: ");
    int d = s.nextInt();
    int[] denominations = new int[d];

    for (int i=0; i<d; i++) {
      System.out.println("Enter denomination " + (i+1) + ": ");
      denominations[i] = s.nextInt();
    }

    System.out.println("Enter the amount you want to exchange in return for coins: ");
    int amount = s.nextInt();

    exchange(amount, denominations);
  }

  public static void exchange(int amount, int[] denominations) {
    int n = denominations.length;
    int[] coins = new int[amount+1];
    int[] trace = new int[amount+1];

    coins[0] = 0;
    trace[0] = 0;
    for (int i=1; i<=amount; i++) {
      coins[i] = 2147000000;
      trace[i] = -1;
    }


    for(int i=0; i<n; i++) {
      for (int j=1; j<=amount; j++) {
        if (j>=denominations[i]) {
          if (coins[j] > (1 + coins[j-denominations[i]]))
            trace[j] = i;
          coins[j] = Math.min(coins[j], 1 + coins[j-denominations[i]]);
        }
      }
    }

    if (coins[amount]==2147000000)
    System.out.println("There is no coin denomination to exchange the entered amount.");
    else {
      String str = "";
      int nn = amount;
      while (nn > 0) {
       str = str + denominations[trace[nn]] + " ";
       nn = nn - denominations[trace[nn]];
      }
      System.out.println("The minimum number of coins required is " + coins[amount] + "\n" +
                        "The coins are -> " + str);//
      // for (int i=0; i<=amount; i++) {
      //   System.out.print((i) + ":" + trace[i] + " ");
      //}

    }
  }

}
