#include <iostream>
using namespace std;

void arrangeArrival(int num, int arr[][6])
{
    for (int i = 0; i < num; i++)
    {
        for (int j = 0; j < num - i - 1; j++)
        {
            if (arr[j][1] > arr[j + 1][1])
            {
                for (int k = 0; k <=5; k++)
                {
                    swap(arr[j][k], arr[j + 1][k]);
                }
            }
        }
    }
}
void completionTime(int num, int arr[][6])
{
    int temp, val;
    for (int i = 0; i < num; i++)
    {
        temp = i>0?arr[i - 1][3]:arr[i][1];
        int low = arr[i][2];
        for (int j = i; j < num; j++)
        {
            if (temp >= arr[j][1] && low >= arr[j][2])
            {
                low = arr[j][2];
                val = j;
            }
        }
        arr[val][3] = temp + arr[val][2];
        arr[val][5] = arr[val][3] - arr[val][1];
        arr[val][4] = arr[val][5] - arr[val][2];
        for (int k = 0; k < 6; k++)
        {
            swap(arr[val][k], arr[i][k]);
        }
    }
}
int main()
{
    int num, temp;
    cout << "Enter number of Processes - ";
    cin >> num;
    int arr[num][6];
    //0->process_id,1->AT,2->BT,3->CT,4->TAT,5->WT
    cout << "Enter Process Id, Arrival time and Burst time - " << endl;
    for (int i = 0; i < num; i++)
    {
        cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
    }
    arrangeArrival(num, arr);
    completionTime(num, arr);
    cout << "Final Result...\n";
    cout << "Process ID\tArrival Time\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time\n ";
        for (int i = 0; i < num; i++)
    {
        cout << arr[i][0] << "\t\t" << arr[i][1] << "\t\t" << arr[i][2] << "\t\t" << arr[i][3]
             << "\t\t" << arr[i][4] << "\t\t" << arr[i][5] << "\n";
    }
    float avg_wt = 0;
    float avg_tat = 0;
    for (int i = 0; i < num; i++)
        avg_wt += arr[i][4];
    for (int i = 0; i < num; i++)
        avg_tat += arr[i][5];
    cout << "Average Waiting time - " << avg_wt / num << endl;
    cout << "Average Turnaround time - " << avg_tat / num << endl;
}