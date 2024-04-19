package ImportantCodes;
import java.util.*;

public class SegmentTree {
    private int n;
    private List<Integer> tree;
    public SegmentTree(int[] arr) {
        n = arr.length;
        
        tree = new ArrayList<>(Collections.nCopies(4 * n, 0));
        build(arr, 0, n - 1, 0);
    }

    public SegmentTree(int size){
        n = size;
        tree = new ArrayList<>(Collections.nCopies(4*n, 0));
    }

    private void build(int[] arr, int start, int end, int index) {
        if (start == end) {
            tree.set(index, arr[start]);
            return;
        }

        int mid = start + (end - start) / 2;
        build(arr, start, mid, 2 * index + 1);
        build(arr, mid + 1, end, 2 * index + 2);
        tree.set(index, tree.get(2 * index + 1) + tree.get(2 * index + 2));
    }

    public void update(int pos, int val) {
        update(0, 0, n - 1, pos, val);
    }

    private void update(int index, int start, int end, int pos, int val) {
        //Complete overlap
        if (start == end) {
            tree.set(index, val);
            return;
        }

        int mid = start + (end - start) / 2;
        if (pos <= mid) {
            update(2 * index + 1, start, mid, pos, val);
        } else {
            update(2 * index + 2, mid + 1, end, pos, val);
        }
        tree.set(index, tree.get(2 * index + 1) + tree.get(2 * index + 2));
    }

    private void updateRange(int index, int start, int end, int rangeSt, int rangeEnd, int inc){
        //No overlap
        if(start<rangeEnd || end>rangeSt){
            return;
        }

        //Complete overlap
        if(start==end){
            tree.set(index,tree.get(index)+1);
        }

        int mid = start + (end-start)/2;
        updateRange(2*index+1, start, mid, rangeSt, rangeEnd, inc);
        updateRange(2*index+2, mid+1, end, rangeSt, rangeEnd, inc);
        tree.set(index, tree.get(2*index+1)+tree.get(2*index+2));
    }

    public int query(int start, int end) {
        return query(0, 0, n - 1, start, end);
    }

    private int query(int index, int start, int end, int qstart, int qend) {
        if (qstart > end || qend < start) {
            return 0;
        }

        if (qstart <= start && qend >= end) {
            return tree.get(index);
        }

        int mid = start + (end - start) / 2;
        return query(2 * index + 1, start, mid, qstart, qend) +
                query(2 * index + 2, mid + 1, end, qstart, qend);
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);

        System.out.println("Sum of values in given range = " + segmentTree.query(1, 3));

        // segmentTree.update(1, 10);
        
        System.out.println("Updated sum of values in given range = " + segmentTree.query(1, 3));
    }
}
