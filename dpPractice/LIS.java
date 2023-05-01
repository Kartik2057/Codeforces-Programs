public class LIS {

    ///TIME COM: O(n2)
    // AUX SPACE:O(n)
    static void dplis(int arr[],int n)
    {
        int dp[] = new int[n];
        
        dp[0]=1;
        //Keeping records of length of all the lis arrays ending with the particular 
        //index of arr[i] 
        for(int i=1;i<n;i++)
        {
            dp[i]=1;
            for(int j=0;j<i;j++)
            {
              if(arr[i]>arr[j])
              dp[i]=Math.max(dp[i],dp[j]+1);      
            }
        }
        int max=dp[0];
        for(int i=1;i<n;i++)
         max=Math.max(max,dp[i]);

        System.out.println(max);
    }


    //Time complexity:O(nlogn)
    static void lis(int arr[], int n)
    {
        int lis[]=new int[n];
        lis[0]=arr[0];
        int len=1;
        for(int i=1;i<n;i++)
        if(arr[i]>lis[len-1])
        {
            lis[len]=arr[i];
            len++;
        }
        else{
            int a = ceilindex(lis,0,len-1,arr[i]);
            lis[a]=arr[i];
        }
        System.out.println(len);
        for(int i=0;i<len;i++)
        {
            System.out.print(lis[i]+" ");
        }
    }


    //Binary search for finding ceiling index
    static int ceilindex(int arr[],int f,int l,int x)
    {
        while(f<l)
        {
            int m=f+(l-f)/2;
            if(arr[m]>x)
            l=m;
            else
            f=m+1;
        }
        return l;
    }

    public static void main(String[] args)
    {
        int arr[]={10,22,9,33,21,50,41,60,80};
        lis(arr,9);
    }
}
