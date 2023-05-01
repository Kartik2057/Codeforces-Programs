
/// THIS PROBLEM CAN BE USED TO DETECT THE SPELLING ERRORS AND FOR GIVING SUGGESTIONS.

class editdistance{
    public static void main(String[] args){
           System.out.println(dpeditdistance("saturday","sunday",8,6));
    }

    static int Editdistance(String s1,String s2,int m,int n)
    {
       char c1[]=s1.toCharArray();
       char c2[]=s2.toCharArray();
        if(m==0)
        return n;
        if(n==0)
        return m;
        if(c1[m-1]==c2[n-1])
        return Editdistance(s1, s2, m-1, n-1);
        if(m==n)
        return 1+Editdistance(s1, s2, m-1, n-1);
        if(m<n)
        return 1+Editdistance(s1, s2, m, n-1);
        return (int)Math.min(1+Editdistance(s1, s2, m-1, n-1), 
                             1+Editdistance(s1, s2, m-1, n));
    }


    static int dpeditdistance(String s1, String s2, int m,int n)
    {
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++)dp[i][0]=i;
        for(int i=1;i<=n;i++)dp[0][i]=i;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(c1[i-1]==c2[j-1])
                dp[i][j]=dp[i-1][j-1];
                else
                dp[i][j]=1+(int)Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
}