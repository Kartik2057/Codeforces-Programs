//My code is my Identity
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class temp{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);
int t=sc.nextInt();
first:
while(t-->0){
//Vect
int n=sc.nextInt();
int arr[]=new int[n];
boolean flag=false;
for(int i=0;i<n;i++)
{
  arr[i]= sc.nextInt();
}
//checking array arranged in dec order 
for(int i=1;i<n;i++)
{
  if(arr[i]>arr[i-1])
  {flag=true;break;}
}
if(flag==false)
{pr.println("yes");continue first;}
flag=false;
//checking array arranged in inc order 
for(int i=1;i<n;i++)
{
  if(arr[i]<arr[i-1])
  {flag=true;break;}
}
if(flag==false)
{pr.println("yes");continue first;}


flag=true;
int temp=arr[0];

    int i=0;
    while(i<n)
    {
        if(arr[i]==temp)
        {i++;continue;}
        else if(arr[i]<temp)
        {
           temp=arr[i];
        }
        else
        {
            temp=arr[i];
            break;
        }
    }
    while(i<n)
    {
        if(arr[i]==temp)
        {i++;continue;}
        else if(arr[i]>temp)
        {
           temp=arr[i];
        }
        else
        {
            flag=false;
            break;
        }
    }
if(flag)
pr.println("yes");
else
pr.println("no");
}
pr.close();
}


static int checkBitonic(int arr[], int n)
{
    int i, j;
 
    // Check for increasing sequence
    for (i = 1; i < n; i++)
    {
        if (arr[i] > arr[i - 1])
            continue;
 
        if (arr[i] <= arr[i - 1])
            break;
    }
 
    if (i == n - 1)
        return 1;
 
    // Check for decreasing sequence
    for (j = i + 1; j < n; j++)
    {
        if (arr[j] < arr[j - 1])
            continue;
 
        if (arr[j] >= arr[j - 1])
            break;
    }
 
    i = j;
 
    if (i != n)
        return 0;
 
    return 1;
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