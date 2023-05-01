#include <bits/stdc++.h>
using namespace std;

int main()
{
    long long t;
    cin >> t;
    while (t-- )
    {
        // Vector <Pair> = new Vector<>();
        int n;
        long long x;
        cin >> n >> x;
        long long arr[n];
        long long pre[n];
        long long back[n];
        vector<pair <int,int>>vect;
        set<int> s;
        long long low=LONG_LONG_MAX;
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
            pre[i]= arr[i] + (i + 1);
        }
        int add=1;
        for (int i = n-1; i >=0; i--)
        {
            back[i] = arr[i]+add;
            add++;
        }
        for(int i=0;i<n;i++)
        {
            vect.push_back(make_pair(pre[i],i));
            vect.push_back(make_pair(back[i],i));
        }
        sort(vect.begin(),vect.end());
        // sort(arr, arr + n);
        int j = 0, res = 0;
        bool flag=false;
        while (j < vect.size() && x>=vect[j].first)
        {
            if(s.find(vect[j].second)!=s.end())
            {
                j++;
                continue;
            }
            s.insert(vect[j].second);
            x -= vect[j].first;
            if(pre[vect[j].second]==vect[j].first)
            flag=true;
            j += 1;
            res += 1;
        }
        if((!flag) && res>0)
        {
            // cout<<"hi";
            int index=j;
            while(index<vect.size() && pre[vect[index].second]!=vect[index].first)
            index++;
            if(index<vect.size())
            x=vect[index].first-x;//remaining amount to be created
            j--;
            flag=false;
            while(j>=0&&x>0)
            {
                flag=true;
            // cout<<"he";
                res--;
                x-=vect[j].first;
                j--;
            }
            if(flag && x<=0)
            res++;
            else
            res=0;            
        }
        cout << res << endl;
    }
    return 0;
}