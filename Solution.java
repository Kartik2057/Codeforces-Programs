import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Solution 
 */

public class Solution  {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> temp = new HashMap<>(map);
        int arr[] = {1,2,4,4};
        System.out.println(Arrays.binarySearch(arr,3)); 
        System.out.println(-arr[2]);
    }
}