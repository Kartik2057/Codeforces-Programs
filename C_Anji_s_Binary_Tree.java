/**
 * C_Anji_s_Binary_Tree
 */
import java.util.*;
import java.io.*;

public class C_Anji_s_Binary_Tree {
    class Node{
        Node left;
        Node right;
    }
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
    String st = sc.next();
    int left[]=new int[n];
    int right[]=new int[n];
    char c[]=st.toCharArray();
    for(int i=0;i<n;i++)
    {
        left[i]=sc.nextInt();
        right[i]=sc.nextInt();
    }
    boolean vis[] = new boolean[n];
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(1, 0));
    vis[0]=true;
    int res=Integer.MAX_VALUE;
    while(!q.isEmpty()){
        Pair look = q.poll();
        int l = left[look.x-1];
        int r = right[look.x-1];
        if(l==0 && r==0)
        {
            res = Math.min(res, look.y);
        }
        if(l!=0 && (!vis[l-1])){
            q.add(new Pair(l, 'L'==c[look.x-1]?look.y:look.y+1));
            vis[l-1]=true;
        }
        if(r!=0 && (!vis[r-1])){
            q.add(new Pair(r, 'R'==c[look.x-1]?look.y:look.y+1));
            vis[r-1]=true;
        }
    }
    System.out.println(res);
    }
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