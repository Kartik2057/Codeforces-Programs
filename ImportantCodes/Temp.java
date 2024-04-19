package ImportantCodes;
import java.util.*;


public class Temp {
    public  static int recur(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        ArrayList<ArrayList<Integer>> aL = new ArrayList<>();
        for(int i=0;i<n*m;i++){
            aL.add(new ArrayList<>());
        }
        int direcx[] = new int[]{1,0,-1,0};
        int direcy[] = new int[]{0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    for(int k=0;k<3;k++){
                        if(i+direcx[k]>=0 &&  j+direcy[k]>=0 &&i+direcx[k]<n && j+direcy[k]<m && arr[i+direcx[k]][j+direcy[k]]==1){
                            int pos = 2*(i+direcx[k])+j+direcy[k];
                            aL.get(n*i+j).add(pos);
                            aL.get(pos).add(n*i+j);
                        }
                    }
                }
            }
        }
        Queue<Integer> q = new ArrayDeque();
        boolean vis[] = new boolean[n*m];
        int res=0;
        q.add(0);
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            while(size-->0){
                int curr = q.poll();
                vis[curr]=true;
                ArrayList<Integer> currList = aL.get(curr);
                for(int num:currList){
                    if(!vis[num])
                    q.add(num);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,1,0,0,0},{1,1,0,0,1},{0,0,0,1,1},{0,0,0,0,0},{1,0,1,0,1}};
        System.out.println(recur(arr));
    }
}