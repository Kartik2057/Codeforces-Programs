/**
 * C_Torn_Lucky_Ticket
 */
import java.util.*;
import java.io.*;

public class C_Torn_Lucky_Ticket {

    public static int count(String st){
        int res=0;
        for(int i=0;i<st.length();i++){
            res+=st.charAt(i)-'0';
        }
        return res;
    }
    //My code is my Identity
    public static void main(String[] args) 
    {
    FastScanner sc = new FastScanner(System.in);
    PrintWriter pr = new PrintWriter(System.out);
    //Vector <Pair> = new Vector<>();
    //Pair[] pairs=new Pair[n];
    int n=sc.nextInt();
    String arr[]=new String[n];
    for(int i=0;i<n;i++)
    arr[i]=sc.next();
    long[][] store = new long[11][60];
    for(int i=0;i<n;i++){
        store[arr[i].length()][count(arr[i])]++;
    }
    //String st = sc.next();
    //char c[]=st.toCharArray();
    long res=0;

    for(int i=0;i<n;i++){
        int len = arr[i].length();
        int count = count(arr[i]);
        res+=store[len][count];
        int diff=0,m=1;
        //prefix
        for(int j=len-1;j>0;j--){
            diff += arr[i].charAt(j)-'0';
            if(len-2*m>0 && count-2*diff>0)
            res+=store[len-2*m][count-2*diff];
            m++;
        }
        diff=0;m=1;
        //suffix
        for(int j=0;j<len-1;j++){
            diff += arr[i].charAt(j)-'0';
            if(len-2*m>0 && count-2*diff>0)
            res+=store[len-2*m][count-2*diff];
            m++;
        }
    }
    System.out.println(res);
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