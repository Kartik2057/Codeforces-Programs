#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
int longestCommonSubsequence(string& text1, string& text2)
{
    int n = text1.size();
    int m = text2.size();
 
    // initializing 2 vectors of size m
    vector<int> prev(m + 1, 0), cur(m + 1, 0);
 
    for (int idx2 = 0; idx2 < m + 1; idx2++)
        cur[idx2] = 0;
 
    for (int idx1 = 1; idx1 < n + 1; idx1++) {
        for (int idx2 = 1; idx2 < m + 1; idx2++) {
            // if matching
            if (text1[idx1 - 1] == text2[idx2 - 1])
                cur[idx2] = 1 + prev[idx2 - 1];
 
            // not matching
            else
                cur[idx2]
                    = 0 + max(cur[idx2 - 1], prev[idx2]);
        }
        prev = cur;
    }
 
    return cur[m];
}
    string longestPalindrome(string s) {
        int len = longestCommonSubsequence(s,s.)
    }
};