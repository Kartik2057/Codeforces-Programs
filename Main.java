import java.util.*;

public class Main {
    public void calc(){
        HashMap<Integer,Integer> map = new HashMap<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int l = scanner.nextInt();
            int[] factors = primeFactors(l);
            Map<Integer, Integer> factorCounts = countFactors(factors);
            HashMap<Integer,Integer> map = new HashMap<>();
            int distinctValues = 1;
            for (Map.Entry<Integer, Integer> entry : factorCounts.entrySet()) {
                int p = entry.getKey();
                int e = entry.getValue();
                int ways = countWays(a, b, p, e);
                distinctValues *= ways;
            }
            System.out.println(distinctValues);
        }
        scanner.close();
    }

    private static int[] primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Map<Integer, Integer> countFactors(int[] factors) {
        Map<Integer, Integer> factorCounts = new HashMap<>();
        for (int factor : factors) {
            factorCounts.put(factor, factorCounts.getOrDefault(factor, 0) + 1);
        }
        return factorCounts;
    }

    private static int countWays(int a, int b, int p, int e) {
        int ways = 0;
        for (int x = 0; x <= e; x++) {
            for (int y = 0; y <= e; y++) {
                if (Math.pow(p, x + y) == Math.pow(a, x) * Math.pow(b, y)) {
                    ways++;
                }
            }
        }
        return ways;
    }
}
