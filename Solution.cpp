#include "bits/stdc++.h"

class Solution {
    vector<vector<pair<int,int>>> al;
public:
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        for(auto it:edges){
            al[it[0]].push_back(it[1]);
        }
        
    }
};