//My code is my Identity
import java.util.*;
import java.io.*;
public class Main{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);
long t=sc.nextLong();
first:
while(t-->0){
//Vector <Pair> = new Vector<>();
int n=sc.nextInt();
int k=sc.nextInt();
long arr[]=new long[n];
//String st = sc.next();
//char c[]=st.toCharArray();
int i,temp=0;
for(i=0;i<n;i++)
{
  if(k==0) 
    break;
  if(k>=n-i)
  {
    k-=n-i;
    temp=0;
    arr[i]=1000;
  }
  else{
    arr[i]=k;
    temp=k;
    k=0;
  }
}
for(int j=1;i<n&&j<temp;i++,j++)
arr[i]=-1;
for(;i<n;i++)
arr[i]=-2;

for(int j=0;j<n;j++)
{
  pr.print(arr[j]+" ");
}
pr.println();
// for(int i=0;i<n;i++)
// arr[i]=sc.nextLong();

// for(int i=0;i<n;i++)

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