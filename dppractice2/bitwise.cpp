// C++ program to overload Bitwise AND (&) operator
#include <iostream>
using namespace std;

class Bitwise {
private:
	int value;

public:
	// Non-parameterized constructor
	Bitwise() {}

	// parameterized constructor
	Bitwise(int v) { value = v; }

	// This is automatically called
	// when '&' operator is
	// used between b1 and b2.
	Bitwise operator&(const Bitwise& b)
	{
		Bitwise obj;
		obj.value = value & b.value;
		return obj;
	}

	// method to display value
	void print()
	{
		cout << "value of (b1 & b2) is: " << value << endl;
	}
};

int main()
{
	// Assigning by overloading constructor
	Bitwise b1(1), b2(0);
	Bitwise b3;

	// overloading & operator and storing the result in b3
	b3 = b1 & b2; // b3=b1.&(b2);
	b3.print();
	return 0;
}
