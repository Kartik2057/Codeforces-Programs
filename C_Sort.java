
/**
 * C_Sort
 */
import java.util.*;
import java.io.*;

public class C_Sort {

    // My code is my Identity
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        long t = sc.nextLong();
        first: while (t-- > 0) {
            // Vector <Pair> = new Vector<>();
            // Pair[] pairs=new Pair[n];
            int n = sc.nextInt();
            int q = sc.nextInt();
            char a[] = sc.next().toCharArray();
            char b[] = sc.next().toCharArray();
            int[][] aFreq = new int[26][n + 1];
            int[][] bFreq = new int[26][n + 1];

            
            for (int i = 0; i < n; i++) {
                for (int ch = 0; ch < 26; ch++) {
                    aFreq[ch][i + 1] = aFreq[ch][i];
                    bFreq[ch][i + 1] = bFreq[ch][i];
                }
                
                aFreq[a[i] - 'a'][i + 1]++;
                bFreq[b[i] - 'a'][i + 1]++;
            }

            for (int i = 0; i < q; i++) {
                int l = sc.nextInt()-1;
                int r = sc.nextInt()-1;

                int[] aCount = new int[26];
                int[] bCount = new int[26];

                for (int ch = 0; ch < 26; ch++) {
                    aCount[ch] = aFreq[ch][r + 1] - aFreq[ch][l];
                    bCount[ch] = bFreq[ch][r + 1] - bFreq[ch][l];
                }

                int changes = 0;
                for (int ch = 0; ch < 26; ch++) {
                    changes += Math.abs(aCount[ch] - bCount[ch]);
                }
                System.out.println(changes/2);
            }
        }
        pr.close();
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void print(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void print(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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