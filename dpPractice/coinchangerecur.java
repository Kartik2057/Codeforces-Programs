

class coinchangerecur
{
    static int recurgetcount(int arr[], int n, int sum)
    {
        if(n==1)
        {
            if(sum%arr[0]==0)
            return 1;
            else 
            return 0;
        }
        if(sum==0)
        return 1;
        int count=recurgetcount(arr, n-1, sum);//excluded the number
        if(arr[n-1]<=sum)
        count+=recurgetcount(arr,n, sum-arr[n-1]);//subtracted and included that number
        return count;
    }
     
//     dp[sum+1][n+1];
//     arr={1,2,3}
//     n->
//      0 1 2 3
//    0 1 1 1 1
//  s 1 0 1 1 1
//  u 2 0 1 2 2
//  m 3 0 1 2 3
//    4 0 1 3 4

    static void dpgetcount(int arr[],int n,int sum)
    {
        int dp[][] = new int[sum+1][n+1];

        for(int i=0;i<=n;i++)dp[0][i]=1;
        for(int i=1;i<=sum;i++)dp[i][0]=0;

        for(int i=1;i<=sum;i++)
        {
            for(int j=1;j<=n;j++)
            {
                dp[i][j]=dp[i][j-1];
                if(arr[j-1]<=i)
                dp[i][j]+=dp[i-arr[j-1]][j];//the no of combinations of forming sum-coin[j-1]+original
                                            //no of combinations with not including current coin
            }
        }
        System.out.println(dp[sum][n]);
    }

    public static void main(String[] args)
    {
        int arr[]={2,5,3,6};
        dpgetcount(arr,4,10);
    }
}