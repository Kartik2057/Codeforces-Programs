#include <bits/stdc++.h>
using namespace std;

public class Employee{
    private:
    String name;
    double salary;
    public:
    virtual double calculateSalary()=0;
} 

class Manager : public Employee{
    private:
    double manager_bonus;
    public:
    double calculateSalary(){
      salary+=manager_bonus;
      return salary;
    }
}

class Worker : public Employee{
    private:
    double worker_bonus;
    public:
    double calculateSalary(){
      salary+=worker_bonus;
      return salary;
    }
}

int main{

    Employee* p;
    Manager m;
    Worker w;
    p=&m;
    p-
    p->calculateSalary
    return 0;
}