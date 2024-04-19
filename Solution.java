import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int a[]=new int[26];
        for(char c:word.toCharArray())
        {
            a[c-'a']++;
        }
        Arrays.sort(a);
        int size=0;
        for(int i=0;i<26;i++)
        {
            if(a[i] == 0)
            {
                break;
            }
            else
            {
                size++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<size;i++)
        {
            int data=a[i];
            int min=0;
            for(int j=0;j<size;j++)
            {
                if(a[j]>(data + k))
                {
                    min += a[j]-(data + k);
                }
                else if(a[j]<data)
                {
                    min += a[j];
                }
            }
            ans=Math.min(ans, min);
            if(ans == 0)
            {
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;   
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumOfEncryptedInt(new int[]{1,2,3}));
    }
}