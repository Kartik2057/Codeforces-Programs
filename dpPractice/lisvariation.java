import java.util.Arrays;
public class lisvariation {


    static int[] lis(int arr[], int n)
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
        return lis;
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
    
    static int[] rev(int arr[],int n)
    {   int i=0,j=n-1;
        while(i<=j)
        {
          int temp=arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
          i++;
          j--;
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int arr[]={10,22,9,33,21,50,41,60,80};
        int arr1[]=lis(arr,9);
        arr = rev(arr,9);
        int arr2[]=lis(arr,9);
        int i=0,j=0;
        while(arr1[i]!=arr2[j])
        {
            if(arr1[i]<arr2[j])
            i++;
            else
            j++;
        }
        System.out.println(i+j+1);
    }
}
