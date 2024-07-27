
/**
 * C_Have_Your_Cake_and_Eat_It_Too
 */
import java.util.*;
import java.io.*;

public class C_Have_Your_Cake_and_Eat_It_Too {

    // My code is my Identity
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        long t = sc.nextLong();
        first: while (t-- > 0) {
            // Vector <Pair> = new Vector<>();
            // Pair[] pairs=new Pair[n];
            int n = sc.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            long c[] = new long[n];
            // String st = sc.next();
            // char c[]=st.toCharArray();
            long tot = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                tot += a[i];
            }
            for (int i = 0; i < n; i++)
                b[i] = sc.nextLong();
            for (int i = 0; i < n; i++)
                c[i] = sc.nextLong();
            tot = (long) Math.ceil(tot / 3.0);

            boolean res = solve(a, b, c, tot, 0);
            res = res ? true : solve(a, c, b, tot, 1);
            res = res ? true : solve(b, c, a, tot, 2);
            res = res ? true : solve(b, a, c, tot, 3);
            res = res ? true : solve(c, a, b, tot, 4);
            res = res ? true : solve(c, b, a, tot, 5);
            if (!res)
                System.out.println("-1");
        }
        pr.close();
    }

    private static boolean solve(long[] a, long[] b, long[] c, long tot, int choice) {
        int n = a.length;
        int la = 1, ra = -1, lb = -1, rb = -1, lc = -1, rc = n;
        long suma = 0, sumb = 0, sumc = 0;
        // System.out.println(tot);
        int i, j, j2;
        for (i = 0; i < n; i++) {
            suma += a[i];
            if (suma < tot)
                continue;
            ra = i + 1;
            lb = i + 2;
            break;
        }
        for (j = i + 1; j < n; j++) {
            sumb += b[j];
            if (sumb < tot)
                continue;
            rb = j + 1;
            lc = j + 2;
            break;
        }
        for (j2 = j + 1; j2 < n; j2++) {
            sumc += c[j2];
        }
        if (suma < tot || sumc < tot || sumb < tot)
            return false;
        // System.out.println("choice = "+choice+" suma = "+suma+" sumb = "+sumb+" sumc = "+sumc);    
        if (choice == 0){
            System.out.println(la + " " + ra + " " + lb + " " + rb + " " + lc + " " + rc);
        } else if (choice == 1) {
            System.out.println(la + " " + ra + " " + lc + " " + rc + " " + lb + " " + rb);
        } else if (choice == 2) {
            System.out.println(lc + " " + rc + " " + la + " " + ra + " " + lb + " " + rb);
        } else if (choice == 3) {
            System.out.println(lb + " " + rb + " " + la + " " + ra + " " + lc + " " + rc);
        } else if (choice == 4) {
            System.out.println(lb + " " + rb + " " + lc + " " + rc + " " + la + " " + ra);
        } else {
            System.out.println(lc + " " + rc + " " + lb + " " + rb + " " + la + " " + ra);
        }
        return true;
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