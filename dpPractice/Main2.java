//My code is my Identity
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class Main2{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);
long t=sc.nextLong();
first:
while(t-->0){
//Vector <Pair> = new Vector<>();
long n=sc.nextLong();
long a=n/2,b=(long)Math.ceil(n/2.0);
long arr1[]={4,5,14,15,24,25,35,35,45,45};
long arr2[]={5,14,15,24,25,34,34,44,44,54};
if(n%10==9)
{
  long temp=(n/10)%10;
  a=(n-n%100)/2;
  b=a;
  a+=arr1[(int)temp];
  b+=arr2[(int)temp];
}
pr.println(a+" "+b);
// long arr[]=new long[n];
// String st = sc.next();

// for(int i=0;i<n;i++)
// arr[i]=sc.nextLong();

// for(int i=0;i<n;i++)

}
pr.close();
}

static long sumDigits(long no)
    {
        return no == 0 ? 0 : no%10 +
                  sumDigits(no/10) ;
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