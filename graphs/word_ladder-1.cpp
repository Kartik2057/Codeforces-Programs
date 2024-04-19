#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int wordLadderLength(string startWord, string targetWord, vector<string>& wordList) {
        unordered_set<string> set(wordList.begin(),wordList.end());
        if(set.find(startWord)!=set.end())
        set.erase(startWord);
        queue<pair<string,int>> q;
        q.push({startWord,1});
        int m=wordList.size();
        int n=startWord.length();
        string temp=startWord,copy=startWord;
        bool exists=0;
        int counter=1;
        int level=0;
        while (!q.empty())
        {
        pair<string,int> p = q.front();    
        temp=p.first;
        level=p.second;
        q.pop();
        if(temp==targetWord)
        {
           counter=level;
           exists=1;
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
               set.erase(copy);
               q.push({copy,level+1});
            }
        }
        }
        if (exists)
        {
            return counter;
        }
        else
        return 0;
    }
};