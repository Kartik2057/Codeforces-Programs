//My code is my Identity
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class minCoins{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);
long t=sc.nextLong();
first:
while(t-->0){
//Vector <Pair> = new Vector<>();
int n=sc.nextInt();
int q=sc.nextInt();
long arr[]=new long[n];
long sod[]=new long[n];
long sod2[]=new long[n];
long sod3[]=new long[n];
Queue <Integer> qu=new Queue<Integer>();
// String st = sc.next();
for(int i=0;i<n;i++)
{
    arr[i]=sc.nextLong();
    if(arr[i]>9)
    qu.add(i);
    sod[i]=sumDigits(arr[i]);
    sod2[i]=sumDigits(sod[i]);
    sod3[i]=sumDigits(sod2[i]);
}

int a,b,c;
for(int i=0;i<q;i++)
{
   a=sc.nextInt();
   if(a==1)
   {b=sc.nextInt();
    c=sc.nextInt();
    b--;
    c--;
    if(qu.peek()>c||qu.)
    for(int j=b-1;j<c;j++)
    {
        arr[j]=sod[j];
        sod[j]=sod2[j];
        sod2[j]=sod3[j];
    }
   }
   else{
       c=sc.nextInt();
       pr.println(arr[c-1]);
   }
}
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