import java.util.Arrays;

public class Practice2 {
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

        // Find the second peak to the left of the highest peak
        int leftPeakIndex = highestPeakIndex - 1;
        while (leftPeakIndex >= 0 && hills[leftPeakIndex] <= hills[leftPeakIndex + 1]) {
            leftPeakIndex--;
        }

        // Find the second peak to the right of the highest peak
        int rightPeakIndex = highestPeakIndex + 1;
        while (rightPeakIndex < n && hills[rightPeakIndex] <= hills[rightPeakIndex - 1]) {
            rightPeakIndex++;
        }

        // Check if both peaks are found and create subsequences
        if (leftPeakIndex >= 0 && rightPeakIndex < n) {
            result[leftPeakIndex] = '1';
            result[rightPeakIndex] = '1';
        }

        return new String(result);
    }

    public static void main(String[] args) {
        int[] hills = {1, 4, 3, 2, 6, 5};
        String result = twoPeaks(hills);
        System.out.println(result);
    }
}