class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> temp_set(wordList.begin(),wordList.end());
        vector<vector<string>> ans;
        vector<string> usedOnLevel;
        int minsize=INT_MAX;
        usedOnLevel.push_back(beginWord);
        queue<vector<string>> q;
        q.push({beginWord});
        int n=beginWord.length(); 
        string temp;
        int counter=1,level=0;
        while (!q.empty())
        {
        vector<string> temp_List = q.front();
        string temp = temp_List.back();
        int length = temp_List.size();   
        q.pop();
        if(length>level)
        {
            level++;
            for(auto it:usedOnLevel)
            {
                temp_set.erase(it);
            }
            usedOnLevel.clear();
        }
        if(length>minsize)
        break;
        
        for (int  i = 0; i < n; i++)
        {
            char original=temp[i];
            for(char j='a';j<='z';j++)
            {
               temp[i]=j;
               if(temp_set.find(temp)==temp_set.end())   
               continue;
               temp_List.push_back(temp);
               usedOnLevel.push_back(temp);
               q.push(temp_List);
               if(temp==endWord)
               {
                if(ans.empty())
                {
                    ans.push_back(temp_List);
                    minsize=length;
                }
                else if(ans.back().size()==temp_List.size())
                    ans.push_back(temp_List);
                else
                    break;
                }
               temp_List.pop_back();
            }
            temp[i]=original;
        }
        }
        return ans;
    }
};