#include <bits/stdc++.h>
using namespace std;

class Solution{
    vector<int> bellman_ford(int V, vector<vector<int>>& edges, int S) {
        vector<int> distance(V,1e9);
        vector<int> wrong;
        wrong.push_back(-1);
        distance[S]=0;

        for(int i=0;i<V;i++)
        {
            for(auto it:edges)
            {
               int u=it[0];
               int v=it[1];
               int wt=it[2];
               if(distance[u]+wt<distance[v])
               {
                distance[v]=distance[u]+wt;
               }
            }
        }
        for(auto it:edges)
            {
               int u=it[0];
               int v=it[1];
               int wt=it[2];
               if(distance[u]+wt<distance[v])
               {
                return wrong;
                distance[v]=distance[u]+wt;
               }
            }
        return distance;
    }
}