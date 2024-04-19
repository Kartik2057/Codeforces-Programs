#include <bits/stdc++.h>
using namespace std;

class Solution {
    void helper(
        unordered_map<int,list<pair<int,int>>> &adj,
        vector<int> &distance,
        set<pair<int,int>> &s
    ){
        while (!s.empty())
        {
           pair<int, int> p=*(s.begin());
           s.erase(p);
           int frontNode = p.second;
           int wt = p.first;
           for(auto it:adj[frontNode]){
               int tempNode = it.first;
               int tempWt = it.second;
               if(wt+tempWt<distance[tempNode])
               {
                if(distance[tempNode]!=1e9)
                s.erase({distance[tempNode],tempNode});
                distance[tempNode] = wt+tempWt;
                s.insert({distance[tempNode],tempNode});
               }
           }
        }  
    }

public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        unordered_map<int,list<pair<int,int>>> adj;
        vector<int> distance(n+1,1e9);
        set<pair<int,int>> s;
        int ans=INT_MIN;

        distance[k]=0;
        distance[0]=0;
        for(int i=0;i<times.size();i++){
            int u=times[i][0];
            int v=times[i][1];
            int wt=times[i][2];
            adj[u].push_back({v,wt});
        }
        s.insert({0,k}); 
        helper(adj,distance,s);
        
        for(auto it:distance){
            if(it==1e9)
            {
                ans=-1;
                break;
            }
            ans=max(ans,it);
        }
        return ans;
    }
};