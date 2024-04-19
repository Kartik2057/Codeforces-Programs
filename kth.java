import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class kth {

    public static int kthLowestAmount(int N, int K, int[] denominations) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> sums = new HashSet<>();

        for (int denomination : denominations) {
            heap.offer(denomination);
            sums.add(denomination);
        }

        for (int i = 0; i < K - 1; i++) {
            int currentSum = heap.poll();
            for (int coin : denominations) {
                int newSum = currentSum + coin;
                if (!sums.contains(newSum)) {
                    sums.add(newSum);
                    heap.offer(newSum);
                }
            }
        }

        return heap.poll();
    }

    public static void main(String[] args) {
        // Sample input
        int N1 = 2, K1 = 6;
        int[] denominations1 = {4, 7};
        int N2 = 4, K2 = 6;
        int[] denominations2 = {3, 5, 7, 11};

        // Output
        int result1 = kthLowestAmount(N1, K1, denominations1);
        int result2 = kthLowestAmount(N2, K2, denominations2);

        System.out.println(result1);  // Output: 15
        System.out.println(result2);  // Output: 9
    }
}
