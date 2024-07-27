// Java program for above approach

import java.sql.Array;
import java.util.Arrays;

public class GFG {

	// Function to find
	// kth missing number
	static int missingK(int[] arr, int k)
	{
        Arrays.sort(arr);
		int n = arr.length;
		int l = 0, u = n - 1, mid;
		while (l <= u) {
			mid = (l + u) / 2;
			int numbers_less_than_mid
				= arr[mid] - (mid + 1);

			// If the total missing number
			// count is equal to k we can iterate
			// backwards for the first missing number
			// and that will be the answer.
			if (numbers_less_than_mid == k) {
				if (mid > 0
					&& (arr[mid - 1] - (mid)) == k) {
					u = mid - 1;
					continue;
				}

				// Else we return arr[mid] - 1.
				return arr[mid] - 1;
			}

			// Here we appropriately
			// narrow down the search window.
			if (numbers_less_than_mid < k) {
				l = mid + 1;
			}
			else if (k < numbers_less_than_mid) {
				u = mid - 1;
			}
		}

		// In case the upper limit is -ve
		// it means the missing number set
		// is 1,2,..,k and hence we directly return k.
		if (u < 0)
			return k;

		// Else we find the residual count
		// of numbers which we'd then add to
		// arr[u] and get the missing kth number.
		int less = arr[u] - (u + 1);
		k -= less;

		// Return arr[u] + k
		return arr[u] + k;
	}

	// Driver code
	public static void main(String[] args)
	{
		int[] arr = { 1,4,7,3,4 };
		int k = 5;
        Arrays.sort(arr);
		// Function Call
		System.out.println("Missing kth number = "
						+ missingK(arr, k));
	}
}

// This code is contributed by divyesh072019.
