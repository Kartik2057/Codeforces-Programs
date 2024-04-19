// C++ program for ! Operator overloading

#include <iostream>
using namespace std;
class A {
private:
	int a;

public:
	// parameterized constructor
	A(int l) { a = l; }

	// This is automatically called
	// when ! operator is
	// used with object
	bool operator!()
	{
		a = !a;
		if (a)
			return true;
		else
			return false;
	}
};

// Driver Code
int main()
{
	// Assigning by overloading constructor
	A a1(7), a2(0);

	// Overloading ! Operator
	if (!a1) {
		cout << "a1 value is zero" << endl;
	}
	else {
		cout << "a1 value is non-zero" << endl;
	}

	if (!a2) {
		cout << "a2 value is zero" << endl;
	}
	else {
		cout << "a2 value is non-zero" << endl;
	}
}
