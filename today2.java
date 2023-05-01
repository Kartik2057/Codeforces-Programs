//My code is my Identity
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class today2{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);
int t=sc.nextInt();
first:
while(t-->0){
//Vector <Pair> = new Vector<>();
int n=sc.nextInt();
int m=sc.nextInt();
int arr[]=new int[n];
long pre[]=new long[n];
// String st = sc.next();

for(int i=0;i<n;i++)
arr[i]=sc.nextInt();
pre[0]=arr[0];
for(int i=1;i<n;i++)
{
  pre[i]=pre[i-1]+arr[i];
}
long temp=pre[m-1];
long rem=0;
int res=0;
for(int i=m-1;i<n;i++)
{
    if(pre[i]+rem<temp)
    {
       res++;
       rem+=-2*arr[i];
    }
}
pr.println(res);

}
pr.close();
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