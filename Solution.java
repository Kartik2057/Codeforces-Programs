import java.util.*;

public class Solution  {
    public static void main(String[] args) {
        List<Integer> sectorCost = new ArrayList<>();
        int clusterSize=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            sectorCost.add(num);
        }
        clusterSize = sc.nextInt();
        getClusteringCost2(sectorCost, clusterSize);
    }
    public static List<Long> getClusteringCost2(List<Integer> sectorCost,int clusterSize){
        int n = sectorCost.size();
        long max = sectorCost.get(0)+sectorCost.get(n-1);
        long min = sectorCost.get(0)+sectorCost.get(n-1);
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a,b)->Long.compare(b, a));
        for(int i=0;i<sectorCost.size()-1;i++){
            minHeap.add(sectorCost.get(i)+sectorCost.get(i+1)+0l);
            maxHeap.add(sectorCost.get(i)+sectorCost.get(i+1)+0l);
        }
        while(clusterSize-->1){
            max+=maxHeap.poll();
            min+=minHeap.poll();
        }
        List<Long> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);
        System.out.println(min+" "+max);
        return ans;
    }
}