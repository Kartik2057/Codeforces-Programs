#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct Process {
    int pid;
    int arrival_time;
    int burst_time;
    int remaining_time;
    int completion_time;
    int waiting_time;
    int turn_around_time;
};

int main() {
    int n=4, quantum=2;

    vector<Process> processes(n);
    queue<int> ready_queue;

    cout << "Enter the arrival time and burst time of each process:\n";
    for (int i = 0; i < n; i++) {
        processes[i].pid = i + 1;
        cin >> processes[i].arrival_time >> processes[i].burst_time;
        processes[i].remaining_time = processes[i].burst_time;
    }

    int current_time = 0;
    int completed_processes = 0;
    float total_waiting_time = 0, total_turn_around_time = 0;

    while (completed_processes < n) {
        for (int i = 0; i < n; i++) {
            if (processes[i].arrival_time <= current_time && processes[i].remaining_time > 0) {
                ready_queue.push(i);
            }
        }

        if (ready_queue.empty()) {
            current_time++;
            continue;
        }

        int pid = ready_queue.front();
        ready_queue.pop();

        if (processes[pid].remaining_time > quantum) {
            current_time += quantum;
            processes[pid].remaining_time -= quantum;
        } else {
            current_time += processes[pid].remaining_time;
            processes[pid].remaining_time = 0;
            processes[pid].completion_time = current_time;
            completed_processes++;
        }

        for (int i = 0; i < n; i++) {
            if (processes[i].arrival_time <= current_time && processes[i].remaining_time > 0 && i != pid) {
                ready_queue.push(i);
            }
        }
    }

    cout << "\nProcess\tArrival Time\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time\n";
    for (int i = 0; i < n; i++) {
        processes[i].turn_around_time = processes[i].completion_time - processes[i].arrival_time;
        processes[i].waiting_time = processes[i].turn_around_time - processes[i].burst_time;
        total_waiting_time += processes[i].waiting_time;
        total_turn_around_time += processes[i].turn_around_time;
        
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
