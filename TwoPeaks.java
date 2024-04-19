import java.util.Arrays;

public class TwoPeaks {
    public static String twoPeaks(int[] hills) {
        int n = hills.length;

        // Find the highest peak
        int highestPeakIndex = 0;
        for (int i = 1; i < n; i++) {
            if (hills[i] > hills[highestPeakIndex]) {
                highestPeakIndex = i;
            }
        }

        // Initialize an array to store the result
        char[] result = new char[n];
        Arrays.fill(result, '0');

        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                
            }
            for(int j=i+1;j<n;j++){

            }
        }
        

        return new String(result);
    }

    public static void main(String[] args) {
        int[] hills = {1, 4, 3, 2, 6, 5};
        String result = twoPeaks(hills);
        System.out.println(result);
    }
}