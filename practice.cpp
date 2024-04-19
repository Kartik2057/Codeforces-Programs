#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> getCacheSize(vector<vector<int>>& data, vector<int>& queries) {
    int n = data.size();
    int q = queries.size();

    // Create a vector to store the start and end times of each data point
    vector<pair<int, int>> cache_times;

    // Initialize the cache size at each query time
    vector<int> cache_sizes;

    // Process each data point and update the cache_times vector
    for (int i = 0; i < n; ++i) {
        int start_time = data[i][0];
        int ttl = data[i][1];
        int end_time = start_time + ttl;
        cache_times.push_back({start_time, end_time});
    }

    // Sort the cache_times vector based on the end time
    sort(cache_times.begin(), cache_times.end(), [](const auto& a, const auto& b) {
        return a.second < b.second;
    });

    // Process each query and count the number of data points in the cache
    for (int i = 0; i < q; ++i) {
        int query_time = queries[i];
        int count = 0;
        for (const auto& time_interval : cache_times) {
            int start_time = time_interval.first;
            int end_time = time_interval.second;
            if (start_time <= query_time && query_time <= end_time) {
                count++;
            }
        }
        cache_sizes.push_back(count);
    }

    return cache_sizes;
}

int main() {
    // Sample Input
    vector<vector<int>> data = {{105231, 183}, {105334, 34}, {105198, 543}};
    vector<int> queries = {105338, 105410};

    // Sample Output
    vector<int> output = getCacheSize(data, queries);

    // Print the output
    for (int count : output) {
        cout << count << " ";
    }
    cout << endl;

    return 0;
}