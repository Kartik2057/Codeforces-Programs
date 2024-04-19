import java.util.*; 
  
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res=0;
        for (int i = 1; i < nums.length; i++) {
            int low = Arrays.binarySearch(nums, lower-nums[i]-1);
            int high = Arrays.binarySearch(nums, upper-nums[i]);
            if(low<0 && high<0){
                res+=(high*(-1))-(low*(-1));
            }
            else if(low<0){
                res+=high+1 -(low*(-1));
            } 
            else if(high<0){
                res+=(high*(-1))-low-1;
            }
            else{
                res+=
            }
            nSet.add(nums[i]);
        }
        return res;
    }
}