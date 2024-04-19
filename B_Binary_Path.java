/**
 * B_Binary_Path
 */
import java.util.*;
import java.io.*;

public class B_Binary_Path {
    //My code is my Identity
    public static void main(String[] args) 
    {
    FastScanner sc = new FastScanner(System.in);
    PrintWriter pr = new PrintWriter(System.out);
    long t=sc.nextLong();
    first:
    while(t-->0){
    int count=1;
    int n=sc.nextInt();
    String first = sc.next();
    String second = sc.next();

    int i=0;
    StringBuilder sb=new StringBuilder();
    sb.append(first.charAt(0));
    int j;
    for(j=0;j<n-1;j++){
        if(first.charAt(j+1)=='0')
        sb.append('0');
        else if(second.charAt(j)=='0')
        {
            sb.append(second.substring(j,n-1));
            break;
        }
        else
        sb.append("1");
        
    }
    sb.append(second.charAt(n-1));
    String st = sb.toString();
    while(j-->0) {
        if(first.charAt(j+1)==second.charAt(j)){
            count++;
        }
        else
        break;
    }
    System.out.println(st);
    System.out.println(count);
    }
    pr.close();
    }
    // static int count(String s,int ind,char arr[][],int i,int j){
    //     if(i>1 || j==arr[0].length || ind==s.length()){
    //         return 0;
    //     }
    //     if(i==1 && j==arr[0].length && s.charAt(ind)==arr[i][j]){
    //         return 1;
    //     }
    //     int res=0;
    //     if(i==0 && arr[i][j]==s.charAt(ind)){
    //         res = 1+count(s,ind+1,arr,i+1,j) + count(s,ind+1,arr,i,j+1);
    //     }
    //     else if(i==1 && arr[i][j]==s.charAt(ind)){
    //         res = 1+count(s,ind+1,arr,i,j+1);
    //     }
    //     return res;
    // }
    // static String recur(String[][] dp,char arr[][],int i,int j){
    //     if(i>1 || j==arr[0].length){
    //         return "";
    //     }
    //     if(dp[i][j]!=""){
    //         return new String(dp[i][j]);
    //     }
    //     String ans="";
    //     int count=0;
    //     if(i==1){
    //         ans = arr[i][j] + recur(dp,arr,i,j+1);
    //         map.get(ans);
    //     }
    //     else {
    //         String temp1=recur(dp,arr,i+1,j);
    //         String temp2=recur(dp,arr,i,j+1);
    //         if(temp1!="" && temp2!=""){
    //             if(temp1.compareTo(temp2)==0)
    //             count=map.get(temp1)*2;
    //             ans = arr[i][j]+new String(temp1.compareTo(temp2)>0?temp2:temp1);
    //         }
    //         else if(temp1!="" && temp2==""){
    //             ans=arr[i][j]+new String(temp1);
    //             count = map.get(temp1);
    //         }
    //         else{
    //             ans=arr[i][j]+new String(temp2);
    //             count = map.get(temp2);
    //         }
    //     }
    //     // System.out.println(ans+" "+arr[i][j]+" "+i+" "+j);
    //     map.put(ans,count);
    //     return dp[i][j]=new String(ans);
    // }
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