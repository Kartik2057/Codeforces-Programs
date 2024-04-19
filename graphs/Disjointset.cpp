#include <bits/stdc++.h>
using namespace std;

class Disjointset
{
private:
    vector<int>rank,parent,size;
public:
    Disjointset(int n){
      rank.resize(n+1,0);
      parent.resize(n+1);
      size.resize(n+1,1);
      for(int i=0;i<=n;i++){
        parent[i]=i;
      }
    };

    int findUParent(int node){
        if(node==parent[node]){
           return node;
        }
        parent[node] = findUParent(parent[node]);
        return parent[node];
    }

    void unionByRank(int u,int v){
        int ultParentU = findUParent[u];
        int ultParentV = findUParent[v];
        if(ultParentU==ultParentV)
        return ;
        if(rank[ultParentU]<rank[ultParentV])
        {
           parent[ultParentU]=ultParentV;
        }
        else if(rank[ultParentU]>rank[ultParentV])
        {
           parent[ultParentV]=ultParentU;
        }
        else
        {
           parent[ultParentU]=ultParentV;
           rank[ultParentV]++;
        }
    }
    void unionBySize(int u, int v){
       int ultParentU = findUParent[u];
        int ultParentV = findUParent[v];
        if(ultParentU==ultParentV)
        return ;
        if(size[ultParentU]<size[ultParentV])
        {
            parent[ultParentU]=ultParentV;
            size[ultParentV]+=size[ultParentU];
        }
        else{
            parent[ultParentV]=ultParentU;
            size[ultParentU]+=size[ultParentV];
        } 
    }
};
