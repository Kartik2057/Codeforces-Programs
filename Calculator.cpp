#include <bits/stdc++.h>
using namespace std;
class Calculator
{
    public:
double addition(int a, int b) {
    return static_cast<double>(a + b);
}

double addition(double a, int b) {
    return a + static_cast<double>(b);
}

double division(int a, int b) {
    return static_cast<double>(a) / static_cast<double>(b);
}

double division(double a, int b) {
    return a / static_cast<double>(b);
}
double subtraction(int a, int b) {
    return static_cast<double>(a - b);
}

double subtraction(double a, int b) {
    return a - static_cast<double>(b);
}

double multiplication(int a, int b) {
    return static_cast<double>(a * b);
}

double multiplication(double a, int b) {
    return a * static_cast<double>(b);
}
};

int main() {
    int choice;

do{
    std::cout << "Enter 1 for addition of two integers: " << std::endl;
    std::cout << "Enter 2 for subtraction of two integers: " << std::endl;
    std::cout << "Enter 3 for multiplication of two integers: " << std::endl;
    std::cout << "Enter 4 for division of two integers: " << std::endl;
    std::cout << "Enter 5 for addition of one integer and one double: " << std::endl;
    std::cout << "Enter 6 for subtraction of one integer and one double: " << std::endl;
    std::cout << "Enter 7 for multiplication of one integer and one double: " << std::endl;
    std::cout << "Enter 8 for division of one integer and one double: " << std::endl;
    std::cout << "Enter 9 for exit " << std::endl;
    cin >> choice;

    Calculator calc;
    int a, b;
    double p;

    switch (choice) {
        case 1:
            std::cout << "Enter two integers: ";
            cin >> a >> b;
            p = calc.addition(a, b);
            std::cout << "p: " << p << std::endl;
            break;
        case 2:
            std::cout << "Enter two integers: ";
            cin >> a >> b;
            p = calc.subtraction(a, b);
            std::cout << "p: " << p << std::endl;
            break;
        case 3:
            std::cout << "Enter two integers: ";
            cin >> a >> b;
            p = calc.multiplication(a, b);
            std::cout << "p: " << p << std::endl;
            break;
        case 4:
            std::cout << "Enter two integers: ";
            cin >> a >> b;
            if(b==0)
            {
                cout<<"divide by zero not possible"<<endl;
                continue;
            }
            p = calc.division(a, b);
            std::cout << "p: " << p << std::endl;
            break;
        case 5:
            std::cout << "Enter an integer and a double: ";
            cin >> a >> p;
            p = calc.addition(p, a);
            std::cout << "p: " << p << std::endl;
            break;
        case 6:
            std::cout << "Enter an integer and a double: ";
            cin >> a >> p;
            p = calc.subtraction(p, a);
            std::cout << "p: " << p << std::endl;
            break;
        case 7:
            std::cout << "Enter an integer and a double: ";
            cin >> a >> p;
            p = calc.multiplication(p, a);
            std::cout << "p: " << p << std::endl;
            break;
        case 8:
            std::cout << "Enter an integer and a double: ";
            cin >> a >> p;
            if(b==0)
            {
                cout<<"divide by zero not possible"<<endl;
                continue;
            }
            p = calc.division(p, a);
            std::cout << "p: " << p << std::endl;
            break;
        case 9:
            break;
        default:
            std::cout << "Invalid choice!" << std::endl;
    }
}while(choice!=9);
    return 0;
}