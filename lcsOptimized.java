import java.util.Arrays;
import java.util.Scanner;

class lcsOptimized
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String st1=sc.next();
        String st2=sc.next();
        lcs(st1.toCharArray(),st2.toCharArray());
    }
    static void lcs(char s1[],char s2[])
    {
        int m=s1.length,n=s2.length;
        int prev[]=new int[n+1];
        int arr[]=new int[n+1];
        Arrays.fill(prev,0);
        arr[0]=0;
        StringBuilder st=new StringBuilder("");
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
               if(s2[j-1]==s1[i-1])
               {
                st.append(s2[j-1]);
                arr[j]=prev[j-1]+1;
               }
               else
               arr[j]=(int)Math.max(arr[j-1], prev[j]);
               prev[j-1]=arr[j-1];
            }
            prev[n]=arr[n];
            
        }
        System.out.print(arr[n]+" "+st);

    }
}