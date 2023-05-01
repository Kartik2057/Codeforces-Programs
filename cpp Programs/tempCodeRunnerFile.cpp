#include<bits/stdc++.h>
using namespace std;

class Shape {
public:
    virtual double getSurfaceArea() = 0;
    virtual double getRate() = 0;
};

class Square : public Shape {
private:
    double side;
public:
    Square(double s) : side(s) {}
    double getSurfaceArea() { return side * side; }
    double getRate() { return 50.0; }
};

class Triangle : public Shape {
private:
    double base, height;
public:
    Triangle(double b, double h) : base(b), height(h) {}
    double getSurfaceArea() { return 0.5 * base * height; }
    double getRate() { return 75.0; }
};

class Circle : public Shape {
private:
    double radius;
public:
    Circle(double r) : radius(r) {}
    double getSurfaceArea() { return M_PI * radius * radius; }
    double getRate() { return 100.0; }
};

class Rectangle : public Shape {
private:
    double length, width;
public:
    Rectangle(double l, double w) : length(l), width(w) {}
    double getSurfaceArea() { return length * width; }
    double getRate() { return 50.0; }
};

class CustomShape : public Shape {
private:
    Shape* shape1;
    Shape* shape2;
public:
    CustomShape(Shape* s1, Shape* s2) : shape1(s1), shape2(s2) {}
    double getSurfaceArea() { return shape1->getSurfaceArea() + shape2->getSurfaceArea(); }
    double getRate() { return 50.0; }
};

class Order {
private:
    vector<Shape*> shapes;
public:
    void addShape(Shape* shape) {
        if (shapes.size() < 5) {
            shapes.push_back(shape);
        }
    }
    double calCostOrder() {
        double totalCost = 0.0;
        for (Shape* shape : shapes) {
            totalCost += shape->getSurfaceArea() * shape->getRate();
        }
        return totalCost;
    }
};

int main() {
    Order orders[6];
    orders[0].addShape(new Square(5.0));
    orders[0].addShape(new Triangle(6.0, 4.0));
    orders[0].addShape(new Circle(3.0));
    orders[0].addShape(new Rectangle(8.0, 3.0));
    orders[1].addShape(new Circle(4.0));
    orders[1].addShape(new Square(4.0));
    orders[2].addShape(new CustomShape(new Square(3.0), new Triangle(4.0, 5.0)));
    orders[2].addShape(new Rectangle(6.0, 2.0));
    orders[3].addShape(new Triangle(8.0, 5.0));
    orders[3].addShape(new Circle(2.5));
    orders[4].addShape(new Rectangle(5.0, 7.0));
    orders[5].addShape(new Circle(6.0));
    orders[5].addShape(new Square(3.0));
    for (int i = 0; i < 6; i++) {
        double cost = orders[i].calCostOrder();
        cout << "Cost of order " << i+1 << ": Rs " << cost << endl;
    }
    double totalCost = 0.0;
}