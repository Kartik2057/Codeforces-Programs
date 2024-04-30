
/**
 * C_How_Does_the_Rook_Move
 */
import java.util.*;
import java.io.*;

public class C_How_Does_the_Rook_Move {
    static long mod = (long) 1e9 + 7;

    // My code is my Identity
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        long t = sc.nextLong();
        long dp[] = new long[(int) 1e6];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        first: while (t-- > 0) {
            // Vector <Pair> = new Vector<>();
            // Pair[] pairs=new Pair[n];
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                if (l == r)
                    n--;
                else
                    n -= 2;
            }
            long ans = recur(dp, n);
            System.out.println(ans);
        }
        pr.close();
    }

    static long recur(long dp[], int n) {
        if (dp[n] != -1)
            return dp[n];
        long ans = (recur(dp,n-1)%mod +(2*(n-1)*(recur(dp, n - 2)) % mod)) % mod;
        return dp[n] = ans;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static long andOperator(long a, long b) {
        int shiftcount = 0;
        while (a != b && a > 0) {
            shiftcount++;
            a = a >> 1;
            b = b >> 1;
        }
        return (a << shiftcount);
    }

}

class ArrayOfPairsSorter {
    static void sort(Pair[] arr) {
        Comparator<Pair> comparator = new Comparator<>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.y
                        - p1.y; // To compare the first element
                                // just
                                // change the variable from p1.y
                                // - p2.y to p1.x-p2.x.
            }
        };
        Arrays.sort(arr, comparator);
    }
}

class Pair {
    int x;
    int y;

    // Constructor
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Overriding toString method
    // for beautiful printing of pairs
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;

    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }
}