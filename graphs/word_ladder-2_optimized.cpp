#include <bits/stdc++.h>
using namespace std;

class Solution{
  private:  
  void helper(
    int n,
    int length,
    vector<vector<string>> &ans, 
    vector<string> &recurList,
    unordered_map<string,int> &recurLadder){
     if(length==0)
     {
       reverse(recurList.begin(), recurList.end());
       ans.push_back(recurList); 
       reverse(recurList.begin(), recurList.end());
       return;
     }
     string temp=recurList.back();
     string copy=temp;
      for (int  i = 0; i < n; i++)
        {
            copy=temp;
            for(char j='a';j<='z';j++)
            {
               copy[i]=j;
            //    if(copy=="aaaaa")
            //    cout<<"exists"<<endl;
               if(recurLadder.find(copy)==recurLadder.end())
               continue;
               else if(recurLadder[copy]==length)
               {
                recurList.push_back(copy);
                // cout<<copy<<" "<<length<<" "<<recurList.size()<<endl;
                helper(n,length-1,ans,recurList,recurLadder);
                recurList.pop_back();
               }
            }
        }
  }

  public:
  vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList){
    unordered_set<string> set(wordList.begin(),wordList.end());
    unordered_map<string,int> recurLadder;
    vector<vector<string>> ans;
    vector<string> recurList;
    recurLadder[beginWord] = 1;
    recurList.push_back(endWord);
    queue<pair<string,int>> q;
    if(set.find(beginWord)!=set.end())
    set.erase(beginWord);
        int m=wordList.size();
        int n=beginWord.length();
        string temp,copy;
        int counter=0;
        int level=0;
        q.push({beginWord,1});
        while (!q.empty())
        {
        pair<string,int> p = q.front();    
        temp=p.first;
        level=p.second;
        q.pop();
        if(temp==endWord)
        {
           counter=level;
           break;
        }
        for (int  i = 0; i < n; i++)
        {
            copy=temp;
            for(int j=97;j<=122;j++)
            {
               copy[i]=(char)j;
               if(set.find(copy)==set.end())
               continue;
            //    cout<<copy<<" "<<level<<endl;
               set.erase(copy);
               recurLadder[copy] = level+1; 
               q.push({copy,level+1});
            }
        }
        }
        // cout<<"hello"<<endl;
        if(counter!=0)
        helper(n,counter-1,ans,recurList,recurLadder);
        return ans;    
  }
};