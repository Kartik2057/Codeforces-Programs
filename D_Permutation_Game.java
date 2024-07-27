/**
 * D_Permutation_Game
 */
import java.util.*;
import java.io.*;

public class D_Permutation_Game {

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
    long k=sc.nextLong();
    int pb=sc.nextInt();
    int ps=sc.nextInt();
    int pos[]=new int[n+1];
    long arr[]=new long[n+1];
    //String st = sc.next();
    //char c[]=st.toCharArray();
    for(int i=1;i<=n;i++)
    pos[i]=sc.nextInt();
    for(int i=1;i<=n;i++)
    arr[i]=sc.nextLong();
    long bodya=0,sasha=0;
    long temp = k,curr=0;
    HashSet<Integer> vis = new HashSet<>();
    while(temp>0 && !vis.contains(pb)){
        bodya = Math.max(bodya,arr[pb]*temp+curr);
        curr+=arr[pb];
        vis.add(pb);
        pb = pos[pb];
        temp--;
    }
    temp = k;
    curr=0;
    vis = new HashSet<>();
    while(temp>0 && !vis.contains(ps)){
        sasha = Math.max(sasha,arr[ps]*temp+curr);
        curr+=arr[ps];
        vis.add(ps);
        ps = pos[ps];
        temp--;
    }
    if(bodya>sasha){
        System.out.println("Bodya");
    }
    else if(bodya<sasha){
        System.out.println("Sasha");
    }
    else{
        System.out.println("Draw");
    }
    }
    pr.close();
    }
    static void print(int[] arr){
       for(int i=0;i<arr.length;i++){
          System.out.print(arr[i]+" ");
       }
       System.out.println();
    }
    static void print(long[] arr){
       for(int i=0;i<arr.length;i++){
         System.out.print(arr[i]+" ");
       }
       System.out.println();
    }
    static void print(double[] arr){
       for(int i=0;i<arr.length;i++){
         System.out.print(arr[i]+" ");
       }
       System.out.println();
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