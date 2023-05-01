#include <bits/stdc++.h>
#include <iostream>
#define ll long long int
using namespace std;


class Account{
    private:
    int accountnumber;
    double balance;
    
    Account operator+(Account const& obj)
    {
        this->balance+=obj.balance;
        return this->balance;
    }

    Account operator-(Account const& obj)
    {
        this->balance-=obj.balance;
        return this->balance;
    }

    Account operator>(Account const& obj)
    {
        if(this->balance>obj.balance)
        return true;
        else
        return false;
    }

    Account operator<(Account const& obj)
    {
        if(this->balance<obj.balance)
        return true;
        else
        return false;
    }
}


class Customer{
    String firstName;
    String lastName;
    vect<Account> vect;

    friend std::ostream& operator<<(std::ostream& os, Customer &obj);
    friend std::ostream& operator>>( std::istream& is, Customer &obj);
}

class Employee{
    String firstName;
    String lastName;
    String employeeID;
    
    void view(Account &acc){
      cout<<acc.accountnumber<<endl;
      cout<<acc.balance<<endl;
    }

    void close(Account &acc){
      delete(acc);
    }

    void transfer(Account &acc){
        
    }  
}

std::ostream& operator<<(std::ostream& os, Customer &obj)
{
   os<<obj.firstname<<endl;
   os<<obj.lastname<<endl;
   return os;
}

std::istream& operator>>(std::istream& is, Customer &obj)
{
   is<<obj.firstname<<endl;
   is<<obj.lastname<<endl;
   return os;
}

int main() {
    cout<<"Welcome to bank Account System"<<endl;
    cout<<"Enter 1 to enter 0 to exit"<<endl;
    int test,choice;
    cin>>test>>endl;
    while(test==1)
    {
    cout<<"Enter 1 to create account"<<endl;
    cout<<"Enter 2 to deposit money"<<endl;
    cout<<"Enter 3 to withdraw money"<<endl;
    cout<<"Enter 4 to check balance"<<endl;
    cout<<"Enter 5 to view account info"<<endl;
    cout<<"Enter 6 to close account"<<endl;
    cout<<"Enter 7 to tranfer funds"<<endl;
    cin>>choice>>endl;
    if(choice==1){
       Customer c1;
       cin>>c1;
    }
    else if(choice==2){
        
    }
    else if(choice==3){

    }
    else if(choice==4){

    }
    else if(choice==5){

    }
    else if(choice==6){

    }
    else if(choice==7){

    }
    else{
        cout<<"Invalid choice"<<endl;
    }

    }
return 0;
}