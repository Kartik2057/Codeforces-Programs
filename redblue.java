//My code is my Identity
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class redblue{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);
int t=sc.nextInt();
first:
while(t-->0)
{
int n=sc.nextInt();
int arr[]=new int[n];
String st=sc.next();
char c[]=st.toCharArray();
for(int i=0;i<n;i++)
{
   arr[i]=sc.nextInt();
}
if(c[0]=='B')
{
    pr.println(-1);
    continue first;
}
int max=0,red=-1,count=0,res=0;
for(int i=0;i<n;i++)
{ 
  if(c[i]=='R'&&i+arr[i]>max+arr[max])
  max=i;
  else if(c[i]=='B' && red>=i && i+arr[i]>max+arr[max])
  max=i;  
  if(c[i]=='B' && red<i)
  {
        if(max+arr[max]>=i)
        {
          red=max+arr[max];
          if(i+arr[i]>max+arr[max])
          max=i;
          res++;
        }
        else
        {
            pr.println(-1);
            continue first;
        }
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