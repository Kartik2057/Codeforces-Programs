/**
 * B_Maximum_Product
 */

 import java.util.*;
 import java.io.*;
public class B_Maximum_Product {

    //My code is my Identity
    public static void main(String[] args) 
    {
    FastScanner sc = new FastScanner(System.in);
    PrintWriter pr = new PrintWriter(System.out);
    long t=sc.nextLong();
    first:
    while(t-->0){
    //Vector <Pair> = new Vector<>();
    //Pair[] pairs=new Pair[n];
    int n=sc.nextInt();
    long arr[]=new long[n];
    //String st = sc.next();
    //char c[]=st.toCharArray();
    int pos=0;
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextLong();
        if(arr[i]>0)
        pos++;
    }
    long prod=1;
    if(n==5)
    {
        for(int i=0;i<n;i++){
            prod*=arr[i];
        }
        pr.println(prod);
        continue;
    }
    Arrays.sort(arr);
    int neg=n-pos;
    prod=Long.MIN_VALUE;
    long temp_prod=1;
      temp_prod*=arr[0]*arr[1]*arr[2]*arr[3]*arr[4];
      prod=temp_prod; 
    temp_prod=1;
      temp_prod*=arr[0]*arr[1]*arr[n-1]*arr[n-2]*arr[n-3];
      prod=Math.max(temp_prod, prod);
    temp_prod=1;
      temp_prod*=arr[0]*arr[1]*arr[2]*arr[3]*arr[n-1];
      prod=Math.max(temp_prod, prod);
    temp_prod=1;
      temp_prod*=arr[n-5]*arr[n-4]*arr[n-3]*arr[n-2]*arr[n-1];
      prod=Math.max(temp_prod, prod);
    pr.println(prod);
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
    return "("+x+","+y+")" ;
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