//My code is my Identity
import java.util.*;
import java.io.*;
public class B_BerSU_Ball{
public static void main(String[] args) 
{
FastScanner sc = new FastScanner(System.in);
PrintWriter pr = new PrintWriter(System.out);
//Vector <Pair> = new Vector<>();
int n=sc.nextInt();
int arr[]=new int[n];
for(int i=0;i<n;i++)
arr[i]=sc.nextInt();
//String st = sc.next();
//char c[]=st.toCharArray();
int m=sc.nextInt();
int arr1[]=new int[m];
for(int i=0;i<m;i++)
arr1[i]=sc.nextInt();
Arrays.sort(arr);
Arrays.sort(arr1);
int res=0;
if(m<n){
for(int i=0;i<m;i++)
{
 int temp=binarySearch(arr, 0,n-1,arr1[i]-1);
 if(temp==-1)
 temp=binarySearch(arr, 0,n-1,arr1[i]);
 if(temp==-1)
 temp=binarySearch(arr, 0,n-1,arr1[i]+1);
 if(temp!=-1)
 {
    arr[temp]=-1;
    Arrays.sort(arr);
    res++;
 }
}
}
else{
    for(int i=0;i<n;i++)
    {
     int temp=binarySearch(arr1, 0,m-1,arr[i]-1);
     if(temp==-1)
     temp=binarySearch(arr1, 0,m-1,arr[i]);
     if(temp==-1)
     temp=binarySearch(arr1, 0,m-1,arr[i]+1);
     if(temp!=-1)
     {
        arr1[temp]=-1;
        Arrays.sort(arr1);
        res++;
     }
    }
}
pr.println(res);
pr.close();
}

static int binarySearch(int arr[], int l, int r, int x)
    {

        if (r>=l)
        {
            int mid = l + (r - l)/2;
  
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
               return mid;
  
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
  
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r, x);
        }
  
        // We reach here when element is not present
        //  in array
        return -1;
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