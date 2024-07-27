/**
 * D_Swap_Dilemma
 */
import java.util.*;
import java.io.*;

public class D_Swap_Dilemma {

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
    long a[]=new long[n];
    long b[]=new long[n];
    //String st = sc.next();
    //char c[]=st.toCharArray();
    for(int i=0;i<n;i++)
    a[i]=sc.nextLong();
    for(int i=0;i<n;i++)
    b[i]=sc.nextLong();
    long A = inversions(a,0,n-1);
    long B = inversions(b,0,n-1);
    if(A%2==B%2 && Arrays.equals(a,b))
    System.out.println("YES");
    else
    System.out.println("NO");
    }
    pr.close();
    }

    static long inversions(long arr[],int l,int r){
        if(r==l)return 0;
        
        //divide and conquer:
        int mid=(l+r)/2;
        long x=inversions(arr,l,mid);
        long y=inversions(arr,mid+1,r);
     
        //simple merging:
        long ans[]=new long[r-l+1];
        int curr=0,inv=0;
        int pointx=l,pointy=mid+1;
        while(pointx<=mid && pointy<=r){
            if(arr[pointx]<arr[pointy]){
                inv+=pointy-mid-1;
                ans[curr]=arr[pointx];
                pointx++;
            }
            else{
                ans[curr]=arr[pointy];
                pointy++;
            }
            curr++;
        }
     
        while(pointx<=mid){
            inv+=pointy-mid-1;
            ans[curr]=arr[pointx];
                
            pointx++;
            curr++;
        }
     
        while(pointy<=r){
            ans[curr]=arr[pointy];
     
            pointy++;
            curr++;
        }
     
        //final writeback:
        for(int i=l;i<=r;i++){
            arr[i]=ans[i-l];
        }
        return x+y+inv;
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