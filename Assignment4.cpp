#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Process {
    int pid;
    int arrival_time;
    int burst_time;
    int completion_time;
    int waiting_time;
    int turn_around_time;
};

bool compareArrival(Process a, Process b) {
    return a.arrival_time < b.arrival_time;
}

bool compareBurst(Process a, Process b) {
    return a.burst_time < b.burst_time;
}

int main() {
    int n;
    cout << "Enter the number of processes: ";
    cin >> n;

    vector<Process> processes(n);
    cout << "Enter the arrival time and burst time of each process:\n";
    for (int i = 0; i < n; i++) {
        processes[i].pid = i + 1;
        cin >> processes[i].arrival_time >> processes[i].burst_time;
    }

    sort(processes.begin(), processes.end(), compareArrival);

    int current_time = 0;
    float total_waiting_time = 0, total_turn_around_time = 0;

    for (int i = 0; i < n; i++) {
        if (current_time < processes[i].arrival_time) {
            current_time = processes[i].arrival_time;
        }

        processes[i].waiting_time = current_time - processes[i].arrival_time;
        processes[i].completion_time = current_time + processes[i].burst_time;
        processes[i].turn_around_time = processes[i].waiting_time + processes[i].burst_time;

        current_time = processes[i].completion_time;
        total_waiting_time += processes[i].waiting_time;
        total_turn_around_time += processes[i].turn_around_time;
    }
    sort(processes.begin(), processes.end(), compareBurst);


    cout << "\nProcess\tArrival Time\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time\n";
    for (int i = 0; i < n; i++) {
        cout << processes[i].pid << "\t\t" << processes[i].arrival_time << "\t\t" << processes[i].burst_time
             << "\t\t" << processes[i].completion_time << "\t\t" << processes[i].waiting_time << "\t\t"
             << processes[i].turn_around_time << endl;
    }

    float average_waiting_time = total_waiting_time / n;
    float average_turn_around_time = total_turn_around_time / n;

    cout << "\nAverage Waiting Time: " << average_waiting_time << endl;
    cout << "Average Turnaround Time: " << average_turn_around_time << endl;

    return 0;
}
