/**
 * B_Progressive_Square
 */
import java.util.*;
import java.io.*;

public class B_Progressive_Square {

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
    int c=sc.nextInt();
    int d=sc.nextInt();
    HashMap<Long,Integer> map = new HashMap<>(); 
    long arr[][]=new long[n][n];
    //String st = sc.next();
    //char c[]=st.toCharArray();
    long min=Long.MAX_VALUE;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            arr[i][j]=sc.nextLong();
            min = Math.min(arr[i][j], min);
            map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
        }
    }
    String res="YES";
    arr[0][0]=min;
    map.put(min, map.get(min)-1);
    for (int i = 1; i < n; i++) {
        long num = arr[i-1][0] + c;
        if(map.containsKey(num) && map.get(num)>0){
            arr[i][0]=num;
            map.put(num, map.get(num)-1);
        }
        else{
            res="NO";
            break;
        }
    }
    for (int i = 1; i < n; i++) {
        long num = arr[0][i-1] + d;
        if(map.containsKey(num) && map.get(num)>0){
            arr[0][i]=num;
            map.put(num, map.get(num)-1);
        }
        else{
            res="NO";
            break;
        }
    }
    outer:
    for(int i=1;i<n;i++){
        for (int j = 1; j < n; j++) {
            if(arr[i-1][j]+c == arr[i][j-1]+d){
                long num = arr[i-1][j]+c;
                if(map.containsKey(num) && map.get(num)>0){
                    arr[i][j]=num;
                    map.put(num, map.get(num)-1);
                }
                else{
                    res="NO";
                    break outer;
                }
            }else{
                // System.out.println("loop3 "+i+" "+j);
                res="NO";
                break outer;
            }
        }
    }
    System.out.println(res);
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