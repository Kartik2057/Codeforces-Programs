#include <bits/stdc++.h>
using namespace std;

class Solution1
{   
public:
    vector<vector<string>> accountsMerge(vector<vector<string>> &accounts) {
        unordered_map<string,int> map;
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts[i].size();j++)
            {
                if(map.find(accounts[i][j])==map.end())
                {
                    map[accounts[i][j]]=i;
                }
            }
        }

    }
};
