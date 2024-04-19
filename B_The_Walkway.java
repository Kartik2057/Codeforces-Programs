/**
 * B_The_Walkway
 */
import java.util.*;
import java.io.*;

public class B_The_Walkway {

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
    int m=sc.nextInt();
    int d=sc.nextInt();
    int arr[]=new int[m];
    int pre[]=new int[m];
    int suff[]=new int[m];
    HashMap<Integer,Integer> map = new HashMap<>();
    //String st = sc.next();
    //char c[]=st.toCharArray();
    for(int i=0;i<m;i++)
    arr[i]=sc.nextInt();
    int res1=0,res2=0;
    pre[0]=1+(arr[0]+d-2)/d;
    for(int i=1;i<m;i++){
        pre[i]=1+pre[i-1]+find(arr[i-1],arr[i],d);
    }
    suff[m-1]=1+find(arr[m-1],n+1,d);
    for(int i=m-2;i>=0;i--){
        suff[i]=1+suff[i+1]+find(arr[i],arr[i+1],d);
    }
    //Removing 1st 
    res1=suff[1]+(arr[1]+d-2)/d;
    map.put(res1, map.getOrDefault(res1, 0)+1);
    //Removing last
    int temp=pre[m-2]+find(arr[m-2],n+1,d);
    map.put(temp, map.getOrDefault(temp, 0)+1);
    if(temp<res1){
        res1=temp;
    }
    for(int i=1;i<m-1;i++){
        int res = pre[i-1]+suff[i+1]+find(arr[i-1],arr[i+1],d);
        if(res1>res)
        {
            res1=res;
        }
        map.put(res, map.getOrDefault(res, 0)+1);
    }
    System.out.println(res1+" "+map.get(res1));
    }
    pr.close();
    }
    static int find(int start,int end,int d){
        return Math.max(0,end-start-1)/d;
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