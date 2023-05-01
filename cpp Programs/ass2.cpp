#include <bits/stdc++.h>
using namespace std;

class item{
  public:
  string name;
  int* number;
  static float cost;
  public:

    // void getdata(string,int,float);

    // void inc(item &obj){
    //     name=obj.name;
    //     number=new int;
    //     *number=*(obj.number);
    //     cost=obj.cost;
    // }

    // void printdata(){
    //     // cout<<"hello world";
    //     cout<<name<<*number<<" "<<cost<<endl;
    // }
    // item(){
    //    name="hello";
    //    number= new int;
    //    *number=10;
    //    cost=2.3;
    // }
    // item(string st,int numb, float cost){
    //     name=st;
    //     *number=numb;
    //     this->cost=cost;
    // }
    // ~item(){
    //     cout<<"Destructor is called for: "<<name<<endl;
    // }
};

float item:: cost=5.6;
int main(){
//   item* i=new item(12,7.1);
  // item i2,i3;
  // i2.getdata("ramesh",13,6.7);
  // i3.getdata("su",14,9.7);
  // item i1=item(i2);
  // i1.printdata();
  cout<<item::cost<<endl;
  // item i3=i2;//shallow copy
  // i3.inc(i3);
  // cout<<"i2 contains: ";
  // i2.printdata();
  // cout<<endl;
  // cout<<"i3 contains: ";
  // i3.printdata();
  // cout<<endl;
//   i.getdata(12,7.1); 
//   i.inc(i);
//   i.printdata();
  return 0;
}

// void item::getdata(string st,int a, float b)
// {  
//  name=st; 
// *number = a;
// cost = b;
// cout<<*number <<" "<<cost<<endl;
// }

