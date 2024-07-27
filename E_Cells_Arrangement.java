import java.util.*;

public class E_Cells_Arrangement {
  int dirX[] = {0,0,-1,1};
  int dirY[] = {-1,1,0,0};
  int n;
  public static void main(String[] args) {
    E_Cells_Arrangement e1 = new E_Cells_Arrangement();
    e1.call();
  }
  public void call(List<List<Integer>> grid) {
      n = grid.size();
      List<List<Integer>> theives = new ArrayList<>();
      int[][] dis = new int[n][n];
      boolean[][] vis = new boolean[n][n];
      Queue<int[]> q = new ArrayDeque<>();
      for(int i=0;i<n;i++){
          Arrays.fill(dis[i],Integer.MAX_VALUE);
      } 
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              if (grid.get(i).get(j) == 1) {
                  q.add(new int[]{i,j});
                  vis[i][j]=true;
              }
          }
      }
      int len=0;
      while(!q.isEmpty()){
          int size=q.size();
          while(size-->0)
          System.out.println("Hi");
          {int curr[] = q.poll();
          int x=curr[0],y=curr[1];
          dis[x][y]=len;
          for(int i=0;i<4;i++){
              int newX=x+dirX[i],newY=y+dirY[i];
              if(isValid(vis,newX,newY)){
                  if(dis[newX][newY]>len)
                  dis[newX][newY] = len+1;
                  vis[newX][newY]=true;    
                  q.add(new int[]{newX,newY});
              }
          }
          }
          len++;
      }
      for(int i=0;i<n;i++){
          System.out.println(Arrays.toString(dis[i]));
      }
      System.out.println(); 
      int left=0,right=2*n,ans=0;
      while(left<=right){
          int mid = left - (right-left)/2;
          if(check(mid,dis)){
              ans=mid;
              left=mid+1;
          }
          else{
              right=mid-1;
          }
      }
      System.out.println(ans);
  }
  public boolean isValid(boolean[][] vis,int x,int y){
      if(x<0||y<0||y>=n||x>=n||vis[x][y])
      return false;
      return true;
  }
  public boolean check(int limit,int dis[][]){
      boolean[][] vis = new boolean[n][n];
      Queue<int[]> q = new ArrayDeque<>();
      if(dis[0][0]<limit||dis[n-1][n-1]<limit)return false;
      q.add(new int[]{0,0});
      vis[0][0]=true;
      while(!q.isEmpty()){
          int curr[] = q.poll();
          int x=curr[0],y=curr[1];
          System.out.println("Hello");
          if(x==n-1&&y==n-1){
              return true;
          }
          for(int i=0;i<4;i++){
              int newX=x+dirX[i],newY=y+dirY[i];
              if(isValid(vis,newX,newY) && dis[newX][newY]>=limit){
                  vis[newX][newY]=true;
                  q.add(new int[]{newX,newY});
              }
          }
      }
      return false;
  }
}