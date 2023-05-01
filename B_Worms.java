/**
 * B_Worms
 */
import java.util.*;
import java.io.*;
public class B_Worms {
  //My code is my Identity
  public static void main(String[] args) 
  {
  FastScanner sc = new FastScanner(System.in);
  PrintWriter pr = new PrintWriter(System.out);
 
  //Vector <Pair> = new Vector<>();
  int n=sc.nextInt();
  long arr[]=new long[n];
  //String st = sc.next();
  //char c[]=st.toCharArray();
  
  for(int i=0;i<n;i++)
  arr[i]=sc.nextLong();
  
  for(int i=1;i<n;i++)
  arr[i]+=arr[i-1];

  int q=sc.nextInt();
  long arr1[]=new long[q];
  for(int i=0;i<q;i++)
  {
    arr1[i]=sc.nextLong();
    pr.println(binarySearch(arr, 0, n-1, arr1[i])+1);  
  }
  pr.close();
  }

  static int binarySearch(long arr[], int l, int r, long x)
    {
        int res=-1;
        while(l<=r)
        {
           int m=l+(r-l)/2;
           if(arr[m]==x)
           return m;
           else if(arr[m]>x)
           {
            res=m;
            r=m-1;
           }
           else
           l=m+1;
        }
        return res;
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
