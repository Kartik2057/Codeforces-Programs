#include <bits/stdc++.h>
using namespace std;
void completionTime(int num, int arr[][7], int time_quanta)
{
    int j = 0, time = 0;
    while (j < num)
    {
        bool temp = true;
        for (int i = 0; i < num; i++)
        {
            if (arr[i][1] <= time && arr[i][2] > 0)
            {
                if (arr[i][2] <= time_quanta)
                {
                    j++;
                    time += arr[i][2];
                    arr[i][3] = time;
                    arr[i][5] = arr[i][3] - arr[i][1];
                    arr[i][4] = arr[i][5] - arr[i][6];
                    arr[i][2] = 0;
                }
                else
                {
                    time += time_quanta;
                    arr[i][2] -= time_quanta;
                }
                temp = false;
            }
        }
        if (temp)
            time++;
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
    }
    for (int i = 0; i < num; i++)
    {
        //Keeping copy of original waiting time
        arr[i][6] = arr[i][2];
    }
    int time_quanta;
    cout << "Please Enter value of Time Quanta - ";
    cin >> time_quanta;
    completionTime(num, arr, time_quanta);
    cout << "Final Result...\n";
    cout << "Process ID\tArrival Time\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time\n ";
        for (int i = 0; i < num; i++)
            cout
         << arr[i][0] << "\t\t" << arr[i][1] << "\t\t" << arr[i][6] << "\t\t" << arr[i][3] << "\t\t" << arr[i][4] << "\t\t" << arr[i][5] << "\n";
    for (int i = 0; i < num; i++)
        avg_wt += arr[i][4];
    for (int i = 0; i < num; i++)
        avg_tat += arr[i][5];
    cout << "Average Waiting time - " << avg_wt / num << endl;
    cout << "Average Turnaround time - " << avg_tat / num << endl;
}