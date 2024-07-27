#include <iostream>
using namespace std;

void sort(int AT[], int process[], int BT[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (AT[i] > AT[j])
            {
                swap(AT[i], AT[j]);
                swap(process[i], process[j]);
                swap(BT[i], BT[j]);
            }
        }
    }
}
void find_TAT(int process[], int n, int BT[], int AT[])
{
    int CT[n];
    int TAT[n];
    int time = AT[0];
    for (int i = 0; i < n; i++)
    {
        time = time + BT[i];
        CT[i] = time;
        TAT[i] = CT[i] - AT[i];
    }
    float s1 = 0;
    float s2 = 0;
    cout << "Process_Id"<<' '<< "Completion Time"<<' '<< "Turnaround Time"<<' '<< "Waiting Time"<< endl;
    for (int i = 0; i < n; i++){
        cout << process[i] <<"\t\t"<< CT[i] <<"\t\t"<< TAT[i] <<"\t\t"<< TAT[i] - BT[i] <<"\t\t"<< endl;
        s1 += TAT[i];
        s2 += TAT[i] - BT[i];
    }
    cout << "Average Turnaround Time - " << s1 / n << endl;
    cout << "Average Waiting Time - " << s2 / n;
}
int main()
{
    int n;
    cout << "Enter the number of process: ";
    cin >> n;
    int process[n];
    for (int i = 0; i < n; i++)
        process[i] = i + 1;
    int BT[n], AT[n];
    cout << "Enter Arrival time and Burst time for the process:" << endl;
    for (int i = 0; i < n; i++)
        cin >> AT[i] >> BT[i];
    sort(AT, process, BT, n);
    find_TAT(process, n, BT, AT);
    return 0;
}