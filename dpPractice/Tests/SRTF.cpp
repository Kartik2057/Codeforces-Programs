#include <bits/stdc++.h>
using namespace std;
void arrangeArrival(int num, int arr[][7])
{
    for (int i = 0; i < num; i++)
    {
        for (int j = 0; j < num - i - 1; j++)
        {
            if (arr[j][1] > arr[j + 1][1])
            {
                for (int k = 0; k < 3; k++)
                {
                    swap(arr[j][k], arr[j + 1][k]);
                }
            }
        }
    }
}
void completionTime(int num, int arr[][7])
{
    int mn = INT_MAX;
    int i = 0;
    int j = 0;
    int val = -1;
    int finish;
    int time;
    for (time = arr[0][1]; j < num; time++)
    {
        for (i = 0; i < num; i++)
        {
            if (arr[i][1] <= time && arr[i][2] < mn && arr[i][2] > 0)
            {
                val = i;
                mn = arr[val][2];
            }
        }
        arr[val][2]--;
        if (arr[val][2] == 0)
        {
            j++;
            finish = time + 1;
            arr[val][3] = finish;
            arr[val][5] = arr[val][3] - arr[val][1];
            arr[val][4] = arr[val][5] - arr[val][6];
            mn = INT_MAX;
        }
    }
}
int main()
{
    int num;
    cout << "Enter number of Processes - ";
    cin >> num;
    int arr[num][7];
    float avg_wt = 0;
    float avg_tat = 0;
    cout << "Enter Process Id, Arrival time and Burst time - " << endl;
    for (int i = 0; i < num; i++)
    {
        cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
        arr[i][6] = arr[i][2];
    }
    // cout << "Process ID\tArrival Time\tBurst Time\n";
    // for (int i = 0; i < num; i++)
    //     cout << arr[i][0] << "\t\t" << arr[i][1] << "\t\t" << arr[i][2] << "\n";
    arrangeArrival(num, arr);
    completionTime(num, arr);
    cout << "Final Result...\n";
    cout << "Process ID\tArrival Time\tBurst Time\tCompletion Time\tWaitingTime\tTurnaround Time\n ";
        for (int i = 0; i < num; i++)
            cout<< arr[i][0] << "\t\t" << arr[i][1] << "\t\t" << arr[i][6] << "\t\t" << arr[i][3] << "\t\t" << arr[i][4] << "\t\t" << arr[i][5] << "\n";
    for (int i = 0; i < num; i++)
        avg_wt += arr[i][4];
    for (int i = 0; i < num; i++)
        avg_tat += arr[i][5];
    cout << "Average Waiting time - " << avg_wt / num << endl;
    cout << "Average Turnaround time - " << avg_tat / num << endl;
}