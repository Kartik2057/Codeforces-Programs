import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class hello {
    static int findMaximumProfit(int n,int category[],int price[]){
        int pair[][] = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0] =category[i];
            pair[i][1] =price[i];
        }
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int i=0;i<n;i++){
            set.add(pair[i][0]);
            res+=pair[i][1]*set.size();
        }
        return res;
    }
    public static void main(String[] args) {
        int category[] = {2,1,2};
        int price[] = {3,2,4};
        System.out.println(findMaximumProfit(3, category, price));
    }
}
