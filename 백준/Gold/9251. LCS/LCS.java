import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr1 = sc.next();
        String arr2 = sc.next();

        int[][] dp = new int[arr1.length()][arr2.length()];

        boolean flag = false;
        for (int i = 0; i < arr1.length(); i++) {
            if (flag) {
                dp[i][0] = 1;
            } else {
                if (arr1.charAt(i) == arr2.charAt(0)) {
                    flag = true;
                    dp[i][0] = 1;
                }
            }
        }

        flag = false;
        for (int i = 0; i < arr2.length(); i++) {
            if (flag) {
                dp[0][i] = 1;
            } else {
                if (arr1.charAt(0) == arr2.charAt(i)) {
                    flag = true;
                    dp[0][i] = 1;
                }
            }
        }

        for (int i = 1; i < arr1.length(); i++) {
            for (int j = 1; j < arr2.length(); j++) {
                if (arr1.charAt(i) == arr2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[arr1.length()-1][arr2.length()-1]);
    }
}
