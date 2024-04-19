/**
 * C_Boats_Competition
 */
import java.util.*;
import java.io.*;
public class C_Boats_Competition {

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
    int arr[]=new int[n];
    //String st = sc.next();
    //char c[]=st.toCharArray();
    HashMap <Integer, Integer> m= new HashMap<>();
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
        m.put(arr[i], m.getOrDefault(arr[i], 0)+1);
    }
    int res=0;
    for(int i=2;i<=2*n;i++)
    {
        int temp_res=0;
        HashSet <Integer> s= new HashSet<>();
        for (Map.Entry<Integer,Integer> mapElement : m.entrySet()) {
            int key = mapElement.getKey();
 
            // Adding some bonus marks to all the students
            int value = mapElement.getValue();
            if(i-key == key){
                s.add(key);
                temp_res+=value/2;
            }
            else if(i-key>0&&m.containsKey(i-key)&&!s.contains(i-key))
            {
                s.add(i-key);
                s.add(key);
                temp_res+=Math.min(m.get(i-key),value);
            }
            // System.out.println(key + " : " + value);
        }
        res=Math.max(res, temp_res);
    }
    pr.println(res);
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