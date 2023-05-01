#include <bits/stdc++.h>
#define ll long long int
using namespace std;
//int mod = 1e9+7;
class Rod{
    public:
    ll len, beauty;
};
bool check(Rod &a, Rod &b)
{
    return a.beauty*b.len < b.beauty*a.len;
}
int main() {
    ll test;
    cin>>test;
    while(test--)
    {
        ll n;
        cin>>n;
        vector<Rod> rods(n);
        for(int i=0; i<n; i++)
        cin>>rods[i].len;
        for(int i=0; i<n; i++)
        cin>>rods[i].beauty;
        ll ans = 0,len = 0;
        sort(rods.begin(), rods.end(), check);
        for(int i=0; i<n; i++)
        {
            ans += (len * rods[i].beauty);
            len += rods[i].len;
        }
        cout<<ans<<"\n";
        
    }
return 0;
}