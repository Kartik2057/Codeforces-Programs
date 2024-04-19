//My code is my Identity
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class A_-_Swap_Digit{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);

//Vector <Pair> = new Vector<>();
int n=sc.nextInt();
// int arr[]=new int[n];
String st1 = sc.next();
String st2 = sc.next();
long num1=0,num2=0;
long l=998244353;
for(int i=0;i<n;i++)
{
   int a=Integer.parseInt(st1.charAt(i)+"");
   int b=Integer.parseInt(st2.charAt(i)+"");
   num1*=10;
   num2*=10;
   num1%=l;
   num2%=l;

   if(num1>num2)
   {
    if(a>b)
    {num1+=a;
    num2+=b;}
    else
    {
        num1+=b;
        num2+=a;        
    }
   }
   else
   {
    if(a>b)
    {num1+=b;
     num2+=a;}
    else
    {
        num1+=a;
        num2+=b;        
    }
   }
   num1%=l;
   num2%=l;
}
long res=0,mul=1;
for(int i=0;i<Math.min(9,n);i++)
{
  String st=Long.toString(num2);
  long temp=Integer.parseInt(st.charAt(i)+"")*num1;
  res*=10;
  res%=l;
  temp%=l;
  res+=temp;
  res%=l;
}
pr.println(res);
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