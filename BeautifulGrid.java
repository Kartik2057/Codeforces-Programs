import java.util.Scanner;

public class BeautifulGrid {

    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int result = countBeautifulGrids(n, m);
        System.out.println(result);
    }

    static int countBeautifulGrids(int n, int m) {
        int[][] dp = new int[m + 1][1 << n];
        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                for (int lastMask = 0; lastMask < (1 << n); lastMask++) {
                    if ((mask & lastMask) == 0) {
                        dp[i][mask] = (dp[i][mask] + dp[i - 1][lastMask]) % MOD;
                    }
                }
            }
        }

        int result = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int countOnes = Integer.bitCount(mask);
            if (countOnes % 2 == 0) {
                result = (result + dp[m][mask]) % MOD;
            }
        }

        return result;
    }
}
