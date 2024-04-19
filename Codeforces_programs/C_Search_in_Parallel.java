/**
 * C_Search_in_Parallel
 */

import java.util.*;
import java.io.*;
public class C_Search_in_Parallel {

    //My code is my Identity
    public static void main(String[] args) 
    {
    FastScanner sc = new FastScanner(System.in);
    PrintWriter pr = new PrintWriter(System.out);
    long t=sc.nextLong();
    first:
    while(t-->0){
    //Vector <Pair> = new Vector<>();
    int n=sc.nextInt();
    int s1=sc.nextInt();
    int s2=sc.nextInt();
    int arr[]=new int[n];
    Pair[] pairs = new Pair[n];
    //String st = sc.next();
    //char c[]=st.toCharArray();
    
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
        pairs[i]=new Pair(i+1, arr[i]);
    }
    ArrayOfPairsSorter.sort(pairs);
    ArrayList<Integer> arr1=new ArrayList<>();
    ArrayList<Integer> arr2=new ArrayList<>();
    int t1=s1,t2=s2;
    for(int i=0;i<n;i++)
    {
        if(t2<t1)
        {
            arr2.add(pairs[i].x);
            t2+=s2;
        }
        else{
            arr1.add(pairs[i].x);
            t1+=s1;
        }
    }
    // pr.println(Arrays.toString(pairs));
    pr.print(arr1.size()+" ");
    for(int i=0;i<arr1.size();i++)
    {
        pr.print(arr1.get(i)+" ");
    }
    pr.println();
    pr.print(arr2.size()+" ");
    for(int i=0;i<arr2.size();i++)
    {
       pr.print(arr2.get(i)+" ");
    }
    pr.println();
    }
    pr.close();
    }
    static long gcd(long a, long b)
    {
    if (b == 0)
      return a;
    else
    return gcd(b,a%b);
    }
    static long andOperator(long a, long b)
    {
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
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
      // Overriding toString method
    //       for beautiful printing of pairs
    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ')';
    }
}
class FastScanner 
{
private BufferedReader reader = null;
private StringTokenizer tokenizer = null;
public FastScanner(InputStream in)
{
reader = new BufferedReader(new InputStreamReader(in));
tokenizer = null;
}
public String next() 
{
if (tokenizer == null || !tokenizer.hasMoreTokens()) 
{
try 
{
tokenizer = new StringTokenizer(reader.readLine());
} 
catch (IOException e)
{
throw new RuntimeException(e);
}
}
return tokenizer.nextToken();
}
public String nextLine()
{
if (tokenizer == null || !tokenizer.hasMoreTokens())
{
try
{
return reader.readLine();
} 
catch (IOException e)
{
throw new RuntimeException(e);
}
}
return tokenizer.nextToken(
);
}
public long nextLong() 
{
 return Long.parseLong(next());
}
public int nextInt()
{
return Integer.parseInt(next());
}
public double nextDouble() 
{
return Double.parseDouble(next());
}
public int[] nextIntArray(int n)
{
int[] a = new int[n];
for (int i = 0; i < n; i++)
a[i] = nextInt();
return a;
}
public long[] nextLongArray(int n)
{
long[] a = new long[n];
for (int i = 0; i < n; i++)
a[i] = nextLong();
return a;
} 
}